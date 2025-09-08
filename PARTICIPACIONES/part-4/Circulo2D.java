public class Circulo2D {
   
    private double x;
    private double y;
    private double radio;
    
   
    public Circulo2D() {
        this(0, 0, 1);
    }
    
    
    public Circulo2D(double x, double y, double radio) {
        this.x = x;
        this.y = y;
        this.radio = radio;
    }
    
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getRadio() {
        return radio;
    }
    
    
    public double getArea() {
        return Math.PI * radio * radio;
    }
    
    
    public double getPerimetro() {
        return 2 * Math.PI * radio;
    }
    
    
    public boolean contiene(double x, double y) {
        double distancia = Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
        return distancia <= radio;
    }
    
    
    public boolean contiene(Circulo2D circulo) {
        double distanciaCentros = Math.sqrt(Math.pow(circulo.getX() - this.x, 2) + 
                                           Math.pow(circulo.getY() - this.y, 2));
        return distanciaCentros + circulo.getRadio() <= this.radio;
    }
    
    
    public boolean sobrepone(Circulo2D circulo) {
        double distanciaCentros = Math.sqrt(Math.pow(circulo.getX() - this.x, 2) + 
                                           Math.pow(circulo.getY() - this.y, 2));
        return distanciaCentros < (this.radio + circulo.getRadio()) && 
               !this.contiene(circulo) && 
               !circulo.contiene(this);
    }
    
    
    public static void main(String[] args) {
        
        Circulo2D c1 = new Circulo2D(2, 0, 1);
        
        System.out.println("Área de c1: " + c1.getArea());
        System.out.println("Perímetro de c1: " + c1.getPerimetro());
        System.out.println();
        
        
        System.out.println("c1.contiene(2.5, 0): " + c1.contiene(2.5, 0));
        
        
        Circulo2D circuloPequeño = new Circulo2D(2, 0, 0.5);
        System.out.println("c1.contiene(Circulo2D(2, 0, 0.5)): " + c1.contiene(circuloPequeño));
        
        
        Circulo2D circuloGrande = new Circulo2D(0, 0, 2);
        System.out.println("c1.sobrepone(Circulo2D(0, 0, 2)): " + c1.sobrepone(circuloGrande));
    }
}