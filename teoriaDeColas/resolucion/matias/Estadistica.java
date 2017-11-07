package sistema;

public class Estadistica implements Runnable{
	
	private int cantClientesTotal;
	private int cantClientesCola;
	private double tiempoClienteCola;
	private double tiempoClienteServidor;
	private double tiempoClienteSistema;
	private double promedioTiempoClienteCola;
	private double promedioTiempoClienteServidor;
	private double promedioTiempoClienteSistema;
	private double promedioCantClientesCola;	
	private boolean continuar;
	private Cola cola;
	private Thread hiloEstadistica;


	public Estadistica(Cola cola) {
		//La clase estadística se encarga de llevar los promedios del sistema
		setContinuar(true);
		setCantClientesTotal(0);
		setTiempoClienteCola(0);
		setTiempoClienteServidor(0);
		setTiempoClienteSistema(0);
		setPromedioTiempoClienteCola(0);
		setPromedioTiempoClienteServidor(0);
		setPromedioTiempoClienteSistema(0);
		setPromedioCantClientesCola(0);
		setCola(cola);
	
		this.hiloEstadistica = new Thread(this);	
		this.hiloEstadistica.start();
	}
	
	
	public void run () {
		while (continuar == true) {
			try {
		      Thread.sleep (1000);
		  }
	      catch (InterruptedException err) {
		      err.printStackTrace();
	      }
		}
	}

	public void agregarCliente(Cliente cliente) {
		this.cantClientesTotal++;
		this.tiempoClienteCola = this.tiempoClienteCola + cliente.getTiempoCola();
		this.tiempoClienteServidor = this.tiempoClienteServidor + cliente.getTiempoServidor();
		this.tiempoClienteSistema = this.tiempoClienteSistema + cliente.getTiempoSalidaSistema();
		this.cantClientesCola = this.cantClientesCola + cola.size();
		this.promedioTiempoClienteCola = (this.tiempoClienteCola)/(cantClientesTotal);
		this.promedioTiempoClienteServidor = (this.tiempoClienteServidor)/(cantClientesTotal);
		this.promedioTiempoClienteSistema = (this.tiempoClienteSistema)/(cantClientesTotal);
		this.promedioCantClientesCola = (this.cantClientesCola)/(cantClientesTotal);
	}
	
	public void mostrar() {
		System.out.println("////////////////////////////////////////////////////////");
		System.out.println("Informacion estadistica del sistema:");
		System.out.println("Tiempo promedio en la cola: " + this.getPromedioTiempoClienteCola());
		System.out.println("Tiempo promedio en el servidor: " + this.getPromedioTiempoClienteServidor());
		System.out.println("Tiempo promedio en el sistema: " + this.getPromedioTiempoClienteSistema());
		System.out.println("Cantidad de clientes en cola: " + this.getCola().size());
	
	}
	
	public boolean isContinuar() {
		return continuar;
	}
	public void setContinuar(boolean continuar) {
		this.continuar = continuar;
	}
	public int getCantClientesTotal() {
		return cantClientesTotal;
	}
	public void setCantClientesTotal(int cantClientesTotal) {
		this.cantClientesTotal = cantClientesTotal;
	}
	public double getTiempoClienteCola() {
		return tiempoClienteCola;
	}
	public void setTiempoClienteCola(double tiempoClienteCola) {
		this.tiempoClienteCola = tiempoClienteCola;
	}
	public double getTiempoClienteServidor() {
		return tiempoClienteServidor;
	}
	public void setTiempoClienteServidor(double tiempoClienteServidor) {
		this.tiempoClienteServidor = tiempoClienteServidor;
	}
	public double getTiempoClienteSistema() {
		return tiempoClienteSistema;
	}
	public void setTiempoClienteSistema(double tiempoClienteSistema) {
		this.tiempoClienteSistema = tiempoClienteSistema;
	}
	public double getPromedioTiempoClienteCola() {
		return promedioTiempoClienteCola;
	}
	public void setPromedioTiempoClienteCola(double promedioTiempoClienteCola) {
		this.promedioTiempoClienteCola = promedioTiempoClienteCola;
	}
	public double getPromedioTiempoClienteServidor() {
		return promedioTiempoClienteServidor;
	}
	public void setPromedioTiempoClienteServidor(double promedioTiempoClienteServidor) {
		this.promedioTiempoClienteServidor = promedioTiempoClienteServidor;
	}
	public double getPromedioTiempoClienteSistema() {
		return promedioTiempoClienteSistema;
	}
	public void setPromedioTiempoClienteSistema(double promedioTiempoClienteSistema) {
		this.promedioTiempoClienteSistema = promedioTiempoClienteSistema;
	}
	public Cola getCola() {
		return cola;
	}
	public void setCola(Cola cola) {
		this.cola = cola;
	}
	public double getPromedioCantClientesCola() {
		return promedioCantClientesCola;
	}
	public void setPromedioCantClientesCola(double promedioCantClientesCola) {
		this.promedioCantClientesCola = promedioCantClientesCola;
	}
	public Thread getHiloEstadistica() {
		return hiloEstadistica;
	}
	public void setHiloEstadistica(Thread hiloEstadistica) {
		this.hiloEstadistica = hiloEstadistica;
	}
	public int getCantClientesCola() {
		return cantClientesCola;
	}
	public void setCantClientesCola(int cantClientesCola) {
		this.cantClientesCola = cantClientesCola;
	}

}
