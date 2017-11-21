package asa.undav.horarios.datos;

public enum Dia {

	LUNES(1, "Lunes"), 
	MARTES(2, "Martes"), 
	MIERCOLES(3, "Miércoles"), 
	JUEVES(4, "Jueves"), 
	VIERNES(5, "Viernes"), 
	SABADO(6, "Sábado");

	private final int dia;
	private final String nombre;

	private Dia(int dia, String nombre) {
		this.dia = dia;
		this.nombre = nombre;
	}

	public int getDia() {
		return dia;
	}

	public String getNombre() {
		return nombre;
	}

	public static Dia getDia(String dia) {
		return getDia(Integer.parseInt(dia));
	}
	
	public static Dia getDia(int dia) {
		for (Dia _dia : values()) {
			if (_dia.dia == dia) {
				return _dia;
			}
		}
		return null;
	}
}
