package asa.undav.genetica;

public interface Motor {

	public void inicializar(Configuracion oConfiguracion);

	public int getTamanioPoblacion();

	public Individuo getMejorIndividuo();

	public void proximaGeneracion();
}
