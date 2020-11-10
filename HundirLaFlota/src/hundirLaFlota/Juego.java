package hundirLaFlota;

public class Juego {

	public static void main(String[] args) {
		
		Jugador jugadorHum1 = new Jugador();
		Jugador jugadorHum2 = new Jugador();
		
	
		while (!finJuego (jugadorHum1, jugadorHum2)) {
			// El método "lanzaTiradaSobretablero" pide al usuario los datos
			// para hacer una tirada sobre un tablero. Comprueba si el tablero
			// tiene parte de barco en la tirada o sólo agua e informa en 
			// pantalla.
			jugadorHum1.lanzaTiradaSobreTablero(jugadorHum2.tableroJugador);
			jugadorHum2.lanzaTiradaSobreTablero(jugadorHum1.tableroJugador);
			
			jugadorHum1.mostrarTablero();
			jugadorHum2.mostrarTablero();
		}
	}

}
