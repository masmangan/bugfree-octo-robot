package alpro2.desenhador;

import java.io.Serializable;

/**
 * 
 * @author marco.mangan@pucrs.br
 * 
 */
public class Quadrado extends Figura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int lado;

	public Quadrado(int x, int y) {
		this(x, y, 1);
	}

	public Quadrado(int x, int y, int lado) {
		super(x, y);
		if (lado <= 0) {
			throw new IllegalArgumentException(
					"O valor do lado deve ser maior do que zero.");
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
