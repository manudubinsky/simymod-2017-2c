package asa.undav.horarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import asa.undav.genetica.Individuo;
import asa.undav.horarios.datos.Bloque;
import asa.undav.horarios.datos.Dia;
import asa.undav.horarios.datos.Profesor;
import asa.undav.horarios.datos.Turno;

public class Distribucion implements Individuo {

	private double fitness;
	private ProvDistribucion provDistribucion;
	private List<Combinacion> materias;

	public Distribucion(List<Combinacion> materias, ProvDistribucion provDistribucion) {
		this.materias = materias;
		this.provDistribucion = provDistribucion;
		_calcularFitness();
	}

	@Override
	public int compareTo(Individuo o) {
		Distribucion distrib = (Distribucion) o;
		if (getFitness() < distrib.getFitness())
			return 1;
		if (getFitness() == distrib.getFitness())
			return 0;
		return -1;
	}

	@Override
	public double getFitness() {
		return fitness;
	}

	@Override
	public Individuo clone() {
		return new Distribucion(new ArrayList<>(materias), provDistribucion);
	}

	/**
	 * Creo un nuevo individuo con parte del padre y el actual buscando los mejores
	 * y cortando en un punto random para igualdad de condiciones
	 */
	@Override
	public Individuo reproducir(Individuo padre, Random rnd) {
		int corte = rnd.nextInt(materias.size());
		Distribucion distrPadre = (Distribucion) padre;
		List<Combinacion> materiasHijo = new ArrayList<>();
		for (int i = 0; i < materias.size(); i++) {
			if (materias.get(i).cumplePreferencia() && !distrPadre.materias.get(i).cumplePreferencia()) {
				materiasHijo.add(materias.get(i));
			} else if (!materias.get(i).cumplePreferencia() && distrPadre.materias.get(i).cumplePreferencia()) {
				materiasHijo.add(distrPadre.materias.get(i));
			} else {
				if (i < corte) {
					materiasHijo.add(materias.get(i));
				} else {
					materiasHijo.add(distrPadre.materias.get(i));
				}
			}

		}
		return new Distribucion(materiasHijo, provDistribucion);
	}

	@Override
	public void mutar(Random rnd, int ratio) {
		// Tengo que mutar el individuo
		if (rnd.nextInt(ratio) == 0) {
			for (int i = 0; i < materias.size(); i++) {
				Combinacion combinacion = new Combinacion(materias.get(i).getMateria(),
						provDistribucion.getProfesor(materias.get(i).getMateria()),
						new Bloque(Dia.getDia(rnd.nextInt(Dia.values().length) + 1),
								Turno.getTurno(rnd.nextInt(Turno.values().length) + 1)));
				materias.set(i, combinacion);
			}
		}
		_calcularFitness();
	}

	@Override
	public void heuristica() {
		_calcularFitness();
	}

	@Override
	public String toString() {
		Map<Profesor, Set<Bloque>> profesorBloque = new HashMap<>();
		for (Combinacion combinacion : materias) {
			profesorBloque.computeIfAbsent(combinacion.getProfesor(), k -> new TreeSet<>())
					.add(combinacion.getBloque());
		}
		String profesores = "\nprofesores = [";
		for (Profesor profesor : profesorBloque.keySet()) {
			profesores += "\n{ profesor=" + profesor.getId() + "-" + profesor.getNombre() + ", bloques="
					+ profesorBloque.get(profesor);
		}
		profesores += "]";
		return "Distribucion (" + fitness + ") =>\nmaterias = " + materias + profesores;
	}

	private void _calcularFitness() {
		// COMBINACIONES NO VALIDAS !!!!
		// Mismo profesor 2 materias en mismo bloque
		Map<Profesor, Set<Bloque>> profesorBloque = new HashMap<>();
		for (Combinacion combinacion : materias) {
			// Si el add da FALSE ya existe el bloque en el set para ese profesor
			if (!profesorBloque.computeIfAbsent(combinacion.getProfesor(), k -> new HashSet<>())
					.add(combinacion.getBloque())) {
				fitness = 0.0;
				return;
			}
		}
		// Que cada materia tenga 2 bloques diferentes las materias estan juntas de a 2
		for (int i = 0; i < materias.size() / 2; i += 2) {
			if (materias.get(i).getBloque().equals(materias.get(i + 1).getBloque())) {
				fitness = 0.0;
				return;
			}
		}
		fitness = 0.0;
		// SI ES VALIDA CALCULO LAS NO PREFERIDAS
		for (Combinacion combinacion : materias) {
			if (combinacion.cumplePreferencia()) {
				fitness++;
			}
		}
	}
}
