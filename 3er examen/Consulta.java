import com.google.gson.*;

public class Consulta {
    private int ci;
    private String nombrePaciente;
    private String apellidoPaciente;
    private int idMed;
    private int dia;
    private String mes;
    private int anio;

    public Consulta() {}
    public Consulta(int ci, String nombre, String apellido, int idMed, int dia, String mes, int anio) {
        this.ci = ci;
        this.nombrePaciente = nombre;
        this.apellidoPaciente = apellido;
        this.idMed = idMed;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getCi() { return ci; }
    public void setCi(int ci) { this.ci = ci; }
    public String getNombrePaciente() { return nombrePaciente; }
    public void setNombrePaciente(String nombre) { this.nombrePaciente = nombre; }
    public String getApellidoPaciente() { return apellidoPaciente; }
    public void setApellidoPaciente(String apellido) { this.apellidoPaciente = apellido; }
    public int getIdMed() { return idMed; }
    public void setIdMed(int idMed) { this.idMed = idMed; }
    public int getDia() { return dia; }
    public void setDia(int dia) { this.dia = dia; }
    public String getMes() { return mes; }
    public void setMes(String mes) { this.mes = mes; }
    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }
}
