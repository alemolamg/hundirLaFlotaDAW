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
	
	
	
	
	

}
