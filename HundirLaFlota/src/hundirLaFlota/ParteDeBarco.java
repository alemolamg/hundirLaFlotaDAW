package hundirLaFlota;

public class ParteDeBarco {
	private int coordX;
	private int coordY;
	private boolean tocado = false;	
	
	
	/**
	 * Constructor con dos coordenadas y estado tocado
	 * @param x	(int) Coordenada X
	 * @param y	(int) Coordenada Y
	 * @param estado (bool)	Estado tocado.
	 */
	public ParteDeBarco(int x, int y, boolean estado) {
		coordX = x;
		coordY = y;
		tocado = estado;
	}

	/**
	 * Constructor con dos coordenadas.
	 * @param x	(int) Coordenada X
	 * @param y	(int) Coordenada Y
	 */
	public ParteDeBarco (int x, int y) {
		this.coordX = x;
		this.coordY = y;
		this.tocado = false;
	}
	
	/**
	 * @return the coordX
	 */
	public int getCoordX() {
		return coordX;
	}

	
	/**
	 * @param coordX the coordX to set
	 */
	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	
	/**
	 * @return the coordY
	 */
	public int getCoordY() {
		return coordY;
	}

	
	/**
	 * @param coordY the coordY to set
	 */
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	
	/**
	 * @return the tocado
	 */
	public boolean isTocado() {
		return tocado;
	}

	
	/**
	 * @param tocado the tocado to set
	 */
	public void setTocado(boolean tocado) {
		this.tocado = tocado;
	}
		
}
