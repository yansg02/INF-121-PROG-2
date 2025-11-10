import java.util.ArrayList;
import java.util.List;
class Autor {
    private String nombre;
    private String nacionalidad;

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
    
    public void mostrarInfo() {
        System.out.println("Autor: " + nombre + " - " + nacionalidad);
    }
    
    public String getNombre() {
        return nombre;
    }
}
class Pagina {
    private int numero;
private String contenido;
    public Pagina(int numero, String contenido) {
        this.numero = numero;
        this.contenido = contenido;
    }
    public void mostrarContenido() {
        System.out.println("Página " + numero + ": " + contenido);
    }
}

class Libro {
    private String titulo;
    private String isbn;
    private List<Pagina> paginas;
    public Libro(String titulo, String isbn, List<String> contenidos) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.paginas = new ArrayList<>();
        for (int i = 0; i < contenidos.size(); i++) {
            this.paginas.add(new Pagina(i + 1, contenidos.get(i)));
        }
    }
    
    public void leer() {
        System.out.println("Leyendo libro: " + titulo);
        for (Pagina pagina : paginas) {
            pagina.mostrarContenido();
        }
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getIsbn() {
        return isbn;
    }
}

class Estudiante {
    private String codigo;
    private String nombre;
    public Estudiante(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + " - Código: " + codigo);
    }
    
    public String getNombre() {
        return nombre;
    }
}

class Prestamo {
    private String fechaPrestamo;
    private String fechaDevolucion;
    private Estudiante estudiante;
    private Libro libro;
    public Prestamo(Estudiante estudiante, Libro libro) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = "01/11/2024";
        this.fechaDevolucion = "15/11/2024";
    }
    
    public void mostrarInfo() {
        System.out.println("Préstamo: " + libro.getTitulo() + 
                         " a " + estudiante.getNombre() +
                         " | Préstamo: " + fechaPrestamo +
                         " | Devolución: " + fechaDevolucion);
    }
}

class Horario {
    private String dias;
    private String horaApertura;
    private String horaCierre;
    
    public Horario(String dias, String horaApertura, String horaCierre) {
        this.dias = dias;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }
    public void mostrarHorario() {
        System.out.println("Horario: " + dias + " de " + horaApertura + " a " + horaCierre);
    }
}

class Biblioteca {
    private String nombre;
    private List<Libro> libros;
    private List<Autor> autores;
    private List<Prestamo> prestamos;
    private Horario horario;
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.horario = new Horario("Lunes a Viernes", "08:00", "20:00");
    }
    
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());
    }
    
    public void agregarAutor(Autor autor) {
        autores.add(autor);
        System.out.println("Autor registrado: " + autor.getNombre());
    }
    
    public void prestarLibro(Estudiante estudiante, Libro libro) {
        Prestamo prestamo = new Prestamo(estudiante, libro);
        prestamos.add(prestamo);
        System.out.println("Préstamo realizado:");
        prestamo.mostrarInfo();
    }
    
    public void mostrarEstado() {
        System.out.println("\n=== ESTADO BIBLIOTECA " + nombre + " ===");
        System.out.println("Total libros: " + libros.size());
        System.out.println("Total autores: " + autores.size());
        System.out.println("Préstamos activos: " + prestamos.size());
        horario.mostrarHorario();

        System.out.println("\n--- Libros Disponibles ---");
        for (Libro libro : libros) {
            System.out.println("- " + libro.getTitulo() + " (ISBN: " + libro.getIsbn() + ")");
        }
        
        System.out.println("\n--- Préstamos Activos ---");
        for (Prestamo prestamo : prestamos) {
            prestamo.mostrarInfo();
        }
    }
    
    public void cerrarBiblioteca() {
        System.out.println("La biblioteca " + nombre + " ha cerrado.");
        prestamos.clear();
    }
}

public class SistemaBiblioteca {
    public static void main(String[] args) {
        System.out.println("SISTEMA DE BIBLIOTECA UNIVERSITARIA");
        Biblioteca biblioteca = new Biblioteca("UMSA Central");
        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiana");
        Autor autor2 = new Autor("Mario Vargas Llosa", "Peruana");
        List<String> paginasLibro1 = new ArrayList<>();
        paginasLibro1.add("Muchos años después...");
        paginasLibro1.add("El coronel Aureliano...");
        List<String> paginasLibro2 = new ArrayList<>();
        paginasLibro2.add("Cuatro cadetes del Colegio...");
        paginasLibro2.add("La vida en el internado...");
        
        Libro libro1 = new Libro("Cien Años de Soledad", "978-123456", paginasLibro1);
        Libro libro2 = new Libro("La Ciudad y los Perros", "978-789012", paginasLibro2);
        
        Estudiante estudiante1 = new Estudiante("2021001", "Juan Pérez");
        Estudiante estudiante2 = new Estudiante("2021002", "María García");
        
        System.out.println("\n=== AGREGACIÓN ===");
        biblioteca.agregarAutor(autor1);
        biblioteca.agregarAutor(autor2);
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        
        System.out.println("\n=== COMPOSICIÓN ===");
        libro1.leer();
        
        System.out.println("\n=== ASOCIACIÓN ===");
        biblioteca.prestarLibro(estudiante1, libro1);
        biblioteca.prestarLibro(estudiante2, libro2);
        
        System.out.println("\n=== INFORMACIÓN GENERAL ===");
        biblioteca.mostrarEstado();
        
        System.out.println("\n=== INFORMACIÓN AUTORES ===");
        autor1.mostrarInfo();
        autor2.mostrarInfo();
        
        System.out.println("\n=== INFORMACIÓN ESTUDIANTES ===");
        estudiante1.mostrarInfo();
        estudiante2.mostrarInfo();
        
        System.out.println("\n=== CIERRE ===");
        biblioteca.cerrarBiblioteca();
        biblioteca.mostrarEstado();
    }
}