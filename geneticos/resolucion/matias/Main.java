package sistema;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Profesor> listaProfesores = new ArrayList<Profesor>();
		
		
		ArrayList<DiaTurno> diasTurnosKiper = new ArrayList<DiaTurno>();
		DiaTurno DiaTurno1Kipper = new DiaTurno(1,2);
		DiaTurno DiaTurno2Kipper = new DiaTurno(2,2);
		DiaTurno DiaTurno3Kipper = new DiaTurno(3,2);
		DiaTurno DiaTurno4Kipper = new DiaTurno(4,2);
		DiaTurno DiaTurno5Kipper = new DiaTurno(5,2);
		DiaTurno DiaTurno6Kipper = new DiaTurno(1,1);
		DiaTurno DiaTurno7Kipper = new DiaTurno(2,1);
		DiaTurno DiaTurno8Kipper = new DiaTurno(3,1);
		DiaTurno DiaTurno9Kipper = new DiaTurno(4,1);
		DiaTurno DiaTurno10Kipper = new DiaTurno(5,1);
		diasTurnosKiper.add(DiaTurno1Kipper);
		diasTurnosKiper.add(DiaTurno2Kipper);
		diasTurnosKiper.add(DiaTurno3Kipper);
		diasTurnosKiper.add(DiaTurno4Kipper);
		diasTurnosKiper.add(DiaTurno5Kipper);
		diasTurnosKiper.add(DiaTurno6Kipper);
		diasTurnosKiper.add(DiaTurno7Kipper);
		diasTurnosKiper.add(DiaTurno8Kipper);
		diasTurnosKiper.add(DiaTurno9Kipper);
		diasTurnosKiper.add(DiaTurno10Kipper);
		ArrayList<Integer> materiasKiper = new ArrayList<Integer>();
		materiasKiper.add(15);
		materiasKiper.add(16);
		materiasKiper.add(17);
		materiasKiper.add(18);
		Profesor kiper = new Profesor(1, "Kipper",diasTurnosKiper, materiasKiper);
		listaProfesores.add(kiper);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosMiguel = new ArrayList<DiaTurno>();
		DiaTurno DiaTurno1Miguel = new DiaTurno(3,2);
		DiaTurno DiaTurno2Miguel = new DiaTurno(3,1);
		DiaTurno DiaTurno3Miguel = new DiaTurno(5,2);
		DiaTurno DiaTurno4Miguel = new DiaTurno(1,1);
		DiaTurno DiaTurno5Miguel = new DiaTurno(2,1);
		diasTurnosMiguel.add(DiaTurno1Miguel);
		diasTurnosMiguel.add(DiaTurno2Miguel);
		diasTurnosMiguel.add(DiaTurno3Miguel);
		diasTurnosMiguel.add(DiaTurno4Miguel);
		diasTurnosMiguel.add(DiaTurno5Miguel);
		ArrayList<Integer> materiasMiguel = new ArrayList<Integer>();
		materiasMiguel.add(25);
		materiasMiguel.add(3);
		materiasMiguel.add(4);
		materiasMiguel.add(9);
		materiasMiguel.add(5);
		Profesor miguel = new Profesor(2, "Miguel",diasTurnosMiguel, materiasMiguel);
		listaProfesores.add(miguel);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosDubinsky = new ArrayList<DiaTurno>();
		DiaTurno diaTurno1Dubinsky = new DiaTurno(1,2);
		DiaTurno diaTurno2Dubinsky = new DiaTurno(2,2);
		DiaTurno diaTurno3Dubinsky = new DiaTurno(3,2);
		DiaTurno diaTurno4Dubinsky = new DiaTurno(4,2);
		DiaTurno diaTurno5Dubinsky = new DiaTurno(5,2);
		DiaTurno diaTurno6Dubinsky = new DiaTurno(1,1);
		DiaTurno diaTurno7Dubinsky = new DiaTurno(2,1);
		DiaTurno diaTurno8Dubinsky = new DiaTurno(3,1);
		DiaTurno diaTurno9Dubinsky = new DiaTurno(4,1);
		DiaTurno diaTurno10Dubinsky = new DiaTurno(5,1);
		diasTurnosDubinsky.add(diaTurno1Dubinsky);
		diasTurnosDubinsky.add(diaTurno2Dubinsky);
		diasTurnosDubinsky.add(diaTurno3Dubinsky);
		diasTurnosDubinsky.add(diaTurno4Dubinsky);
		diasTurnosDubinsky.add(diaTurno5Dubinsky);
		diasTurnosDubinsky.add(diaTurno6Dubinsky);
		diasTurnosDubinsky.add(diaTurno7Dubinsky);
		diasTurnosDubinsky.add(diaTurno8Dubinsky);
		diasTurnosDubinsky.add(diaTurno9Dubinsky);
		diasTurnosDubinsky.add(diaTurno10Dubinsky);
		ArrayList<Integer> materiasDubinsky = new ArrayList<Integer>();
		materiasDubinsky.add(5);
		materiasDubinsky.add(6);
		materiasDubinsky.add(7);
		materiasDubinsky.add(8);
		Profesor dubinsky = new Profesor(3, "Dubinskyr",diasTurnosDubinsky, materiasDubinsky);
		listaProfesores.add(dubinsky);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosLagostena = new ArrayList<DiaTurno>();
		DiaTurno diaTurno1Lagostena = new DiaTurno(1,1);
		DiaTurno diaTurno2Lagostena = new DiaTurno(2,1);
		DiaTurno diaTurno3Lagostena = new DiaTurno(3,1);
		DiaTurno diaTurno4Lagostena = new DiaTurno(4,1);
		DiaTurno diaTurno5Lagostena = new DiaTurno(5,1);
		diasTurnosLagostena.add(diaTurno1Lagostena);
		diasTurnosLagostena.add(diaTurno2Lagostena);
		diasTurnosLagostena.add(diaTurno3Lagostena);
		diasTurnosLagostena.add(diaTurno4Lagostena);
		diasTurnosLagostena.add(diaTurno5Lagostena);
		ArrayList<Integer> materiasLagostena = new ArrayList<Integer>();
		materiasLagostena.add(26);
		Profesor lagostena = new Profesor(4, "Lagostena",diasTurnosLagostena, materiasLagostena);
		listaProfesores.add(lagostena);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosRoldan = new ArrayList<DiaTurno>();
		DiaTurno diasTurnos1Roldan = new DiaTurno(5,2);
		DiaTurno diasTurnos2Roldan = new DiaTurno(5,1);
		diasTurnosRoldan.add(diasTurnos1Roldan);
		diasTurnosRoldan.add(diasTurnos2Roldan);
		ArrayList<Integer> materiasRoldan = new ArrayList<Integer>();
		materiasRoldan.add(10);
		Profesor roldan = new Profesor(5, "Roldan",diasTurnosRoldan, materiasRoldan);
		listaProfesores.add(roldan);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosBarrios = new ArrayList<DiaTurno>();
		DiaTurno diasTurnos1Barrios = new DiaTurno(4,1);
		DiaTurno diasTurnos2Barrios = new DiaTurno(4,2);
		DiaTurno diasTurnos3Barrios = new DiaTurno(5,1);
		DiaTurno diasTurnos4Barrios = new DiaTurno(5,2);
		DiaTurno diasTurnos5Barrios = new DiaTurno(3,1);
		DiaTurno diasTurnos6Barrios = new DiaTurno(3,2);
		diasTurnosBarrios.add(diasTurnos1Barrios);
		diasTurnosBarrios.add(diasTurnos2Barrios);
		diasTurnosBarrios.add(diasTurnos3Barrios);
		diasTurnosBarrios.add(diasTurnos4Barrios);
		diasTurnosBarrios.add(diasTurnos5Barrios);
		diasTurnosBarrios.add(diasTurnos6Barrios);
		ArrayList<Integer> materiasBarrios = new ArrayList<Integer>();
		materiasBarrios.add(21);
		materiasBarrios.add(3);
		materiasBarrios.add(5);
		materiasBarrios.add(12);
		Profesor barrios = new Profesor(6, "Barrios",diasTurnosBarrios, materiasBarrios);
		listaProfesores.add(barrios);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosKenobi = new ArrayList<DiaTurno>();
		DiaTurno diasTurnos1Kenobi = new DiaTurno(1,1);
		DiaTurno diasTurnos2Kenobi = new DiaTurno(2,1);
		DiaTurno diasTurnos3Kenobi = new DiaTurno(3,1);
		DiaTurno diasTurnos4Kenobi = new DiaTurno(1,2);
		DiaTurno diasTurnos5Kenobi = new DiaTurno(2,2);
		DiaTurno diasTurnos6Kenobi = new DiaTurno(3,2);
		diasTurnosKenobi.add(diasTurnos1Kenobi);
		diasTurnosKenobi.add(diasTurnos2Kenobi);
		diasTurnosKenobi.add(diasTurnos3Kenobi);
		diasTurnosKenobi.add(diasTurnos4Kenobi);
		diasTurnosKenobi.add(diasTurnos5Kenobi);
		diasTurnosKenobi.add(diasTurnos6Kenobi);
		ArrayList<Integer> materiasKenobi = new ArrayList<Integer>();
		materiasKenobi.add(11);
		materiasKenobi.add(19);
		materiasKenobi.add(21);
		Profesor kenobi = new Profesor(7, "Kenobi",diasTurnosKenobi, materiasKenobi);
		listaProfesores.add(kenobi);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosMachuca = new ArrayList<DiaTurno>();
		DiaTurno diasTurnos1Machuca = new DiaTurno(5,1);
		DiaTurno diasTurnos2Machuca = new DiaTurno(4,1);
		DiaTurno diasTurnos3Machuca = new DiaTurno(4,2);
		diasTurnosMachuca.add(diasTurnos1Machuca);
		diasTurnosMachuca.add(diasTurnos2Machuca);
		diasTurnosMachuca.add(diasTurnos3Machuca);
		ArrayList<Integer> materiasMachuca = new ArrayList<Integer>();
		materiasMachuca.add(13);
		materiasMachuca.add(23);
		materiasMachuca.add(27);
		materiasMachuca.add(14);
		Profesor machuca = new Profesor(8, "Machuca",diasTurnosMachuca, materiasMachuca);
		listaProfesores.add(machuca);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosBalboa = new ArrayList<DiaTurno>();
		DiaTurno diasTurnos1Balboa = new DiaTurno(1,1);
		DiaTurno diasTurnos2Balboa = new DiaTurno(5,1);
		DiaTurno diasTurnos3Balboa = new DiaTurno(3,1);
		diasTurnosBalboa.add(diasTurnos1Balboa);
		diasTurnosBalboa.add(diasTurnos2Balboa);
		diasTurnosBalboa.add(diasTurnos3Balboa);
		ArrayList<Integer> materiasBalboa = new ArrayList<Integer>();
		materiasBalboa.add(18);
		materiasBalboa.add(24);
		Profesor balboa = new Profesor(9, "Balboa",diasTurnosBalboa, materiasBalboa);
		listaProfesores.add(balboa);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosFunesMori = new ArrayList<DiaTurno>();
		DiaTurno diasTurnos1FunesMori = new DiaTurno(1,1);
		DiaTurno diasTurnos2FunesMori = new DiaTurno(1,2);
		diasTurnosFunesMori.add(diasTurnos1FunesMori);
		diasTurnosFunesMori.add(diasTurnos2FunesMori);
		ArrayList<Integer> materiasFunesMori = new ArrayList<Integer>();
		materiasFunesMori.add(26);
		Profesor funesmori = new Profesor(10, "FunesMori",diasTurnosFunesMori, materiasFunesMori);
		listaProfesores.add(funesmori);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosPoe = new ArrayList<DiaTurno>();
		DiaTurno diasTurnos1Poe = new DiaTurno(1,2);
		DiaTurno diasTurnos2Poe = new DiaTurno(2,2);
		DiaTurno diasTurnos3Poe = new DiaTurno(3,2);
		DiaTurno diasTurnos4Poe = new DiaTurno(4,2);
		DiaTurno diasTurnos5Poe = new DiaTurno(5,2);
		diasTurnosPoe.add(diasTurnos1Poe);
		diasTurnosPoe.add(diasTurnos2Poe);
		diasTurnosPoe.add(diasTurnos3Poe);
		diasTurnosPoe.add(diasTurnos4Poe);
		diasTurnosPoe.add(diasTurnos5Poe);
		ArrayList<Integer> materiasPoe = new ArrayList<Integer>();
		materiasPoe.add(27);
		materiasPoe.add(18);
		materiasPoe.add(9);
		Profesor poe = new Profesor(11, "Poe",diasTurnosPoe, materiasPoe);
		listaProfesores.add(poe);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosKoeman = new ArrayList<DiaTurno>();
		DiaTurno diasTurnos1Koeman = new DiaTurno(1,2);
		DiaTurno diasTurnos2Koeman = new DiaTurno(2,2);
		DiaTurno diasTurnos3Koeman = new DiaTurno(3,2);
		DiaTurno diasTurnos4Koeman = new DiaTurno(4,2);
		DiaTurno diasTurnos5Koeman = new DiaTurno(5,2);
		DiaTurno diasTurnos6Koeman = new DiaTurno(1,1);
		diasTurnosKoeman.add(diasTurnos1Koeman);
		diasTurnosKoeman.add(diasTurnos2Koeman);
		diasTurnosKoeman.add(diasTurnos3Koeman);
		diasTurnosKoeman.add(diasTurnos4Koeman);
		diasTurnosKoeman.add(diasTurnos5Koeman);
		diasTurnosKoeman.add(diasTurnos6Koeman);
		ArrayList<Integer> materiasKoeman = new ArrayList<Integer>();
		materiasKoeman.add(19);
		materiasKoeman.add(3);
		materiasKoeman.add(5);
		Profesor koeman = new Profesor(12, "Koeman",diasTurnosKoeman, materiasKoeman);
		listaProfesores.add(koeman);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosGinobili = new ArrayList<DiaTurno>();
		DiaTurno diasTurnos1Ginobili = new DiaTurno(1,2);
		DiaTurno diasTurnos2Ginobili = new DiaTurno(2,2);
		DiaTurno diasTurnos3Ginobili = new DiaTurno(3,2);
		DiaTurno diasTurnos4Ginobili = new DiaTurno(4,2);
		DiaTurno diasTurnos5Ginobili = new DiaTurno(5,2);
		DiaTurno diasTurnos6Ginobili = new DiaTurno(1,1);
		DiaTurno diasTurnos7Ginobili = new DiaTurno(2,1);
		diasTurnosGinobili.add(diasTurnos1Ginobili);
		diasTurnosGinobili.add(diasTurnos2Ginobili);
		diasTurnosGinobili.add(diasTurnos3Ginobili);
		diasTurnosGinobili.add(diasTurnos4Ginobili);
		diasTurnosGinobili.add(diasTurnos5Ginobili);
		diasTurnosGinobili.add(diasTurnos6Ginobili);
		diasTurnosGinobili.add(diasTurnos7Ginobili);
		ArrayList<Integer> materiasGinobili = new ArrayList<Integer>();
		materiasGinobili.add(20);
		materiasGinobili.add(2);
		Profesor ginobili = new Profesor(13, "Ginobili",diasTurnosGinobili, materiasGinobili);
		listaProfesores.add(ginobili);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosZonzatera = new ArrayList<DiaTurno>();
		DiaTurno diasTurnos1Zonzatera = new DiaTurno(1,2);
		DiaTurno diasTurnos2Zonzatera = new DiaTurno(2,2);
		DiaTurno diasTurnos3Zonzatera = new DiaTurno(3,2);
		DiaTurno diasTurnos4Zonzatera = new DiaTurno(4,2);
		DiaTurno diasTurnos5Zonzatera = new DiaTurno(5,2);
		DiaTurno diasTurnos6Zonzatera = new DiaTurno(1,1);
		DiaTurno diasTurnos7Zonzatera = new DiaTurno(2,1);
		DiaTurno diasTurnos8Zonzatera = new DiaTurno(3,1);
		DiaTurno diasTurnos9Zonzatera = new DiaTurno(4,1);
		DiaTurno diasTurnos10Zonzatera = new DiaTurno(5,1);
		diasTurnosZonzatera.add(diasTurnos1Zonzatera);
		diasTurnosZonzatera.add(diasTurnos2Zonzatera);
		diasTurnosZonzatera.add(diasTurnos3Zonzatera);
		diasTurnosZonzatera.add(diasTurnos4Zonzatera);
		diasTurnosZonzatera.add(diasTurnos5Zonzatera);
		diasTurnosZonzatera.add(diasTurnos6Zonzatera);
		diasTurnosZonzatera.add(diasTurnos7Zonzatera);
		diasTurnosZonzatera.add(diasTurnos8Zonzatera);
		diasTurnosZonzatera.add(diasTurnos9Zonzatera);
		diasTurnosZonzatera.add(diasTurnos10Zonzatera);
		ArrayList<Integer> materiasZonzatera = new ArrayList<Integer>();
		materiasZonzatera.add(21);
		materiasZonzatera.add(11);
		materiasZonzatera.add(3);
		materiasZonzatera.add(4);
		Profesor zonzatera = new Profesor(14, "Zonzatera",diasTurnosZonzatera, materiasZonzatera);
		listaProfesores.add(zonzatera);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosJasen = new ArrayList<DiaTurno>();
		DiaTurno diasTurnos1Jasen = new DiaTurno(1,2);
		DiaTurno diasTurnos2Jasen = new DiaTurno(1,1);
		DiaTurno diasTurnos3Jasen = new DiaTurno(3,1);
		DiaTurno diasTurnos4Jasen = new DiaTurno(3,2);
		DiaTurno diasTurnos5Jasen = new DiaTurno(5,1);
		DiaTurno diasTurnos6Jasen = new DiaTurno(5,2);
		diasTurnosJasen.add(diasTurnos1Jasen);
		diasTurnosJasen.add(diasTurnos2Jasen);
		diasTurnosJasen.add(diasTurnos3Jasen);
		diasTurnosJasen.add(diasTurnos4Jasen);
		diasTurnosJasen.add(diasTurnos5Jasen);
		diasTurnosJasen.add(diasTurnos6Jasen);
		ArrayList<Integer> materiasJase = new ArrayList<Integer>();
		materiasJase.add(1);
		materiasJase.add(5);
		materiasJase.add(21);
		materiasJase.add(26);
		Profesor jasen = new Profesor(15, "Jasen",diasTurnosJasen, materiasJase);
		listaProfesores.add(jasen);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosMontecchia = new ArrayList<DiaTurno>();
		DiaTurno diasTurnos1Montecchia = new DiaTurno(3,1);
		DiaTurno diasTurnos2Montecchia = new DiaTurno(3,2);
		DiaTurno diasTurnos3Montecchia = new DiaTurno(4,2);
		DiaTurno diasTurnos4Montecchia = new DiaTurno(5,2);
		DiaTurno diasTurnos5Montecchia = new DiaTurno(2,1);
		DiaTurno diasTurnos6Montecchia = new DiaTurno(2,2);
		diasTurnosMontecchia.add(diasTurnos1Montecchia);
		diasTurnosMontecchia.add(diasTurnos2Montecchia);
		diasTurnosMontecchia.add(diasTurnos3Montecchia);
		diasTurnosMontecchia.add(diasTurnos4Montecchia);
		diasTurnosMontecchia.add(diasTurnos5Montecchia);
		diasTurnosMontecchia.add(diasTurnos6Montecchia);
		ArrayList<Integer> materiasMontecchia = new ArrayList<Integer>();
		materiasMontecchia.add(11);
		materiasMontecchia.add(23);
		materiasMontecchia.add(22);
		Profesor montecchia = new Profesor(16, "Montecchia",diasTurnosMontecchia, materiasMontecchia);
		listaProfesores.add(montecchia);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosSanchez = new ArrayList<DiaTurno>();
		DiaTurno diasTurnos1Sanchez = new DiaTurno(1,2);
		DiaTurno diasTurnos2Sanchez = new DiaTurno(2,2);
		DiaTurno diasTurnos3Sanchez = new DiaTurno(3,2);
		DiaTurno diasTurnos4Sanchez = new DiaTurno(4,2);
		DiaTurno diasTurnos5Sanchez = new DiaTurno(5,1);
		DiaTurno diasTurnos6Sanchez = new DiaTurno(5,2);
		diasTurnosSanchez.add(diasTurnos1Sanchez);
		diasTurnosSanchez.add(diasTurnos2Sanchez);
		diasTurnosSanchez.add(diasTurnos3Sanchez);
		diasTurnosSanchez.add(diasTurnos4Sanchez);
		diasTurnosSanchez.add(diasTurnos5Sanchez);
		diasTurnosSanchez.add(diasTurnos6Sanchez);
		ArrayList<Integer> materiasSanchez = new ArrayList<Integer>();
		materiasSanchez.add(1);
		materiasSanchez.add(2);
		materiasSanchez.add(3);
		materiasSanchez.add(14);
		Profesor sanchez = new Profesor(17, "Sanchez",diasTurnosSanchez, materiasSanchez);
		listaProfesores.add(sanchez);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosSmith = new ArrayList<DiaTurno>();
		DiaTurno diasTurnos1Smith = new DiaTurno(1,2);
		DiaTurno diasTurnos2Smith = new DiaTurno(2,2);
		DiaTurno diasTurnos3Smith = new DiaTurno(3,2);
		DiaTurno diasTurnos4Smith = new DiaTurno(4,2);
		DiaTurno diasTurnos5Smith = new DiaTurno(5,2);
		diasTurnosSmith.add(diasTurnos1Smith);
		diasTurnosSmith.add(diasTurnos2Smith);
		diasTurnosSmith.add(diasTurnos3Smith);
		diasTurnosSmith.add(diasTurnos4Smith);
		diasTurnosSmith.add(diasTurnos5Smith);
		ArrayList<Integer> materiasSmith = new ArrayList<Integer>();
		materiasSmith.add(3);
		materiasSmith.add(4);
		materiasSmith.add(5);
		Profesor smith = new Profesor(18, "Smith",diasTurnosSmith, materiasSmith);
		listaProfesores.add(smith);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosPerez = new ArrayList<DiaTurno>();
		DiaTurno diasTurnos1Perez = new DiaTurno(1,1);
		DiaTurno diasTurnos2Perez = new DiaTurno(2,2);
		diasTurnosPerez.add(diasTurnos1Perez);
		diasTurnosPerez.add(diasTurnos2Perez);
		ArrayList<Integer> materiasPerez = new ArrayList<Integer>();
		materiasPerez.add(9);
		materiasPerez.add(18);
		materiasPerez.add(21);
		materiasPerez.add(25);
		Profesor perez = new Profesor(19, "Perez",diasTurnosPerez, materiasPerez);
		listaProfesores.add(perez);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosAllen = new ArrayList<DiaTurno>();
		DiaTurno diasTurnos1Allen = new DiaTurno(1,1);
		DiaTurno diasTurnos2Allen = new DiaTurno(2,1);
		DiaTurno diasTurnos3Allen = new DiaTurno(3,1);
		DiaTurno diasTurnos4Allen = new DiaTurno(4,1);
		DiaTurno diasTurnos5Allen = new DiaTurno(5,1);
		diasTurnosAllen.add(diasTurnos1Allen);
		diasTurnosAllen.add(diasTurnos2Allen);
		diasTurnosAllen.add(diasTurnos3Allen);
		diasTurnosAllen.add(diasTurnos4Allen);
		diasTurnosAllen.add(diasTurnos5Allen);
		ArrayList<Integer> materiasAllen = new ArrayList<Integer>();
		materiasAllen.add(1);
		materiasAllen.add(2);
		Profesor allen = new Profesor(20, "Allen",diasTurnosAllen, materiasAllen);
		listaProfesores.add(allen);		
		
		//------------------------------------------------------------------------------//
		
		Poblacion pob = new Poblacion();
		pob.primeraGeneracion(listaProfesores);
		int mejorLista=0;
		boolean listaEncontrada = false;
		int contador=0;
		
		while(listaEncontrada == false) {
			pob.fitnessZero();
			pob.fitness(listaProfesores);
			if(pob.getPoblacion().get(0).getPuntajeFitness()>=38) {
				listaEncontrada=true;
			}
			if(listaEncontrada==false) {
				pob.reproduccion();
				pob.mutacion(listaProfesores);
			}
			contador++;
			System.out.println("contador: " + contador);
			System.out.println(pob.getPoblacion().get(0).getPuntajeFitness());
			
		}
		
		System.out.println("MEJOR LISTA ENCONTRADA");
		pob.getPoblacion().get(mejorLista).mostrame();
			}

}
