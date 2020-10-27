package hundirLaFlota;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import hundirLaFlota.ParteDeBarco;

public class Barco {
	private int tamanioBarco;
	private List<ParteDeBarco> listaPartes = new ArrayList<ParteDeBarco>();
	private boolean hundido = false;
	private int direccion;
	private Tablero tableroPartida;
	

	public Barco(int tamanio) {
		tamanioBarco = tamanio;
		for (int i = 0; i < tamanioBarco; i++) {
			listaPartes.add(new ParteDeBarco());
		}
		hundido = false;			
	}
	
	/**
	 * Añade una parte del barco a la lista
	 * @param parteBarco (parteDeBarco) elemento a añadir a la lista.
	 */
	public void addParteDeBarco (ParteDeBarco parteBarco) {
		this.listaPartes.add(parteBarco);
	}
	
	/**
	 * Comprueba si el barco está hundido
	 */
	public void comprobarHundido(){
		boolean seHunde = true;
		Iterator<ParteDeBarco> it = this.listaPartes.iterator() ;
		
		for(ParteDeBarco iterator : this.listaPartes) {	
			if(!iterator.isTocado())
				seHunde = false;
		}
		
		if (seHunde)
			this.hundido = true;
		else
			this.hundido = false;
	}

	/**
	 * @return the tamanioBarco
	 */
	public int getTamanioBarco() {
		return tamanioBarco;
	}

	/**
	 * @param tamanioBarco the tamanioBarco to set
	 */
	public void setTamanioBarco(int tamanioBarco) {
		this.tamanioBarco = tamanioBarco;
	}

	/**
	 * @return the listaPartes
	 */
	public List<ParteDeBarco> getListaPartes() {
		return listaPartes;
	}

	/**
	 * @param listaPartes the listaPartes to set
	 */
	public void setListaPartes(List<ParteDeBarco> listaPartes) {
		this.listaPartes = listaPartes;
	}

	/**
	 * @return the hundido
	 */
	public boolean isHundido() {
		return hundido;
	}

	/**
	 * @param hundido the hundido to set
	 */
	public void setHundido(boolean hundido) {
		this.hundido = hundido;
	}

	/**
	 * @return the direccion
	 */
	public int getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	
	
	public ParteDeBarco mostrarParteBarco(int x, int y) {
		ParteDeBarco buscaParte = null;
		
		for(ParteDeBarco iterator : this.listaPartes) {
			if(iterator.getCoordX() == x && iterator.getCoordY() == y)
				buscaParte = iterator;				
		}
		
		return buscaParte;		
	}

	
	public void calcularDireccion (int posX, int posY, String direccion) {
		boolean poder = true;		
		if (direccion == "Derecha")
			poder = this.colocarDerecha(posX, posY);
		if (direccion == "Izquierda")
			poder = this.colocarIzquierda(posX, posY);	
		if (direccion == "Arriba")
			poder = this.colocarArriba(posX, posY);
		if (direccion == "Abajo")
			poder = this.colocarAbajo(posX, posY);
		
		if (poder)
			System.out.println("Barco introducido correctamente");
		else
			System.out.println("No se ha podido introducir el Barco");
		
	}
	
	/**
	 * Coloca el barco en la dirección Derecha.
	 * @param posX	posición inicial de la X
	 * @param posY	posición inicial de la Y
	 * @return	True si puede meterlo, false si no.
	 */
	private boolean colocarDerecha (int posX, int posY) {
		if((tamanioBarco + posX -1) < tableroPartida.getTamX()) {
			int i = posX;
//			for (i = posX; i < this.tamanioBarco + posX; i++) { 	//Recorrer las casillas hacia la derecha
////				Tablero.matriz[posX][posY] = 1;						//Error, no se puede añadir a la casilla.
//				Tablero.aniadirParteBarco(i, posY);
//				this.listaPartes.get(i).setCoordX(i);
//				this.listaPartes.get(i).setCoordY(posY);
//			}
//		
			for (ParteDeBarco iterator : this.listaPartes) {
				iterator.setCoordX(i);
				iterator.setCoordY(posY);
				this.tableroPartida.aniadirParteBarco(i, posY);
				i++;
			}
		
		}else 
			return false;
		return true;	
	}

	
	/**
	 * Coloca el barco en la dirección Izquierda.
	 * @param posX	posición inicial de la X
	 * @param posY	posición inicial de la Y
	 * @return	True si puede meterlo, false si no.
	 */
	private boolean colocarIzquierda (int posX, int posY) {
		if((tamanioBarco - posX + 1) >= 0)
			for (int i = posX; i >= 0; i--) { 	//Recorrer las casillas hacia la Izquierda.
				Tablero.aniadirParteBarco(i, posY);
			}
		else 
			return false;
		return true;	
	}
	
	
	/**
	 * Coloca el barco en la dirección Arriba.
	 * @param posX	posición inicial de la X
	 * @param posY	posición inicial de la Y
	 * @return	True si puede meterlo, false si no.
	 */
	private boolean colocarArriba (int posX, int posY) {
		if((tamanioBarco + posY -1) < Tablero.getTamY())
			for (int i = posY; i < this.tamanioBarco + posY; i++) { 	//Recorrer las casillas hacia la Arriba.
				Tablero.aniadirParteBarco(posX, i);
			}
		else 
			return false;
		return true;	
	}
	
	/**
	 * Coloca el barco en la dirección Abajo.
	 * @param posX	posición inicial de la X
	 * @param posY	posición inicial de la Y
	 * @return	True si puede meterlo, false si no.
	 */
	private boolean colocarAbajo (int posX, int posY) {
		if((tamanioBarco - posY + 1) >= 0)
			for (int i = posY; i >= 0; i--) { 	//Recorrer las casillas hacia la Izquierda.
				Tablero.aniadirParteBarco(posX, i);
			}
		else 
			return false;
		return true;	
	}
	
	
}
