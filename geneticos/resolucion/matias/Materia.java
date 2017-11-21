package sistema;

public class Materia {
	private int id;
	private String nombre;
	private DiaTurno bloque1;
	private DiaTurno bloque2;
	private int profesorAsignadoB1;
	private int profesorAsignadoB2;
	private int puntaje;
	

	public Materia(int id, DiaTurno b1, DiaTurno b2, int profesorb1, int profesorb2) {
		setId(id);
		setBloque1(b1);
		setBloque2(b2);
		setProfesorAsignadoB1(profesorb1);
		setProfesorAsignadoB2(profesorb2);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public DiaTurno getBloque1() {
		return bloque1;
	}
	public void setBloque1(DiaTurno bloque1) {
		this.bloque1 = bloque1;
	}
	public DiaTurno getBloque2() {
		return bloque2;
	}
	public void setBloque2(DiaTurno bloque2) {
		this.bloque2 = bloque2;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public int getProfesorAsignadoB1() {
		return profesorAsignadoB1;
	}
	public void setProfesorAsignadoB1(int profesorAsignadoB1) {
		this.profesorAsignadoB1 = profesorAsignadoB1;
	}
	public int getProfesorAsignadoB2() {
		return profesorAsignadoB2;
	}
	public void setProfesorAsignadoB2(int profesorAsignadoB2) {
		this.profesorAsignadoB2 = profesorAsignadoB2;
	}
}
