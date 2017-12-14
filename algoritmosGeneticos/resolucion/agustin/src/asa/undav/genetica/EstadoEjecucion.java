package asa.undav.genetica;

public class EstadoEjecucion {

	private int generacion;
	private double mejorFitness;
	private int antiguedadMejorFitness;
	private boolean finEjecucion;
	private long tiempoComienzo;
	private long tiempoEjecucion;

	public EstadoEjecucion() {
		super();
	}

	public void iniciarEjecucion() {
		generacion = 0;
		antiguedadMejorFitness = 0;
		mejorFitness = 0;
		finEjecucion = false;
		tiempoComienzo = System.currentTimeMillis();
	}

	public int getGeneracion() {
		return generacion;
	}

	public void incrementarGeneracion() {
		this.generacion++;
	}

	public double getMejorFitness() {
		return mejorFitness;
	}

	public void setMejorFitness(double mejorFitness) {
		this.mejorFitness = mejorFitness;
	}

	public int getAntiguedadMejorFitness() {
		return antiguedadMejorFitness;
	}

	public void incrementarAntiguedadMejorFitness() {
		antiguedadMejorFitness++;
	}

	public void resetAntiguedadMejorFitness() {
		antiguedadMejorFitness = 0;
	}

	public boolean isFinEjecucion() {
		return finEjecucion;
	}

	public void setFinEjecucion() {
		finEjecucion = true;
		tiempoEjecucion = System.currentTimeMillis() - tiempoComienzo;
	}

	@Override
	public String toString() {
		if (!finEjecucion) {
			tiempoEjecucion = System.currentTimeMillis() - tiempoComienzo;
		}
		return "[generacion=" + generacion + ", mejorFitness=" + mejorFitness
				+ ", antiguedadMejorFitness=" + antiguedadMejorFitness + ", tiempoEjecucion=" + (tiempoEjecucion / 1000.0) + "]";
	}
}
