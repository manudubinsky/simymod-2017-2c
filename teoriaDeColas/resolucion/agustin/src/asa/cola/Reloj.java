package asa.cola;

public class Reloj implements Runnable {

	private boolean fin;
	private Estadisticas estadisticas;

	public Reloj(Estadisticas estadisticas) {
		this.fin = false;
		this.estadisticas = estadisticas;
	}

	@Override
	public void run() {
		while (!fin) {
			try {
				estadisticas.calcularEstadisticas();
				if (estadisticas.getTick() % 10 == 0) {
					estadisticas.imprimirEstadisticas();
				}
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		estadisticas.calcularEstadisticas();
		estadisticas.imprimirEstadisticas();
	}

	public void setFin() {
		fin = true;
	}
}
