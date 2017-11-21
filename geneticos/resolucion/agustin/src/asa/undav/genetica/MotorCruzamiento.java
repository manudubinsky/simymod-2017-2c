package asa.undav.genetica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MotorCruzamiento implements Motor {
	
	private static final int MAX_THREAD = Runtime.getRuntime().availableProcessors() * 2;

	protected List<Individuo> poblacion = Collections.synchronizedList(new ArrayList<Individuo>());
	protected Random rnd;
	protected int tamanioPoblacion;
	protected int tasaMutacion;
	protected Configuracion configuracion;
	protected ProvIndividuo provIndividuo;

	public MotorCruzamiento(ProvIndividuo oProvIndividuo) {
		super();
		provIndividuo = oProvIndividuo;
	}

	@Override
	public void inicializar(Configuracion oConfiguracion) {
		configuracion = oConfiguracion;
		tasaMutacion = (int) (1 / configuracion.getTasaMutacion());
		rnd = new Random();
		poblacion.clear();
		tamanioPoblacion = configuracion.getTamanioPoblacion();

		ExecutorService exec = Executors.newFixedThreadPool(MAX_THREAD);
		final CountDownLatch fin = new CountDownLatch(MAX_THREAD);
		for (int i = 0; i < MAX_THREAD; i++) {
			exec.execute(new Runnable() {
				public void run() {
					while (poblacion.size() < tamanioPoblacion) {
						Individuo oNuevo = provIndividuo.getIndividuo();
						oNuevo.heuristica();
						poblacion.add(oNuevo);
					}
					fin.countDown();
				}
			});
		}
		try { fin.await(); }
		catch (InterruptedException e) { }
		exec.shutdownNow();

		ordenarPoblacion();
	}

	@Override
	public int getTamanioPoblacion() {
		return tamanioPoblacion;
	}

	@Override
	public Individuo getMejorIndividuo() {
		return poblacion.get(0);
	}

	@Override
	public void proximaGeneracion() {
		
		final int cantidadMejores = (int) (tamanioPoblacion * 0.5);
		int size = poblacion.size();
		while (size > cantidadMejores) {
			poblacion.remove(size - 1);
			size--;
		}

		ExecutorService exec = Executors.newFixedThreadPool(MAX_THREAD);
		final CountDownLatch fin = new CountDownLatch(MAX_THREAD);
		final int cant = cantidadMejores / MAX_THREAD;
		for (int i = 0; i < MAX_THREAD; i++) {
			final int pos = i;
			exec.execute(new Runnable() {
				public void run() {
					for (int j = 0; j < cant; j++) {
						crecerPoblacion(cantidadMejores, pos * cant + j);
					}
					fin.countDown();
				}
			});
		}
		try { fin.await(); }
		catch (InterruptedException e) { }
		exec.shutdownNow();

		ordenarPoblacion();
		
		size = poblacion.size();
		while (size > tamanioPoblacion) {
			poblacion.remove(size - 1);
			size--;
		}
	}

	protected void ordenarPoblacion() {
		Collections.sort(poblacion);
	}

	protected void crecerPoblacion(int mejor, int pos) {
		int i1 = pos;
		int i2 = rnd.nextInt(mejor);
		if (i1 == i2) {
			if (i2 > 0) {
				i2--;
			} else {
				i2++;
			}
		}
		getHijo(poblacion.get(i1), poblacion.get(i2));
	}

	protected void getHijo(Individuo padre1, Individuo padre2) {
		Individuo hijo1 = padre1.clone();
		Individuo hijo2 = padre2.clone();
		Individuo hijo3 = padre1.reproducir(padre2, rnd);
		Individuo hijo4 = padre2.reproducir(padre1, rnd);

		hijo1.mutar(rnd, tasaMutacion);
		hijo2.mutar(rnd, tasaMutacion);
		hijo3.mutar(rnd, tasaMutacion);
		hijo4.mutar(rnd, tasaMutacion);

		hijo1.heuristica();
		hijo2.heuristica();
		hijo3.heuristica();
		hijo4.heuristica();

		poblacion.add(hijo1);
		poblacion.add(hijo2);
		poblacion.add(hijo3);
		poblacion.add(hijo4);
	}
}
