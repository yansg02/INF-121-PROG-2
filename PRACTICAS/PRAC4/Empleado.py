from abc import ABC, abstractmethod
class Empleado(ABC):
    def __init__(self, nombre):
        self.nombre = nombre
    @abstractmethod
    def calcular_salario_mensual(self):
        pass
    def __str__(self):
        return f"Nombre: {self.nombre}"
class EmpleadoTiempoCompleto(Empleado):
    def __init__(self, nombre, salario_anual):
        super().__init__(nombre)
        self.salario_anual = salario_anual
    def calcular_salario_mensual(self):
        return self.salario_anual / 12
    
    def __str__(self):
        return f"{super().__str__()}, Salario Anual: ${self.salario_anual:,.2f}, Salario Mensual: ${self.calcular_salario_mensual():,.2f}"
class EmpleadoTiempoHorario(Empleado):
    def __init__(self, nombre, horas_trabajadas, tarifa_por_hora):
        super().__init__(nombre)
        self.horas_trabajadas = horas_trabajadas
        self.tarifa_por_hora = tarifa_por_hora
    def calcular_salario_mensual(self):
        return self.horas_trabajadas * self.tarifa_por_hora
    def __str__(self):
        return f"{super().__str__()}, Horas Trabajadas: {self.horas_trabajadas}, Tarifa por Hora: ${self.tarifa_por_hora:,.2f}, Salario Mensual: ${self.calcular_salario_mensual():,.2f}"
def main():
    empleados = []
    print("=== SISTEMA DE REGISTRO DE EMPLEADOS ===")
    print("\n--- Ingresar 3 empleados de tiempo completo ---")
    for i in range(3):
        print(f"\nEmpleado de tiempo completo #{i + 1}:")
        nombre = input("Nombre: ")
        salario_anual = float(input("Salario anual: $"))
        empleado = EmpleadoTiempoCompleto(nombre, salario_anual)
        empleados.append(empleado)
    
    print("\n--- Ingresar 2 empleados de tiempo horario ---")
    
    for i in range(2):
        print(f"\nEmpleado de tiempo horario #{i + 1}:")
        nombre = input("Nombre: ")
        horas_trabajadas = float(input("Horas trabajadas: "))
        tarifa_por_hora = float(input("Tarifa por hora: $"))
        empleado = EmpleadoTiempoHorario(nombre, horas_trabajadas, tarifa_por_hora)
        empleados.append(empleado)
    # Mostrar resultados
    print("\n" + "="*50)
    print("RESUMEN DE EMPLEADOS Y SALARIOS")
    print("="*50)
    for i, empleado in enumerate(empleados, 1):
        print(f"\nEmpleado #{i}:")
        print(f"Nombre: {empleado.nombre}")
        print(f"Salario mensual: ${empleado.calcular_salario_mensual():,.2f}")
    print("\n" + "="*50)
    print("INFORMACIÓN COMPLETA DE EMPLEADOS")
    print("="*50)
    for i, empleado in enumerate(empleados, 1):
        print(f"\nEmpleado #{i}: {empleado}")
# Ejecutar el programa
if __name__ == "__main__":
    main()