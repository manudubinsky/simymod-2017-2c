package sistema;

public class DiaTurno {
	private int dia;
	private int turno;
	
	
	public DiaTurno(int dia, int turno) {
		setDia(dia);
		setTurno(turno);
	}
	
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
	
}
