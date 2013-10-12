package alpro2.desenhador;

import java.io.Serializable;

/**
 * 
 * @author marco.mangan@pucrs.br
 *
 */
public class Circulo implements Figura, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int raio;

	/**
	 * 
	 */
	public Circulo() {
		this(1);
	}

	/**
	 * 
	 * @param raio
	 */
	public Circulo(int raio) {
		if (raio <= 0) {
			throw new IllegalArgumentException("Valor de raio deve ser maior do que zero.");
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
