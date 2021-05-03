import java.util.Scanner;
import java.util.Arrays;

public class Calculadora_Matrices {

	private static int opcionElegida;
	
	public static void main(String[] args) {
		boolean salir_menu = false;
		while (!salir_menu) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Selecciona una opcion");
			System.out.println("_____________________");
			System.out.println(" 1 Suma de matrices");
			System.out.println(" 2 Poducto de un escalar de matrices");
			System.out.println(" 3 Producto de dos matrices");
			System.out.println(" 4 Transponer una matriz");
			System.out.println(" 5 Diagonal de una matriz");
			System.out.println(" 6 Comprbar si es simetrica una matriz");
			System.out.println(" 7 Potencia de una matriz cuadada");
			System.out.println(" 8 Resta de dos matrices");
			System.out.println(" 9 Salir");
			int menu = sc.nextInt();
			opcionElegida = menu;
			switch (menu) {
			case 1:
				sumaMatrices();
				break;
			case 2:
				productoEscalar();
				break;
			case 3:
				productoMatrices();
				break;
			case 4:
				transponerMatriz();
				break;
			case 5:
				diagonalMatriz();
				break;
			case 6:
				matrizSimetrica();
				break;
			case 7:
				potenciaMatriz();
				break;
			case 8:
				restaMatrices();
				break;
			case 9:
				salir_menu = true;
				break;
			}			
		}

	}
	
	private static void sumaMatrices() {
		
		Scanner sc = new Scanner(System.in);
		
		if (opcionElegida == 8) {
			System.out.println("Resta de matrices");
		}else {
			System.out.println("Suma de matrices");
		}
		
		int[][] matrizA = obtenerMatriz();
		int[][] matrizB = obtenerMatriz();
		int[][] matrizC = new int [matrizA.length][matrizA[0].length];
		
		if(matrizA.length == matrizB.length && matrizA[0].length == matrizB[0].length) {
			
			//SUMAR MATRIZ A + B
			for (int x = 0; x <matrizA.length ; x++) {
				for (int z = 0; z <matrizA[0].length ; z++) {
					if (opcionElegida == 8) {
						matrizC[x][z] = matrizA[x][z] - matrizB[x][z];
					}else {
						matrizC[x][z] = matrizA[x][z] + matrizB[x][z];
					}
				}
			}
		
			//MOSTRAR MATRIZ C RESULTANTE
			for (int x = 0; x < matrizC.length; x++) {
				System.out.println(Arrays.toString(matrizC[x]));
			}
			
		}else {
			System.out.println("Las matrices deben ser de iguales dimensiones");
		}
		
		System.out.println(".....................");
		
	}
	
	private static void productoEscalar() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Producto de un escalar");
		
		int[][] matrizA = obtenerMatriz();
		int[][] matrizB = new int [matrizA.length][matrizA[0].length];
		
		System.out.println("Dame un escalar");
		int escalar = sc.nextInt();
		
		//MULTIPLICAR MATRIZ A * ESCALAR
		for (int x = 0; x <matrizA.length ; x++) {
			for (int z = 0; z <matrizA[0].length ; z++) {
				matrizB[x][z] = matrizA[x][z] * escalar;
			}
		}
		
		//MOSTRAR MATRIZ B RESULTANTE
		for (int x = 0; x < matrizB.length; x++) {
			System.out.println(Arrays.toString(matrizB[x]));
		}
		
		System.out.println(".....................");
		
	}
	
	private static void productoMatrices() {
		
		System.out.println("Producto de dos matrices");
		
		int[][] matrizA = obtenerMatriz();
		int[][] matrizB = obtenerMatriz();
		int[][] matrizC = new int [matrizA.length][matrizB[0].length];
		int suma = 0;
		
		if(matrizA[0].length == matrizB.length) {
			
			for (int i = 0; i < matrizA.length; i++) {
				for (int j = 0; j < matrizB[0].length; j++) {
					suma = 0;
					for (int k = 0; k < matrizB.length; k++) {
						suma = suma + matrizA[i][k] * matrizB[k][j];
						matrizC[i][j] =  suma;
					}
				}
			}
			
			//MOSTRAR MATRIZ C RESULTANTE
			for (int x = 0; x < matrizC.length; x++) {
				System.out.println(Arrays.toString(matrizC[x]));
			}
			
		}else {
			System.out.println("Las matrices estan fueras de los argumentos");
		}
		
		System.out.println(".....................");
		
	}
	
	private static void transponerMatriz() {
		
		System.out.println("Transponer una matriz");
		
		int[][] matrizA = obtenerMatriz();
		int[][] matrizB = new int [matrizA[0].length][matrizA.length];

		
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA[0].length; j++) {
				matrizB[j][i] = matrizA[i][j];
			}
		}
			
		//MOSTRAR MATRIZ B RESULTANTE
		for (int x = 0; x < matrizB.length; x++) {
			System.out.println(Arrays.toString(matrizB[x]));
		}
				
		System.out.println(".....................");
		
	}
	
	private static void diagonalMatriz() {
		
		System.out.println("Diagonal de una matriz");
		
		int[][] matrizA = obtenerMatriz();
		int[] arrayResultante = new int [matrizA.length];

		if(matrizA.length == matrizA[0].length) {
			
			for (int i = 0 ; i < matrizA.length ; i++) {
				arrayResultante[i] = matrizA[i][i];
			}
			
			//MOSTRAR ARRAY RESULTANTE
			System.out.println(Arrays.toString(arrayResultante));
			
		}else {
			System.out.println("La matriz ha de ser cuadrada");
		}
		
		System.out.println(".....................");
		
	}
	
	private static void matrizSimetrica() {
		
		System.out.println("Comprobar si una matriz es simetrica");
		
		int[][] matrizA = obtenerMatriz();
		int[][] matrizB = new int [matrizA.length][matrizA[0].length];
		
		boolean esSimetrica = true;
	
		if(matrizA.length == matrizA[0].length) {
			for (int i = 0; i < matrizA.length; i++) {
				for (int j = 0; j < matrizA[0].length; j++) {
					matrizB[j][i] = matrizA[i][j];
				}
			}
		
			for (int x = 0; x <matrizA.length ; x++) {
				for (int z = 0; z <matrizA[0].length ; z++) {
					
					if(matrizA[x][z] != matrizB[x][z]) {
						esSimetrica = false;
					}
				}
			}
			
			//MOSTRAR RESULTADO
			if(esSimetrica == true) {
				System.out.println("La matriz es simetrica");
			}else {
				System.out.println("La matriz no es simetrica");
			}
		}else {
			System.out.println("La matriz debe ser cuadrada");
		}
		
			
		System.out.println(".....................");
		
	}
	
	private static void potenciaMatriz() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Potencia de una matriz cuadrada");
		
		int[][] matrizA = obtenerMatriz();
		int[][] matrizACopia = new int [matrizA.length][matrizA[0].length];
		int[][] matrizB = new int [matrizA.length][matrizA[0].length];
		int suma = 0;
		
		System.out.println("A cuanto quieres elevar tu matriz");
		int potencia = sc.nextInt();
		potencia--;
		
		//CREAMO UNA COPIA DE MATRIZ A
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA[0].length; j++) {
				matrizACopia[i][j] = matrizA[i][j];
			}
		}
		
		if(matrizA[0].length == matrizB.length) {
			
			for (int p = 0; p < potencia; p++) {
				for (int i = 0; i < matrizA.length; i++) {
					for (int j = 0; j < matrizA[0].length; j++) {
						suma = 0;
						for (int k = 0; k < matrizA.length; k++) {
							suma = suma + matrizA[i][k] * matrizACopia[k][j];
							matrizB[i][j] =  suma;
						}
					}
				}
				//ASIGNAMOS MATRIZ B A MATRIZ A COPIA
				for (int i = 0; i < matrizA.length; i++) {
					for (int j = 0; j < matrizA[0].length; j++) {
						matrizACopia[i][j] = matrizB[i][j];
					}
				}
			}
			//MOSTRAR MATRIZ B RESULTANTE
			for (int x = 0; x < matrizB.length; x++) {
				System.out.println(Arrays.toString(matrizB[x]));
			}
		}else {
			System.out.println("La matriz debe ser cuadrada");
		}
		
		System.out.println(".....................");
	
	}
	
	private static void restaMatrices() {
			
		sumaMatrices();
		
	}
	
	private static int[][] obtenerMatriz() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Cuantas filas quieres");
		int filas = sc.nextInt();
		System.out.println("Cuantas columnas quieres");
		int columnas = sc.nextInt();
		
		int[][] lista = new int[filas][columnas];
		
		// AÑADIR VALORES A LA MATRIZ
		for (int x = 0; x <lista.length ; x++) {
			for (int z = 0; z <lista[0].length ; z++) {
				System.out.println("Dame un numero");
				int a = sc.nextInt();
				lista[x][z] = a;
			}
		}
		
		return lista;
		
	}

}