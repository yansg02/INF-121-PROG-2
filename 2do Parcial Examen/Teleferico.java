import java.util.*;

class Persona {
    String nombre;
    int edad;
    float pesoPersona;

    public Persona(String nombre, int edad, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.pesoPersona = peso;
    }

}
class Cabina {
    int nroCabina;
    ArrayList<Persona> personasAbordo;

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        this.personasAbordo = new ArrayList<>();
    }

    public void agregarPersona(Persona p) {
        personasAbordo.add(p);
    }

    public float pesoTotal() {
        float sum = 0;
        for (Persona p : personasAbordo) sum += p.pesoPersona;
        return sum;
    }

    public int cantidadPersonas() {
        return personasAbordo.size();
    }
}

class Linea {
    String color;
    Queue<Persona> filaPersonas;
    Cabina[] cabinas;
    int cantidadCabinas;

    public Linea(String color) {
        this.color = color;
        this.cantidadCabinas = 0;
        this.filaPersonas = new LinkedList<>();
        this.cabinas = new Cabina[20];
    }

    public void agregarPersona(Persona p) {
        filaPersonas.add(p);
    }

    public void agregarCabina(int nroCab) {
        cabinas[cantidadCabinas] = new Cabina(nroCab);
        cantidadCabinas++;
    }

    public Cabina buscarCabina(int nro) {
        for (int i = 0; i < cantidadCabinas; i++) {
            if (cabinas[i].nroCabina == nro) return cabinas[i];
        }
        return null;
    }

    public boolean abordarPrimeraPersona(int nroX) {
        if (filaPersonas.isEmpty()) return false;
        Persona p = filaPersonas.peek();
        Cabina cab = buscarCabina(nroX);
        if (cab == null) return false;
        if (cab.cantidadPersonas() >= 10) return false;
        if (cab.pesoTotal() + p.pesoPersona > 850) return false;
        cab.agregarPersona(p);
        filaPersonas.poll();
        return true;
    }

    public boolean verificarReglas() {
        for (int i = 0; i < cantidadCabinas; i++) {
            Cabina cab = cabinas[i];
            if (cab.cantidadPersonas() > 10) return false;
            if (cab.pesoTotal() > 850) return false;
        }
        return true;
    }

    public float ingresoTotal() {
        float ingreso = 0;
        for (int i = 0; i < cantidadCabinas; i++) {
            for (Persona p : cabinas[i].personasAbordo) {
                if (p.edad < 25 || p.edad > 60) ingreso += 1.5f;
                else ingreso += 3f;
            }
        }
        return ingreso;
    }

    public float ingresoRegular() {
        float ingreso = 0;
        for (int i = 0; i < cantidadCabinas; i++) {
            for (Persona p : cabinas[i].personasAbordo) {
                if (p.edad >= 25 && p.edad <= 60) ingreso += 3f;
            }
        }
        return ingreso;
    }
}

class MiTeleferico {
    Linea[] lineas;
    float cantidadIngresos;

    public MiTeleferico() {
        lineas = new Linea[3];
        lineas[0] = new Linea("Amarilla");
        lineas[1] = new Linea("Roja");
        lineas[2] = new Linea("Verde");
    }

    public Linea lineaMayorIngresoRegular() {
        Linea best = lineas[0];
        for (int i = 1; i < 3; i++) {
            if (lineas[i].ingresoRegular() > best.ingresoRegular())
                best = lineas[i];
        }
        return best;
    }
}

public class evluation1 {
    public static void main(String[] args) {
        MiTeleferico mt = new MiTeleferico();

        Linea amarilla = mt.lineas[0];
        amarilla.agregarCabina(1);
        amarilla.agregarCabina(2);

        amarilla.agregarPersona(new Persona("Ana", 20, 55));
        amarilla.agregarPersona(new Persona("Luis", 40, 80));
        amarilla.agregarPersona(new Persona("Carlos", 70, 70));

        amarilla.abordarPrimeraPersona(1);
        amarilla.abordarPrimeraPersona(1);
        amarilla.abordarPrimeraPersona(2);

        System.out.println("Ingreso total línea amarilla: " + amarilla.ingresoTotal());
        System.out.println("Ingreso regular línea amarilla: " + amarilla.ingresoRegular());

        Linea mayor = mt.lineaMayorIngresoRegular();
        System.out.println("Línea con mayor ingreso regular: " + mayor.color);
    }
}


