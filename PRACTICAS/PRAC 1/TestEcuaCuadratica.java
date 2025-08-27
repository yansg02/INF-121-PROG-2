import java.util.Scanner;

public class TestEcuaCuadratica{
    
    static class EcuacionCuadratica {
        private double a;
        private double b;
        private double c;
        

        public EcuacionCuadratica(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public EcuacionCuadratica() {
        }
        
        public double getDiscriminante() {
            return b * b - 4 * a * c;
        }
        
        public double getRaiz1() {
            double discriminante = getDiscriminante();
            if (discriminante >= 0) {
                return (-b + Math.sqrt(discriminante)) / (2 * a);
            }
            return 0;
        }
        
        public double getRaiz2() {
            double discriminante = getDiscriminante();
            if (discriminante >= 0) {
                return (-b - Math.sqrt(discriminante)) / (2 * a);
            }
            return 0;
        }

        public double getA() {
            return a;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese a, b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        
        EcuacionCuadratica ecuacion = new EcuacionCuadratica(a, b, c);
        double discriminante = ecuacion.getDiscriminante();
        
        if (discriminante > 0) {
            double raiz1 = ecuacion.getRaiz1();
            double raiz2 = ecuacion.getRaiz2();
            System.out.printf("La ecuación tiene dos raíces %.6f y %.6f%n", raiz1, raiz2);
        } else if (discriminante == 0) {
            double raiz = ecuacion.getRaiz1(); // Ambas raíces son iguales
            System.out.printf("La ecuación tiene una raíz %.6f%n", raiz);
        } else {
            System.out.println("La ecuación no tiene raíces reales");
        }
        
    }
}