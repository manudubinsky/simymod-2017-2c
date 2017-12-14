package asa.undav.horarios.datos;

import java.util.List;

public class Profesor {

	private final int id;
	private final String nombre;
	private final List<Materia> materias;
	private final List<Bloque> preferencias;

	public Profesor(int id, String nombre, List<Materia> materias, List<Bloque> preferencias) {
		this.id = id;
		this.nombre = nombre;
		this.materias = materias;
		this.preferencias = preferencias;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public List<Bloque> getPreferencias() {
		return preferencias;
	}

	public boolean cumplePreferencia(Bloque bloque) {
		return preferencias.contains(bloque);
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", materias=" + materias + ", preferencias=" + preferencias + "]";
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
