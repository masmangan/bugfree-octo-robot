package alpro2.desenhador;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author marco.mangan@pucrs.br
 * 
 */
public class Desenhador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Figura> figuras;

	/**
	 * 
	 */
	public Desenhador() {
		figuras = new ArrayList<Figura>();
	}

	/**
	 * 
	 * @param q
	 */
	public void guardar(Figura q) {
		if (q == null) {
			throw new IllegalArgumentException("A figura não pode ser null.");
		}
		figuras.add(q);
	}

	/**
	 * 
	 * @return
	 */
	public String listar() {
		String resultado = "";
		for (int i = 0; i < figuras.size(); i++) {
			resultado += String.format("%d.%s\n", i + 1, figuras.get(i));
		}
		return resultado;
	}

	/**
	 * 
	 * Causa ArrayIndexOutOfBoundsException caso <code> pos </code> seja um
	 * valor de índice inválido.
	 * 
	 * @param pos
	 * @return
	 */
	public Figura getFiguraAt(int pos) {
		return figuras.get(pos);
	}

	/**
	 * 
	 * @param ler
	 */
	public void setFiguras(Desenhador ler) {
		figuras = ler.figuras;
	}
}
