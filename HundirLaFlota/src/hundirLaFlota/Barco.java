package hundirLaFlota;

import java.util.ArrayList;
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
		
		
	
	}
	
	
	

}
