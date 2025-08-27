import java.util.Scanner;

public class TestEcuacionLineal {
    
    static class EcuacionLineal {
        private double a;
        private double b;
        private double c;
        private double d;
        private double e;
        private double f;
        
        // Constructor
        public EcuacionLineal(double a, double b, double c, double d, double e, double f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }

        public EcuacionLineal() {
        }
        
        // Método tieneSolucion()
        public boolean tieneSolucion() {
            return (a * d - b * c) != 0;
        }
        
        // Método getX()
        public double getX() {
            return (e * d - b * f) / (a * d - b * c);
        }
        
        // Método getY()
        public double getY() {
            return (a * f - e * c) / (a * d - b * c);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese a, b, c, d, e, f: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        double e = scanner.nextDouble();
        double f = scanner.nextDouble();
        
        // Crear objeto de la ecuación lineal
        EcuacionLineal ecuacion = new EcuacionLineal(a, b, c, d, e, f);
        
        // Verificar si tiene solución
        if (ecuacion.tieneSolucion()) {
            double x = ecuacion.getX();
            double y = ecuacion.getY();
            System.out.printf("x = %.1f, y = %.1f%n", x, y);
        } else {
            System.out.println("La ecuación no tiene solución");
        }
    
    }
}