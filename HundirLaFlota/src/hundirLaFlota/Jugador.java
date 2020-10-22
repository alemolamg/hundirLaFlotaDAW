package hundirLaFlota;

public class Jugador {

	String nombreJugador;
	
	//Cada jugador tendrá un tablero de juego distinto.
	Tablero tableroJugador = new Tablero();
	
	 //Número de barcos totales del jugador.
	static int contadorBarcos = 0;
	
	//Constructor Jugador
	public Jugador() {	
		
		String nombreJugador;
		Tablero tableroJugador = new Tablero();
		//Debe de tener un barco en el constructor? o en un metodo?
		
		// Cada jugador tendra 3 barcos distintos
		Barco portaviones = new Barco();
		Barco fragata = new Barco();
		Barco submarino = new Barco();
		
		
		
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static int[][] colocarBarcos() {
		
		//Bucle donde pediremos al jugador que situe los barcos 
		for (int i = 0; i < 3 ; i++) {
			
			
			
			contadorBarcos++;
		}
		return null;
		
	}
	
	
	
	
	
}
