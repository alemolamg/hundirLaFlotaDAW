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
				
		if (direccion == "Derecha")
			this.colocarDerecha(posX, posY);
			
		
		
	}
	
	
	private void colocarDerecha (int posX, int posY) {
		boolean wanda;
		if((tamanioBarco + posX -1) < Tablero.getTamX())
			for (int i = posX; i < this.tamanioBarco + posX; i++) { 	//Recorrer las casillas hacia la derecha
				Tablero.matriz[posX][posY] = 1;						//Error, no se puede añadir a la casilla.
			}
		
		
	}
	
}
