package asa.undav.horarios;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import asa.undav.genetica.Configuracion;
import asa.undav.genetica.Genetica;
import asa.undav.genetica.Motor;
import asa.undav.genetica.MotorCruzamiento;
import asa.undav.horarios.datos.Bloque;
import asa.undav.horarios.datos.Dia;
import asa.undav.horarios.datos.Materia;
import asa.undav.horarios.datos.Profesor;
import asa.undav.horarios.datos.Turno;

public class Horarios {

	private static final CSVFormat FMT = CSVFormat.DEFAULT.withHeader();

	private static Pattern PREF_PAT = Pattern.compile("^\\{(?:(?:\\[[1-6],[1-3]\\]?),?)*\\}$");
	private static Pattern PREF_PAR = Pattern.compile("[^\\[\\]]+(?=\\])");

	private static Pattern MAT_PAT = Pattern.compile("^\\{\\d+(?:,\\d*)*\\}$");
	private static Pattern MAT_PAR = Pattern.compile("\\d+");

	public Horarios() throws Exception {

		Map<Integer, Materia> materias = new HashMap<>();
		List<Profesor> profesores = new ArrayList<>();

		CSVParser parser = null;
		try {
			parser = CSVParser.parse(new File("materias.csv"), Charset.defaultCharset(), FMT);
			Materia materia;
			for (CSVRecord reg : parser) {
				materia = new Materia(Integer.parseInt(reg.get("id")), (String) reg.get("nombre"));
				materias.put(materia.getId(), materia);
			}
		} finally {
			if (parser != null) {
				try {
					parser.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		parser = null;
		try {
			parser = CSVParser.parse(new File("profesores.csv"), Charset.defaultCharset(), FMT);
			Profesor profesor;
			List<Bloque> prefer;
			List<Materia> matProf;
			for (CSVRecord reg : parser) {
				prefer = _getPreferencias(reg.get("preferencias"));
				matProf = _getMateriasProf(reg.get("materias"), materias);
				profesor = new Profesor(Integer.parseInt(reg.get("id")), (String) reg.get("nombre"), matProf, prefer);
				profesores.add(profesor);
			}
		} finally {
			if (parser != null) {
				try {
					parser.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		Configuracion oConfig = new Configuracion();
		oConfig.setTamanioPoblacion(1000);
		Motor oMotor = new MotorCruzamiento(new ProvDistribucion(new ArrayList<>(materias.values()), profesores));
		Genetica oGenetica = new Genetica(oConfig, oMotor);
		Distribucion oMejor = (Distribucion) oGenetica.ejecutar();

		System.out.println(oGenetica.getEstadoEjecucion());
		System.out.println(oMejor);
	}

	public static void main(String[] args) throws Exception {
		new Horarios();
	}

	private List<Bloque> _getPreferencias(String preferencias) {
		Matcher pref;
		List<Bloque> bloques = new ArrayList<>();
		if (PREF_PAT.matcher(preferencias).matches()) {
			String[] aux;
			pref = PREF_PAR.matcher(preferencias);
			while (pref.find()) {
				aux = pref.group().split(",");
				bloques.add(new Bloque(Dia.getDia(aux[0]), Turno.getTurno(aux[1])));
			}
		}
		return bloques;
	}

	private List<Materia> _getMateriasProf(String materias, Map<Integer, Materia> materiasVal) {
		Matcher mat;
		Materia materia;
		List<Materia> materiasProf = new ArrayList<>();
		if (MAT_PAT.matcher(materias).matches()) {
			mat = MAT_PAR.matcher(materias);
			while (mat.find()) {
				materia = materiasVal.get(Integer.parseInt(mat.group()));
				if (materia != null) {
					materiasProf.add(materia);
				} else {
					throw new IllegalArgumentException(String.format("La Materia %s no existe", mat.group()));
				}
			}
		}
		return materiasProf;
	}
}
