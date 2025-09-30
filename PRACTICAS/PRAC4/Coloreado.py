from abc import ABC, abstractmethod
import math
import random

# a) Interfaz Coloreado
class Coloreado:
    def como_colorear(self):
        pass

# b) Clase abstracta Figura
class Figura(ABC):
    def __init__(self, color="negro"):
        self.color = color
    
    def set_color(self, color):
        self.color = color
    
    def get_color(self):
        return self.color
    
    def __str__(self):
        return f"Figura color: {self.color}"
    
    @abstractmethod
    def area(self):
        pass
    
    @abstractmethod
    def perimetro(self):
        pass

# c) Clase Cuadrado que extiende Figura e implementa Coloreado
class Cuadrado(Figura, Coloreado):
    def __init__(self, lado, color="negro"):
        super().__init__(color)
        self.lado = lado
    
    def area(self):
        return self.lado * self.lado
    
    def perimetro(self):
        return 4 * self.lado
    
    def como_colorear(self):
        return "Colorear los cuatro lados"
    
    def __str__(self):
        return f"Cuadrado - Lado: {self.lado}, {super().__str__()}"

# d) Clase Circulo que extiende Figura
class Circulo(Figura):
    def __init__(self, radio, color="negro"):
        super().__init__(color)
        self.radio = radio
    
    def area(self):
        return math.pi * self.radio * self.radio
    
    def perimetro(self):
        return 2 * math.pi * self.radio
    
    def __str__(self):
        return f"Círculo - Radio: {self.radio:.2f}, {super().__str__()}"

# Programa de prueba
def main():
    print("=== SISTEMA DE FIGURAS GEOMÉTRICAS ===")
    print("Generando 5 figuras aleatorias...\n")
    
    figuras = []
    
    # f) Crear arreglo de 5 figuras aleatorias
    for i in range(5):
        tipo_figura = random.randint(1, 2)  # 1 = Cuadrado, 2 = Círculo
        
        if tipo_figura == 1:
            # Crear cuadrado con lado aleatorio entre 1 y 10
            lado = random.uniform(1, 10)
            cuadrado = Cuadrado(lado)
            figuras.append(cuadrado)
            print(f"Figura {i+1}: Cuadrado creado - Lado: {lado:.2f}")
        else:
            # Crear círculo con radio aleatorio entre 1 y 10
            radio = random.uniform(1, 10)
            circulo = Circulo(radio)
            figuras.append(circulo)
            print(f"Figura {i+1}: Círculo creado - Radio: {radio:.2f}")
    
    print("\n" + "="*60)
    print("RESULTADOS:")
    print("="*60)
    
    # g) Mostrar información de cada figura
    for i, figura in enumerate(figuras, 1):
        print(f"\n--- Figura {i} ---")
        print(figura)
        print(f"Área: {figura.area():.2f}")
        print(f"Perímetro: {figura.perimetro():.2f}")
        
        # Verificar si la figura implementa Coloreado
        if isinstance(figura, Coloreado):
            print(f"Método colorear: {figura.como_colorear()}")
        else:
            print("Método colorear: No implementado")

# Ejecutar el programa
if __name__ == "__main__":
    main()