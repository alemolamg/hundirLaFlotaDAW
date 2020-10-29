package hundirLaFlota;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hundirLaFlota.ParteDeBarco;

/**
 * Clase Barco creada para trabajar con las funciones.
 * Es la clase que realiza las acciones.
 * @author Alemol
 * {@link https://github.com/alemolamg/hundirLaFlotaDAW.git}
 */
public class Barco {
	private int tamanioBarco;
	private List<ParteDeBarco> listaPartes = new ArrayList<ParteDeBarco>();
	private boolean hundido = false;
	private int direccion;
//	private Tablero tableroPartida;
	

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

	/**
	 * Calcula que dirección debe usar.
	 * Importante, solo hay cuatro direcciones válidas
	 * @param posX  (int) Posición inicial de la X
	 * @param posY	(int) Posición inicial de la Y
	 * @param direccion	(String) espera: Derecha, Izquierda, Arriba, Abajo. Otro valor no funciona.
	 * @param tableroPartida 
	 */
	public void calcularDireccion (int posX, int posY, String direccion, Tablero tableroPartida) {
		boolean poder = false;		
		if (direccion == "Derecha")
			poder = this.colocarDerecha(posX, posY, tableroPartida);
		if (direccion == "Izquierda")
			poder = this.colocarIzquierda(posX, posY, tableroPartida);	
		if (direccion == "Arriba")
			poder = this.colocarArriba(posX, posY, tableroPartida);
		if (direccion == "Abajo")
			poder = this.colocarAbajo(posX, posY, tableroPartida);
		
		if (poder)
			System.out.println("Barco introducido correctamente");
		else
			System.out.println("No se ha podido introducir el Barco");
		
	}
	
	/**
	 * Coloca el barco en la dirección Derecha.
	 * @param posX	posición inicial de la X
	 * @param posY	posición inicial de la Y
	 * @param tabPartida (Tablero) Tablero donde se añade las partes.
	 * @return	True si puede meterlo, false si no.
	 */
	private boolean colocarDerecha (int posX, int posY, Tablero tabPartida) {
		if((tamanioBarco + posX -1) < tabPartida.getTamX()) {
			int i = posX;
//			for (i = posX; i < this.tamanioBarco + posX; i++) { 	//Recorrer las casillas hacia la derecha
//				Tablero.matriz[posX][posY] = 1;						//Error, no se puede añadir a la casilla.
//				Tablero.aniadirParteBarco(i, posY);
//				this.listaPartes.get(i).setCoordX(i);
//				this.listaPartes.get(i).setCoordY(posY);
//			}
//		
			for (ParteDeBarco iterator : this.listaPartes) {	//for-each para recorrer la listaPartes
				iterator.setCoordX(i);
				iterator.setCoordY(posY);
				tabPartida.aniadirParteBarco(i, posY);
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
	 * @param tabPartida (Tablero) Tablero donde se añade las partes.
	 * @return	True si puede meterlo, false si no.
	 */
	private boolean colocarIzquierda (int posX, int posY, Tablero tabPartida) {
		if((tamanioBarco - posX + 1) >= 0) {
			int i = posX;
			for (ParteDeBarco iterator : this.listaPartes) {	//for-each para recorrer la listaPartes
				iterator.setCoordX(i);
				iterator.setCoordY(posY);
				tabPartida.aniadirParteBarco(i, posY);
				i--;
			}
		} else 
			return false;
		return true;	
	}
	
	
	/**
	 * Coloca el barco en la dirección Arriba.
	 * @param posX	posición inicial de la X
	 * @param posY	posición inicial de la Y
	 * @param tabPartida (Tablero) Tablero donde se añade las partes.
	 * @return	True si puede meterlo, false si no.
	 */
	private boolean colocarArriba (int posX, int posY, Tablero tabPartida) {
		if((tamanioBarco + posY -1) < Tablero.getTamY()) {
			int i = posY;
			for (ParteDeBarco iterator : this.listaPartes) {	//for-each para recorrer la listaPartes
				iterator.setCoordX(posX);
				iterator.setCoordY(i);
				tabPartida.aniadirParteBarco(posX, i);
				i++;
			}
		}else 
			return false;
		return true;	
	}
	
	/**
	 * Coloca el barco en la dirección Abajo.
	 * @param posX	(int) posición inicial de la X
	 * @param posY	(int) posición inicial de la Y
	 * @param tabPartida (Tablero) Tablero donde se añade las partes.
	 * @return	True si puede meterlo, false si no.
	 */
	private boolean colocarAbajo (int posX, int posY, Tablero tabPartida) {
		if((tamanioBarco - posY + 1) >= 0) {
			int i = posY;
			for (ParteDeBarco iterator : this.listaPartes) {	//for-each para recorrer la listaPartes
				iterator.setCoordX(posX);
				iterator.setCoordY(i);
				tabPartida.aniadirParteBarco(posX, i);
				i--;
			}
		}else
			return false;
		return true;	
	}
	
	
}
