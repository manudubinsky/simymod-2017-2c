package sistema;

import java.util.Random;

public class Sistema implements Runnable{
	private Estadistica estadistica;
	private Cola cola;
	private Cliente cliente;
	private Servidor listaServidores[];
	private double lambda;
	private boolean continuar;
	private Random rand;
	
	private Thread hiloSistema;
	

	public Sistema (double lambda, double mu, int cantServidores) {
		setLambda(lambda);
		setContinuar(true);
		this.cola = new Cola ();
		this.estadistica = new Estadistica(this.cola);
		this.listaServidores = new Servidor[cantServidores];
		inicializacionServidores(cantServidores, mu, this.cola);
		this.hiloSistema = new Thread(this);
		rand = new Random(System.currentTimeMillis());
		hiloSistema.start();		
	}
	
	public void run () {
		while(continuar == true) {
			try {
				cliente = new Cliente();
				cola.put(cliente);
				Thread.sleep(tiempoCliente());
		      }
		    catch (InterruptedException err) {
			      err.printStackTrace();
		      }
		}
	}
	
	public void inicializacionServidores(int cantServidores, double mu, Cola cola) {
		for(int x=0; x<cantServidores; x++) {
			this.listaServidores[x] = new Servidor(mu, cola, x, this.estadistica);
		}
		/*Servidores con mu cambiados
		 * this.listaServidores[0] = new Servidor(0.2, cola, x, this.estadistica);
		 * this.listaServidores[1] = new Servidor(0,3, cola, x, this.estadistica);
		 * this.listaServidores[2] = new Servidor(0,4, cola, x, this.estadistica);
		 * 
		 */
	}
	
	public long tiempoCliente() {
		//Antes era:
		//-Math.log (1-Math.random ())/lambda
		//Y multiplicaba los 1000 cuando asignaba a lambda
		long tiempo = Math.round(1000 * Math.log(1 - rand.nextDouble()) / (-lambda));
		return tiempo;
	}

	//Getters and Setters
	public Cola getCola() {
		return cola;
	}
	public void setCola(Cola cola) {
		this.cola = cola;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public double getLambda() {
		return lambda;
	}
	public void setLambda(double lambda) {
		this.lambda = lambda;
	}
	public Servidor[] getListaServidores() {
		return listaServidores;
	}
	public void setListaServidores(Servidor[] listaServidores) {
		this.listaServidores = listaServidores;
	}
	public boolean isContinuar() {
		return continuar;
	}
	public void setContinuar(boolean continuar) {
		this.continuar = continuar;
	}
	public Random getRand() {
		return rand;
	}
	public void setRand(Random rand) {
		this.rand = rand;
	}
	public Thread getHiloSistema() {
		return hiloSistema;
	}
	public void setHiloSistema(Thread hiloSistema) {
		this.hiloSistema = hiloSistema;
	}
	public Estadistica getEstadistica() {
		return estadistica;
	}
	public void setEstadistica(Estadistica estadistica) {
		this.estadistica = estadistica;
	}

}
