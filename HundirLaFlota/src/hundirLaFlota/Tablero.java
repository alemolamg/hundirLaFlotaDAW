package hundirLaFlota;


public class Tablero {
	
	
	private static int tamX = 11;
	private static int tamY = 11;
	
	int[][] matriz = new int[tamX][tamY];
	
	
	public Tablero() {
		
		tamX = 11;
		tamY = 11;
		
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
		return tamX;
	}


	public static void setTamX(int tamX) {
		Tablero.tamX = tamX;
	}


	public static int getTamY() {
		return tamY;
	}


	public static void setTamY(int tamY) {
		Tablero.tamY = tamY;
	}
}
