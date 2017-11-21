package asa.undav.genetica;

import java.util.Random;

public interface Individuo 
	extends Comparable<Individuo> 
{
	public Individuo clone();

	public Individuo reproducir(Individuo oMadre, Random oRnd);

	public void mutar(Random oRnd, int iMutationRatio);

	public void heuristica();

	public double getFitness();
}
