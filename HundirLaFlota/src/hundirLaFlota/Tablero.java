package hundirLaFlota;


public class Tablero {
	
	
	private static int TAM_X = 11;
	private static int TAM_Y = 11;
	
	int[][] matriz = new int[TAM_X][TAM_Y];
	
	
	public Tablero() {
		
		TAM_X = 11;
		TAM_Y = 11;
		
		Tablero.rellenarMatrizNumAzarInt(matriz);
		
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static int ObtenerNumAzarEntero() {
		
		int num = (int) Math.round(Math.random()*0);
		
		return num;
	}
	
	
	/**
	 * 
	 * @param matrizVar
	 * @return
	 */
	public static int[][] rellenarMatrizNumAzarInt (int[][] matrizVar ) {
		
		for (int i = 0; i < matrizVar.length; i++) {
					
					
					
					for (int j = 0; j < matrizVar[i].length; j++) {
						
						matrizVar[i][j] = Tablero.ObtenerNumAzarEntero();
						
						
					}
					
				}
		return matrizVar;
	}
	
	
	


	/**
	 * 
	 * @param matrizVar
	 * @return 
	 */
	public static void mostrarMatriz (int[][] matrizVar) {
		
		for (int i = 0; i < matrizVar.length; i++) {
			
			
			for (int j = 0; j < matrizVar[i].length; j++) {
				
				System.out.print(matrizVar[i][j] + "\t");
				
			}
			
			System.out.print("\n");
		}
		
	}
	
	
	public void mostrarTablero () {
		
		
		 Tablero.mostrarMatriz(this.matriz);
		
		
	}
	
	

	public static int getTamX() {
		return TAM_X;
	}


	public static void setTamX(int tamX) {
		Tablero.TAM_X = tamX;
	}


	public static int getTamY() {
		return TAM_Y;
	}


	public static void setTamY(int tamY) {
		Tablero.TAM_Y = tamY;
	}
	
	
	/**
	 * Método que sirve para añadir a una casilla la posición de colocar el barco
	 * @param x	posición X
	 * @param y posición Y
	 * @return	boolean: true si lo puede colocar, false si no puede.
	 */
	public boolean aniadirParteBarco (int x, int y) {
		if (this.matriz[x][y] == 0)
			this.matriz[x][y] = 1;
		else
			return false;
		return true;		
	}
}
