package asa.cola;

public class Cliente {

	private int id;
	private long tiempoLlegada;
	private long tiempoAtencion;
	private long tiempoSalida;

	public Cliente(int id) {
		this.id = id;
		this.tiempoLlegada = System.currentTimeMillis();
		this.tiempoAtencion = -1L;
		this.tiempoSalida = -1L;
	}

	public int getId() {
		return id;
	}

	public long getTiempoLlegada() {
		return tiempoLlegada;
	}

	public void setTiempoAtencion(long tiempoAtencion) {
		this.tiempoAtencion = tiempoAtencion;
	}

	public long getTiempoAtencion() {
		return tiempoAtencion;
	}

	public void setTiempoSalida(long tiempoSalida) {
		this.tiempoSalida = tiempoSalida;
	}

	public long getTiempoSalida() {
		return tiempoSalida;
	}
}
