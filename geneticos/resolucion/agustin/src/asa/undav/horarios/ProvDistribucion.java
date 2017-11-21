package asa.undav.horarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import asa.undav.genetica.Individuo;
import asa.undav.genetica.ProvIndividuo;
import asa.undav.horarios.datos.Bloque;
import asa.undav.horarios.datos.Dia;
import asa.undav.horarios.datos.Materia;
import asa.undav.horarios.datos.Profesor;
import asa.undav.horarios.datos.Turno;

public class ProvDistribucion implements ProvIndividuo {

	private final List<Materia> materias;
	private final List<Profesor> profesores;
	private Random rnd;

	public ProvDistribucion(List<Materia> materias, List<Profesor> profesores) {
		super();
		this.materias = materias;
		this.profesores = profesores;
		this.rnd = new Random(System.currentTimeMillis());
	}

	@Override
	public Individuo getIndividuo() {

		Bloque bloque1;
		Bloque bloque2;
		Profesor profesor;
		Combinacion combina;
		List<Combinacion> combinaciones = new ArrayList<>();

		// Recorro TODAS las materias
		for (Materia materia : materias) {
			profesor = getProfesor(materia);
			bloque1 = new Bloque(Dia.getDia(rnd.nextInt(Dia.values().length) + 1),
					Turno.getTurno(rnd.nextInt(Turno.values().length) + 1));
			bloque2 = new Bloque(Dia.getDia(rnd.nextInt(Dia.values().length) + 1),
					Turno.getTurno(rnd.nextInt(Turno.values().length) + 1));
			combina = new Combinacion(materia, profesor, bloque1);
			combinaciones.add(combina);
			combina = new Combinacion(materia, profesor, bloque2);
			combinaciones.add(combina);
		}
		return new Distribucion(combinaciones, this);
	}

	/** Obtiene un profesor valido en forma Random para una determinada materia */
	Profesor getProfesor(Materia materia) {
		Profesor profesor = null;
		while (profesor == null) {
			profesor = profesores.get(rnd.nextInt(profesores.size()));
			// filtro que el profesor de la materia
			if (profesor == null || !profesor.getMaterias().contains(materia)) {
				profesor = null;
			}
		}
		return profesor;
	}
}
