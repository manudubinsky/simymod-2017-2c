package asa.cola;

import java.util.concurrent.LinkedBlockingQueue;

public class Cola extends LinkedBlockingQueue<Cliente> {

	private static final long serialVersionUID = 184027208791409210L;

	private boolean fin = false;

	public Cola() {
		super();
	}

	public Cola(int capacidad) {
		super(capacidad);
	}

	public boolean isFin() {
		return fin && isEmpty();
	}

	public void setFin() {
		fin = true;
	}
}
