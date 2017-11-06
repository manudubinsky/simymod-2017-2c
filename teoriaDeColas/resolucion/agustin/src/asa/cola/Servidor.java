package asa.cola;

import java.util.Random;

public class Servidor implements Runnable {

	private static int ID = 0;
	
	private int id;
	private boolean ocupado;
	private int atendidos;
	private double acumTiempoAtencion;
	private double lambda;
	private Cola entrada;
	private Cola salida;
	private Random rand;

	public Servidor(Cola entrada, Cola salida, double lambda) {
		this.id = ++ID;
		this.ocupado = false;
		this.entrada = entrada;
		this.salida = salida;
		this.lambda = lambda;
		this.atendidos = 0;
		this.acumTiempoAtencion = 0.0;
		this.rand = new Random(System.currentTimeMillis() * id);
	}

	@Override
	public void run() {
		while (!entrada.isFin()) {
			try {
				ocupado = false;
				Cliente cliente = entrada.take();
				ocupado = true;
				cliente.setTiempoAtencion(System.currentTimeMillis());
				Thread.sleep(_getTiempoAtencion());
				cliente.setTiempoSalida(System.currentTimeMillis());
				atendidos++;
				salida.put(cliente);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public int getId() {
		return id;
	}

	public int getAtendidos() {
		return atendidos;
	}

	public double getPromedioAtencion() {
		return atendidos != 0 ? acumTiempoAtencion / (atendidos * 1000) : 0.0;
	}

	private long _getTiempoAtencion() {
		long time = Math.round(1000 * Math.log(1 - rand.nextDouble()) / (-lambda));
		acumTiempoAtencion += time;
		return time;
	}
}
