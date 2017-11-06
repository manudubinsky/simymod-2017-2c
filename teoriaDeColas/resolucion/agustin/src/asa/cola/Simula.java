package asa.cola;

import java.util.ArrayList;
import java.util.List;

public class Simula {

	private Cola salida;
	private List<Thread> listThread;
	private List<SistemaCola> listSistema;

	public Simula(boolean unica, double lambda, double[] mu)
		throws InterruptedException
	{
		Thread thSist;
		SistemaCola sistema;
		this.salida = new Cola();
		this.listThread = new ArrayList<>();
		this.listSistema = new ArrayList<>();
		if (!unica) {
			int S = mu.length;
			double lambdaS = lambda / S;
			for (double muS : mu) {
				sistema = new SistemaCola(lambdaS, salida, muS);
				thSist = new Thread(sistema);
				listSistema.add(sistema);
				listThread.add(thSist);
			}
		} else {
			sistema = new SistemaCola(lambda, salida, mu);
			thSist = new Thread(sistema);
			listSistema.add(sistema);
			listThread.add(thSist);
		}

		Estadisticas estadisticas = new Estadisticas(this);
		Thread thEst = new Thread(estadisticas);
		thEst.start();

		Reloj reloj = new Reloj(estadisticas);
		Thread thRel = new Thread(reloj);
		thRel.start();

		for (Thread th : listThread) {
			th.start();
		}
		for (Thread th : listThread) {
			th.join();
		}
		thEst.join();
		reloj.setFin();
	}

	public Cola getSalida() {
		return salida;
	}

	public List<SistemaCola> getListSistema() {
		return listSistema;
	}

	public static void main(String[] args) throws InterruptedException {
		if (args.length >= 3) {
			try {
				boolean unica = args[0].equalsIgnoreCase("U");
				boolean multiple = args[0].equalsIgnoreCase("M");
				if (unica || multiple) {
					double lambda = Double.parseDouble(args[1]);
					double[] mu = new double[args.length - 2];
					for (int i = 2; i < args.length; i++) {
						mu[i - 2] = Double.parseDouble(args[i]);
					}
					new Simula(unica, lambda, mu);
				}
			} catch (Exception e) {
			}
		}
		_printUse();
	}

	private static void _printUse() {
		System.out.println("Uso: java -jar SimulaCola.jar {U|M} lambda uS1 [uS2 uS3 .. uSn]");
		System.out.println("  U: Cola Unica MMS");
		System.out.println("  M: Cola Multiple S * MM1 /// lambdaSn = lambda / S");
		System.exit(1);
	}
}
