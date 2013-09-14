package alpro2;

import java.io.Serializable;

/**
 * 
 * @author marco.mangan@pucrs.br
 *
 */
public class Quadrado implements Figura, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int lado;

	public Quadrado() {
		this(1);
	}

	public Quadrado(int lado) {
		if (lado <= 0) {
			throw new IllegalArgumentException("O valor do lado deve ser maior do que zero.");
		}
		this.lado = lado;
	}

	public int getLado() {
		return lado;
	}

	@Override
	public double getArea() {
		return lado * lado;
	}
		
	@Override
	public String toString() {
		return String.format("Quadrado [lado=%s]", lado);
	}
}
