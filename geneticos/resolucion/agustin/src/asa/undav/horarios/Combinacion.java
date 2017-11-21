package asa.undav.horarios;

import asa.undav.horarios.datos.Bloque;
import asa.undav.horarios.datos.Materia;
import asa.undav.horarios.datos.Profesor;

public class Combinacion implements Cloneable {

	private final Materia materia;
	private final Profesor profesor;
	private final Bloque bloque;

	public Combinacion(Materia materia, Profesor profesor, Bloque bloque) {
		if (profesor == null) {
			throw new IllegalArgumentException("Profesor no puede ser NULL para " + materia);
		}
		this.materia = materia;
		this.profesor = profesor;
		this.bloque = bloque;
	}

	public Materia getMateria() {
		return materia;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public Bloque getBloque() {
		return bloque;
	}

	public boolean cumplePreferencia() {
		return profesor.cumplePreferencia(bloque);
	}

	@Override
	public Combinacion clone() {
		return new Combinacion(materia, profesor, bloque);
	}

	@Override
	public String toString() {
		return "\n{ materia=" + materia.getId() + "-" + materia.getNombre() + ", profesor=" + profesor.getId() + "-"
				+ profesor.getNombre() + ", bloque=" + bloque + ", cumplePreferencia=" + cumplePreferencia() + "}";
	}
}
