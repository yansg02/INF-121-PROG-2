public class Main {
    public static void main(String[] args) {
        Consultorio c = new Consultorio();
        c.cargar();

        System.out.println("2a) Dar de alta 3 Médicos y 9 Consultas");
        c.altaMedico(new Medico(1, "Juan", "Perez", 10));
        c.altaMedico(new Medico(2, "Maria", "Gomez", 5));
        c.altaMedico(new Medico(3, "Carlos", "Lopez", 8));

        c.altaConsulta(new Consulta(101, "Ana", "Ruiz", 1, 25, "diciembre", 2024));
        c.altaConsulta(new Consulta(102, "Luis", "Mendez", 1, 10, "enero", 2024));
        c.altaConsulta(new Consulta(103, "Elena", "Castro", 1, 15, "febrero", 2024));
        c.altaConsulta(new Consulta(104, "Pedro", "Diaz", 2, 1, "enero", 2024));
        c.altaConsulta(new Consulta(105, "Sofia", "Rios", 2, 20, "marzo", 2024));
        c.altaConsulta(new Consulta(106, "Miguel", "Vega", 2, 25, "diciembre", 2024));
        c.altaConsulta(new Consulta(107, "Laura", "Paz", 3, 5, "abril", 2024));
        c.altaConsulta(new Consulta(108, "Jorge", "Sol", 3, 1, "enero", 2024));
        c.altaConsulta(new Consulta(109, "Carmen", "Luz", 3, 30, "mayo", 2024));

        System.out.println("\n2b) Dar de baja al Médico de nombreX y apellidoY; y sus consultas");
        c.bajaMedico("Maria", "Gomez");

        System.out.println("\n2c) Cambia el día de la consulta de los pacientes que agendaron en navidad o año nuevo");
        c.cambiarDiaNavidadAnioNuevo(10, "febrero");

        System.out.println("\n2d) Muestra a los pacientes atendidos en el día de tu cumpleaños");
        c.mostrarPacientesCumpleaños(15, "febrero");
    }
}
