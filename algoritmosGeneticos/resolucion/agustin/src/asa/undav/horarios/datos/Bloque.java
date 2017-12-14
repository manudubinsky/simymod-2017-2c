package asa.undav.horarios.datos;

public class Bloque implements Comparable<Bloque> {

	private final Dia dia;
	private final Turno turno;

	public Bloque(Dia dia, Turno turno) {
		if (dia == null) {
			throw new IllegalArgumentException("Dia no puede ser NULL");
		}
		if (turno == null) {
			throw new IllegalArgumentException("Turno no puede ser NULL");
		}
		this.dia = dia;
		this.turno = turno;
	}

	public Dia getDia() {
		return dia;
	}

	public Turno getTurno() {
		return turno;
	}

	@Override
	public int hashCode() {
		return dia.hashCode() + turno.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bloque other = (Bloque) obj;
		if (dia != other.dia)
			return false;
		if (turno != other.turno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[dia=" + dia + ", turno=" + turno + "]";
	}

	@Override
	public int compareTo(Bloque blo) {
		if (dia.getDia() > blo.dia.getDia()) {
			return 1;
		}
		if (dia.getDia() < blo.dia.getDia()) {
			return -1;
		}
		if (turno.getTurno() > blo.turno.getTurno()) {
			return 1;
		}
		if (turno.getTurno() < blo.turno.getTurno()) {
			return -1;
		}
		return 0;
	}
}
