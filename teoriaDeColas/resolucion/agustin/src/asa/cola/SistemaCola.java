package asa.cola;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SistemaCola implements Runnable {

	private double lambda;
	private Random rand;

	private Cola entrada;

	private List<Thread> listThread;
	private List<Servidor> listServidor;

	public SistemaCola(double lambda, Cola salida, double... mu) {

		this.lambda = lambda;
		this.rand = new Random(System.currentTimeMillis());
		this.listThread = new ArrayList<>();
		this.listServidor = new ArrayList<>();
		this.entrada = new Cola();

		Thread thServ;
		Servidor servidor;
		for (double muS : mu) {
			servidor = new Servidor(entrada, salida, muS);
			thServ = new Thread(servidor);
			listServidor.add(servidor);
			listThread.add(thServ);
		}
	}

	@Override
	public void run() {
		try {
			for (Thread th : listThread) {
				th.start();
			}
			for (int i = 0; i < 10000; i++) {
				Thread.sleep(_getTiempoLlegada());
				Cliente cliente = new Cliente(i);
				entrada.put(cliente);
			}
			entrada.setFin();
			for (Thread th : listThread) {
				th.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Cola getEntrada() {
		return entrada;
	}

	public List<Servidor> getListServidor() {
		return listServidor;
	}

	private long _getTiempoLlegada() {
		return Math.round(1000 * Math.log(1 - rand.nextDouble()) / (-lambda));
	}
}
