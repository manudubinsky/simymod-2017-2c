package asa.undav.genetica;

public class Genetica {

	private Individuo mejorIndividuo;
	private EstadoEjecucion estadoEjecucion;
	private Configuracion config;
	private Motor motor;

	public Genetica(Configuracion oConfig, Motor oMotor) {
		super();
		config = oConfig;
		motor = oMotor;
		estadoEjecucion = new EstadoEjecucion();
	}

	public EstadoEjecucion getEstadoEjecucion() {
		return estadoEjecucion;
	}

	public boolean estaEnEjecucion() {
		return !estadoEjecucion.isFinEjecucion();
	}

	public Individuo getSolucion() {
		return mejorIndividuo;
	}

	public Individuo ejecutar() {
		try {
			estadoEjecucion.iniciarEjecucion();
			mejorIndividuo = null;
			double dFitnessPrevio = 0;
			motor.inicializar(config);

			while (!estadoEjecucion.isFinEjecucion()) {
				mejorIndividuo = motor.getMejorIndividuo();
				if (dFitnessPrevio == mejorIndividuo.getFitness()) {
					estadoEjecucion.incrementarAntiguedadMejorFitness();
				} else {
					System.out.println(estadoEjecucion);
					estadoEjecucion.resetAntiguedadMejorFitness();
				}
				estadoEjecucion.setMejorFitness(mejorIndividuo.getFitness());
				if (estadoEjecucion.getAntiguedadMejorFitness() >= config.getMaximaEdadMejorFitness()) {
					estadoEjecucion.setFinEjecucion();
				}
				dFitnessPrevio = estadoEjecucion.getMejorFitness();
				motor.proximaGeneracion();
				estadoEjecucion.incrementarGeneracion();
			}

			return mejorIndividuo;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
}
