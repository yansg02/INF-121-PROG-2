import com.google.gson.*;

public class Medico {
    private int idMed;
    private String nombreMed;
    private String apellidoMed;
    private int aniosExperiencia;

    public Medico() {}
    public Medico(int idMed, String nombre, String apellido, int experiencia) {
        this.idMed = idMed;
        this.nombreMed = nombre;
        this.apellidoMed = apellido;
        this.aniosExperiencia = experiencia;
    }

    public int getIdMed() { return idMed; }
    public void setIdMed(int idMed) { this.idMed = idMed; }
    public String getNombreMed() { return nombreMed; }
    public void setNombreMed(String nombre) { this.nombreMed = nombre; }
    public String getApellidoMed() { return apellidoMed; }
    public void setApellidoMed(String apellido) { this.apellidoMed = apellido; }
    public int getAniosExperiencia() { return aniosExperiencia; }
    public void setAniosExperiencia(int experiencia) { this.aniosExperiencia = experiencia; }
}
