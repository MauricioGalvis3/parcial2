import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int[][] laberinto = new int[5][5];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Generar el laberinto con valores aleatorios del 1 al 9
        for (int fila = 0; fila < laberinto.length; fila++) {
            for (int col = 0; col < laberinto[fila].length; col++) {
                laberinto[fila][col] = random.nextInt(9) + 1;
            }
        }

        // Mostrar el laberinto generado
        System.out.println("=== LABERINTO UNIVERSITARIO ===");
        mostrarMatriz(laberinto);

        // Instrucciones del reto
        System.out.println("""
        ¡Bienvenido al Laberinto Universitario!
        Este sistema representa los pasillos secretos de tu facultad.
        Cada número indica un nivel de energía en ese punto.
        Tu misión es explorar este laberinto cumpliendo los siguientes desafíos:

        1. Contar cuántos números pares hay mayores a 4. ⚡
        2. Calcular el promedio de los números impares. 🎯
        3. Calcular la suma de los valores de cada fila. 🧮
        4. BONUS: Encuentra la posición del mayor número del laberinto. 👑
        """);

        // Aquí puedes invocar los métodos para cada uno de los puntos anteriores
         contarParesMayoresA4(laberinto);
         promedioImpares(laberinto);
         sumaFilas(laberinto);
        encontrarMayorNumero(laberinto);


        scanner.close();
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }
    public static void contarParesMayoresA4(int[][] matriz) {
        int contador = 0;
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor % 2 == 0 && valor > 4) {
                    contador++;
                }
            }
        }
        System.out.println("Cantidad de números pares mayores a 4: " + contador);
    }
  
   public static void promedioImpares(int[][] matriz) {
        int suma = 0;
        int contador = 0;
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor % 2 != 0) {
                    suma += valor;
                    contador++;
                }
            }
        }
        System.out.println("el promedio de numeros impares es : "+ contador);
   }
    public static void sumaFilas(int[][] matriz) {
        System.out.println("Suma de los valores de cada fila:");
        for (int i = 0; i < matriz.length; i++) {
            int suma = 0;
            for (int valor : matriz[i]) {
                suma += valor;
            }
            System.out.println("Fila " + (i + 1) + ": " + suma);
        }
    }

public static void encontrarMayorNumero(int[][] matriz) {
        int mayor = matriz[0][0];
        int filaMayor = 0;
        int colMayor = 0;

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int col = 0; col < matriz[fila].length; col++) {
                if (matriz[fila][col] > mayor) {
                    mayor = matriz[fila][col];
                    filaMayor = fila;
                    colMayor = col;
                }
            }
        }

        System.out.println("El mayor número es " + mayor + " en la posición (" + filaMayor + ", " + colMayor + ")");
    }
}
