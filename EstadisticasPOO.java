import java.util.Scanner;

public class EstadisticasPOO{
    
    static class Estadistica {
        private double num1, num2, num3, num4, num5, num6, num7, num8, num9, num10;
        
        public void setNumeros(double n1, double n2, double n3, double n4, double n5, 
                             double n6, double n7, double n8, double n9, double n10) {
            this.num1 = n1;
            this.num2 = n2;
            this.num3 = n3;
            this.num4 = n4;
            this.num5 = n5;
            this.num6 = n6;
            this.num7 = n7;
            this.num8 = n8;
            this.num9 = n9;
            this.num10 = n10;
        }
        
        public double getPromedio() {
            return (num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9 + num10) / 10;
        }
        
        public double getDesviacion() {
            double prom = getPromedio();
            double suma = 0;
            
            suma += Math.pow(num1 - prom, 2);
            suma += Math.pow(num2 - prom, 2);
            suma += Math.pow(num3 - prom, 2);
            suma += Math.pow(num4 - prom, 2);
            suma += Math.pow(num5 - prom, 2);
            suma += Math.pow(num6 - prom, 2);
            suma += Math.pow(num7 - prom, 2);
            suma += Math.pow(num8 - prom, 2);
            suma += Math.pow(num9 - prom, 2);
            suma += Math.pow(num10 - prom, 2);
            
            return Math.sqrt(suma / 9);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese 10 números:");
        System.out.print("Número 1: ");
        double n1 = sc.nextDouble();
        System.out.print("Número 2: ");
        double n2 = sc.nextDouble();
        System.out.print("Número 3: ");
        double n3 = sc.nextDouble();
        System.out.print("Número 4: ");
        double n4 = sc.nextDouble();
        System.out.print("Número 5: ");
        double n5 = sc.nextDouble();
        System.out.print("Número 6: ");
        double n6 = sc.nextDouble();
        System.out.print("Número 7: ");
        double n7 = sc.nextDouble();
        System.out.print("Número 8: ");
        double n8 = sc.nextDouble();
        System.out.print("Número 9: ");
        double n9 = sc.nextDouble();
        System.out.print("Número 10: ");
        double n10 = sc.nextDouble();
        
        Estadistica stats = new Estadistica();
        stats.setNumeros(n1, n2, n3, n4, n5, n6, n7, n8, n9, n10);
        
        System.out.printf("El promedio es %.2f%n", stats.getPromedio());
        System.out.printf("La desviación estándar es %.5f%n", stats.getDesviacion());
        
    }
}