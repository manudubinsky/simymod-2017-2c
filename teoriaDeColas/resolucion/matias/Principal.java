package sistema;

public class Principal {
	
	public static Sistema sistema;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double lambda = 0.5;
		double mu = 0.2;
		int cantServidores = 3;
		
		sistema = new Sistema (lambda, mu, cantServidores);
		

	}

	public Principal() {
		
	}
	
}
