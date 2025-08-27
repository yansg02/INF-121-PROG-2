import java.util.Scanner;

public class Estadisticas {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese 10 números:");
        double suma = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Número " + i + ": ");
            double numero = scanner.nextDouble();
            suma += numero;
        }
        
        double promedio = suma / 10;
        
        System.out.println("\nIngrese los mismos 10 números nuevamente para calcular la desviación:");
        double sumaDiferencias = 0;
        
        for (int i = 1; i <= 10; i++) {
            System.out.print("Número " + i + ": ");
            double numero = scanner.nextDouble();
            sumaDiferencias += Math.pow(numero - promedio, 2);
        }
        
        double desviacion = Math.sqrt(sumaDiferencias / 9);
        
        System.out.printf("El promedio es %.2f%n", promedio);
        System.out.printf("La desviación estándar es %.5f%n", desviacion);
        
    }
}