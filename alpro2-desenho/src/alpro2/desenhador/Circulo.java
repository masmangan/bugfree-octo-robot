package alpro2.desenhador;

import java.io.Serializable;

/**
 * 
 * @author marco.mangan@pucrs.br
 * 
 */
public class Circulo extends Figura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int raio;

	/**
	 * 
	 */
	public Circulo(int x, int y) {
		this(x, y, 1);
	}

	/**
	 * 
	 * @param raio
	 */
	public Circulo(int x, int y, int raio) {
		super(x, y);
		if (raio <= 0) {
			throw new IllegalArgumentException(
					"Valor de raio deve ser maior do que zero.");
		}
		this.raio = raio;
	}

	/**
	 * 
	 * @return
	 */
	public int getLado() {
		return raio;
	}

	@Override
	public double getArea() {
		return Math.PI * raio * raio;
	}

	@Override
	public String toString() {
		return String.format("Circulo [raio=%s]", raio);
	}
}
