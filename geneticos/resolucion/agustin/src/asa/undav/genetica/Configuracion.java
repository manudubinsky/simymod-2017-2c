package asa.undav.genetica;

public class Configuracion {

	private double tasaMutacion = 0.5;
	private int tamanioPoblacion = 100;
	private int maximaEdadMejorFitness = 10;

	public Configuracion() {
		super();
	}

	public double getTasaMutacion() {
		return tasaMutacion;
	}

	public void setTasaMutacion(double tasaMutacion) {
		this.tasaMutacion = tasaMutacion;
	}

	public int getTamanioPoblacion() {
		return tamanioPoblacion;
	}

	public void setTamanioPoblacion(int tamanioPoblacion) {
		this.tamanioPoblacion = tamanioPoblacion;
	}

	public int getMaximaEdadMejorFitness() {
		return maximaEdadMejorFitness;
	}

	public void setMaximaEdadMejorFitness(int maximaEdadMejorFitness) {
		this.maximaEdadMejorFitness = maximaEdadMejorFitness;
	}
}
