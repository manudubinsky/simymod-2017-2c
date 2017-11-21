package sistema;

import java.util.ArrayList;

public class Profesor {
	private int idProfesor;
	private String nombreProfesor;
	private ArrayList<DiaTurno> diasTurnosProfesor = new ArrayList<DiaTurno>();
	private ArrayList<Integer> materiasProfesor = new ArrayList<Integer>();
	
	
	public Profesor() {}
	
	public Profesor(int id, String nombre, ArrayList<DiaTurno> dia, ArrayList<Integer> materias) {
		setIdProfesor(id);
		setNombreProfesor(nombre);
		setDiasTurnosProfesor(dia);
		setMateriasProfesor(materias);
	}
	
	public int getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}
	public String getNombreProfesor() {
		return nombreProfesor;
	}
	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}
	public ArrayList<DiaTurno> getDiasTurnosProfesor() {
		return diasTurnosProfesor;
	}
	public void setDiasTurnosProfesor(ArrayList<DiaTurno> diasTurnosProfesor) {
		this.diasTurnosProfesor = diasTurnosProfesor;
	}
	public ArrayList<Integer> getMateriasProfesor() {
		return materiasProfesor;
	}
	public void setMateriasProfesor(ArrayList<Integer> materiasProfesor) {
		this.materiasProfesor = materiasProfesor;
	}
	

}
