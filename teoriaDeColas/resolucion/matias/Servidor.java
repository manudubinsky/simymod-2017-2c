package sistema;

import java.util.Random;

public class Servidor implements Runnable{

	private Estadistica estadistica;
	private double mu;
	private Cola cola;
	private Random rand;
	private int id;
	
	private Thread hiloServidor;
	
	public Servidor(double mu, Cola cola, int id, Estadistica estadistica) {
		setMu(mu);
		setCola(cola);
		setId(id);
		setEstadistica(estadistica);
		this.rand = new Random(System.currentTimeMillis());

		this.hiloServidor = new Thread(this);
		this.hiloServidor.start();
	}

	public void run () {
		while(true) {
			try {
				Cliente clienteEnServidor = cola.take();
				clienteEnServidor.setTiempoInicioServidor();
				clienteEnServidor.setTiempoCola();
				Thread.sleep(tiempoServidor());
				clienteEnServidor.setTiempoSalidaSistema();
				clienteEnServidor.setTiempoServidor();
				this.estadistica.agregarCliente(clienteEnServidor);
				this.estadistica.mostrar();
				///////////////////////////////////
				//El método stop() es "obsoleto"
				clienteEnServidor.getHiloCliente().stop();	
				//El metodo interrupt me tira errores
				//clienteEnServidor.getHiloCliente().interrupt();	
				
					
		      }
		    catch (InterruptedException err) {
			      err.printStackTrace();
		      }
		}
	}
	
	public long tiempoServidor() {
		long tiempo = Math.round(1000 * Math.log(1 - rand.nextDouble()) / (-mu));
		return tiempo;
	}
	
	
	public double getMu() {return mu;}
	public void setMu(double mu) {this.mu = mu;}
	public Cola getCola() {return cola;}
	public void setCola(Cola cola) {this.cola = cola;}

	public Thread getHiloServidor() {
		return hiloServidor;
	}
	public void setHiloServidor(Thread hiloServidor) {
		this.hiloServidor = hiloServidor;
	}
	public Random getRand() {
		return rand;
	}
	public void setRand(Random rand) {
		this.rand = rand;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Estadistica getEstadistica() {
		return estadistica;
	}
	public void setEstadistica(Estadistica estadistica) {
		this.estadistica = estadistica;
	}
	
}
