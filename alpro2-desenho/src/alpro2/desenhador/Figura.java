package alpro2.desenhador;

/**
 * 
 * @author marco.mangan@pucrs.br
 * 
 */
public abstract class Figura {

	private int x;
	private int y;

	public Figura() {
		this.x = 0;
		this.y = 0;
	}
	
	public Figura(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Figura [x=%s, y=%s]", x, y);
	}

	/**
	 * 
	 * @return
	 */
	public abstract double getArea();
}
