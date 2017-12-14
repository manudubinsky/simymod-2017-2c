package sistema;

import java.util.ArrayList;

public class Individuo implements Comparable<Individuo>{

	ArrayList<Materia> listaMaterias;
	private int puntajeFitness;
	
	public Individuo() {
		ArrayList<Materia> listaMateriasNew = new ArrayList<Materia>();
		setListaMaterias(listaMateriasNew);
	}

	//Algoritmo para comparar y ordenar segun el fitness
	@Override
	public int compareTo(Individuo o) {
		// TODO Auto-generated method stub
		if(this.getPuntajeFitness() < o.getPuntajeFitness()) {
			return 1;
		}
		else if(this.getPuntajeFitness() == o.getPuntajeFitness()) {
			return 0;
		}
		else {
			return -1;
		}
		
	}
	
	public void mostrame() {
		System.out.println("El fitness del individuo es: " + this.getPuntajeFitness());
		for(Materia materia: this.getListaMaterias()) {
			System.out.println("La materia: " + materia.getId());
			System.out.println("El día: " + materia.getBloque1().getDia() + " turno: " + materia.getBloque1().getTurno()
					+ " tiene como profesor: " + materia.getProfesorAsignadoB1());
			System.out.println("El día: " + materia.getBloque2().getDia() + " turno: " + materia.getBloque2().getTurno()
					+ " tiene como profesor: " + materia.getProfesorAsignadoB2());
		}
	}
	
	public boolean esValido() {
		boolean valido=true;
		for(Materia materiaActual: this.getListaMaterias()) {
			for(Materia materiaComparo: this.getListaMaterias()) {
				if(materiaActual.getId()!=materiaComparo.getId()) {
					//Mismo profesor en Bloque 1
					if(materiaActual.getProfesorAsignadoB1()==materiaComparo.getProfesorAsignadoB1()) {
						if(materiaActual.getBloque1().getDia()==materiaComparo.getBloque1().getDia()
								&& materiaActual.getBloque1().getTurno()==materiaComparo.getBloque1().getTurno()) {
							valido=false;
						}
					}
					//Mismo profesor en Bloque 2
					if(materiaActual.getProfesorAsignadoB2()==materiaComparo.getProfesorAsignadoB2()) {
						if(materiaActual.getBloque2().getDia()==materiaComparo.getBloque2().getDia()
								&& materiaActual.getBloque2().getTurno()==materiaComparo.getBloque2().getTurno()) {
							valido=false;
						}
					}
					//Mismos profesores en Bloque 1 y Bloque2
					if(materiaActual.getProfesorAsignadoB1()==materiaComparo.getProfesorAsignadoB2()) {
						if(materiaActual.getBloque1().getDia()==materiaComparo.getBloque2().getDia()
								&& materiaActual.getBloque1().getTurno()==materiaComparo.getBloque2().getTurno()) {
							valido=false;
						}
					}
				}
				//Que distintos profesores no den la materia al mismo maomento
				else {
					if(materiaActual.getBloque1().getDia()==materiaComparo.getBloque2().getDia()
							&& materiaActual.getBloque1().getTurno()==materiaComparo.getBloque2().getTurno()) {
						valido=false;
					}
				}
			}
		}
		
		return valido;
	}
	
	public ArrayList<Materia> getListaMaterias() {
		return listaMaterias;
	}

	public void setListaMaterias(ArrayList<Materia> listaMaterias) {
		this.listaMaterias = listaMaterias;
	}

	public int getPuntajeFitness() {
		return puntajeFitness;
	}

	public void setPuntajeFitness(int puntajeFitness) {
		this.puntajeFitness = puntajeFitness;
	}
	
}
