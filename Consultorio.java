import com.google.gson.*;
import java.io.*;
import java.util.*;

public class Consultorio {
    private List<Consulta> consultas = new ArrayList<>();
    private List<Medico> medicos = new ArrayList<>();
    private Gson gson = new Gson();

    public void altaMedico(Medico medico) {
        try {
            medicos.add(medico);
            guardar();
            System.out.println("Médico registrado: " + medico.getNombreMed());
        } catch (Exception e) {}
    }

    public void altaConsulta(Consulta consulta) {
        try {
            consultas.add(consulta);
            guardar();
        } catch (Exception e) {}
    }

    public void bajaMedico(String nombre, String apellido) {
        try {
            for (Medico m : medicos) {
                if (m.getNombreMed().equalsIgnoreCase(nombre) && m.getApellidoMed().equalsIgnoreCase(apellido)) {
                    medicos.remove(m);
                    consultas.removeIf(c -> c.getIdMed() == m.getIdMed());
                    guardar();
                    System.out.println("Médico eliminado: " + nombre + " " + apellido);
                    return;
                }
            }
            System.out.println("Médico no encontrado");
        } catch (Exception e) {}
    }

    public void cambiarDiaNavidadAnioNuevo(int nuevoDia, String nuevoMes) {
        try {
            int cambios = 0;
            for (Consulta c : consultas) {
                if ((c.getDia() == 25 && c.getMes().equalsIgnoreCase("diciembre")) ||
                    (c.getDia() == 1 && c.getMes().equalsIgnoreCase("enero"))) {
                    c.setDia(nuevoDia);
                    c.setMes(nuevoMes);
                    cambios++;
                }
            }
            guardar();
            System.out.println(cambios + " consultas cambiadas");
        } catch (Exception e) {}
    }

    public void mostrarPacientesCumpleaños(int dia, String mes) {
        try {
            System.out.println("Pacientes del " + dia + " de " + mes + ":");
            for (Consulta c : consultas) {
                if (c.getDia() == dia && c.getMes().equalsIgnoreCase(mes)) {
                    System.out.println(c.getNombrePaciente() + " " + c.getApellidoPaciente());
                }
            }
        } catch (Exception e) {}
    }

    private void guardar() throws IOException {
        try (FileWriter f1 = new FileWriter("consultas.json");
             FileWriter f2 = new FileWriter("medicos.json")) {
            gson.toJson(consultas, f1);
            gson.toJson(medicos, f2);
        }
    }

    public void cargar() {
        try (FileReader r1 = new FileReader("consultas.json")) {
            Consulta[] c = gson.fromJson(r1, Consulta[].class);
            if (c != null) consultas = new ArrayList<>(Arrays.asList(c));
        } catch (Exception e) {}

        try (FileReader r2 = new FileReader("medicos.json")) {
            Medico[] m = gson.fromJson(r2, Medico[].class);
            if (m != null) medicos = new ArrayList<>(Arrays.asList(m));
        } catch (Exception e) {}
    }
}
