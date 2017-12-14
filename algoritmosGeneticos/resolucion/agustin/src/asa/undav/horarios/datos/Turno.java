package asa.undav.horarios.datos;

public enum Turno {

	MANANA(1, "Mañana"), 
	TARDE(2, "Tarde"), 
	NOCHE(3, "Noche");

	private final int turno;
	private final String descripcion;

	private Turno(int turno, String descripcion) {
		this.turno = turno;
		this.descripcion = descripcion;
	}

	public int getTurno() {
		return turno;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public static Turno getTurno(String turno) {
		return getTurno(Integer.parseInt(turno));
	}
	
	public static Turno getTurno(int turno) {
		for (Turno _turno : values()) {
			if (_turno.turno == turno) {
				return _turno;
			}
		}
		return null;
	}
}
