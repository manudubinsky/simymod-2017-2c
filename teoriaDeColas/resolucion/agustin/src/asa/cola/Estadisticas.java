package asa.cola;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Estadisticas implements Runnable {
	
	private static DecimalFormat FMT = new DecimalFormat("0.000");

	private Simula simula;

	private int clientesCola;
	private int clientesSistema;
	private int clientesAtendidos;

	private long tick;
	private long acumTiempoPerm;
	private long acumTiempoPermCola;

	private double tiempoPerm;
	private double tiempoPermCola;
	private double acumClientesCola;
	private double acumClientesSistema;
	private double promClientesCola;
	private double promClientesSistema;
	private Map<Integer, Double> probAcum;

	public Estadisticas(Simula simula) {
		this.tick = 0;
		this.simula = simula;
		this.acumTiempoPerm = 0;
		this.acumTiempoPermCola = 0;
		this.clientesAtendidos = 0;
		this.tiempoPerm = 0;
		this.tiempoPermCola = 0;
		this.clientesCola = 0;
		this.clientesSistema = 0;
		this.acumClientesCola = 0.0;
		this.acumClientesSistema = 0.0;
		this.promClientesCola = 0.0;
		this.promClientesSistema = 0.0;
		this.probAcum = new TreeMap<>();
	}

	@Override
	public void run() {
		while (!simula.getSalida().isFin()) {
			try {
				Cliente cliente = simula.getSalida().take();
				acumTiempoPerm += cliente.getTiempoSalida() - cliente.getTiempoLlegada();
				acumTiempoPermCola += cliente.getTiempoAtencion() - cliente.getTiempoLlegada();
				clientesAtendidos++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public long getTick() {
		return tick;
	}

	public void calcularEstadisticas() {
		tick++;
		int ocupados = 0;
		clientesCola = 0;
		for (SistemaCola sistema : simula.getListSistema()) {
			clientesCola += sistema.getEntrada().size();
			for (Servidor oServ : sistema.getListServidor()) {
				if (oServ.isOcupado()) {
					ocupados++;
				}
			}
		}
		clientesSistema = clientesCola + ocupados;
		acumClientesCola += clientesCola;
		acumClientesSistema += clientesSistema;
		probAcum.merge(clientesSistema, 1.0, Double::sum);
	}

	public void imprimirEstadisticas() {
		promClientesCola = acumClientesCola / tick;
		promClientesSistema = acumClientesSistema / tick;
		tiempoPerm = clientesAtendidos > 0 ? acumTiempoPerm / (clientesAtendidos * 1000.0) : 0;
		tiempoPermCola = clientesAtendidos > 0 ? acumTiempoPermCola / (clientesAtendidos * 1000.0) : 0;
		Map<Integer, String> result = probAcum.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, entry -> FMT.format(entry.getValue() / tick)));

		System.out.println(MessageFormat.format("Clientes en Cola: {0}   Prom: {1,number,0.00}", clientesCola, promClientesCola));
		System.out.println(MessageFormat.format("Clientes en Sistema: {0}   Prom: {1,number,0.00}", clientesSistema, promClientesSistema));
		System.out.println(MessageFormat.format("Tiempo en Cola: {0,number,0.00}", tiempoPermCola));
		System.out.println(MessageFormat.format("Tiempo en Sistema: {0,number,0.00}", tiempoPerm));
		if (simula.getListSistema().size() == 1) {
			for (Servidor oServ : simula.getListSistema().get(0).getListServidor()) {
				System.out.println(MessageFormat.format("   Servidor {0}, Atendidos:{1}, Prom. Atención: {2,number,0.00}", oServ.getId(), oServ.getAtendidos(), oServ.getPromedioAtencion()));
			}
		} else {
			for (SistemaCola sistema : simula.getListSistema()) {
				Servidor oServ = sistema.getListServidor().get(0);
				System.out.println(MessageFormat.format("   Servidor {0}, En Cola:{1}, Atendidos:{2}, Prom. Atención: {3,number,0.00}", oServ.getId(), sistema.getEntrada().size(), oServ.getAtendidos(), oServ.getPromedioAtencion()));
			}
		}
		System.out.println();
		System.out.println(MessageFormat.format("Probabilidad: {0}", result));
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
	}
}
