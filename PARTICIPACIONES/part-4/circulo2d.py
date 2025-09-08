import math

class Circulo2D:
    
    def __init__(self, x=0, y=0, radio=1):
        self.__x = x
        self.__y = y
        self.__radio = radio
    
    
    def get_x(self):
        return self.__x
    
    def get_y(self):
        return self.__y
    
    def get_radio(self):
        return self.__radio
    
    
    def get_area(self):
        return math.pi * self.__radio * self.__radio
    
    
    def get_perimetro(self):
        return 2 * math.pi * self.__radio
    
    
    def contiene(self, x, y):
        distancia = math.sqrt((x - self.__x) ** 2 + (y - self.__y) ** 2)
        return distancia <= self.__radio
    
    
    def contiene_circulo(self, circulo):
        distancia_centros = math.sqrt((circulo.get_x() - self.__x) ** 2 + 
                                     (circulo.get_y() - self.__y) ** 2)
        return distancia_centros + circulo.get_radio() <= self.__radio
    
    
    def sobrepone(self, circulo):
        distancia_centros = math.sqrt((circulo.get_x() - self.__x) ** 2 + 
                                     (circulo.get_y() - self.__y) ** 2)
        return (distancia_centros < (self.__radio + circulo.get_radio()) and 
                not self.contiene_circulo(circulo) and 
                not circulo.contiene_circulo(self))


if __name__ == "__main__":
    c1 = Circulo2D(2, 0, 1)
    
    print("Área de c1: " + str(round(c1.get_area(), 2)))
    print("Perímetro de c1: " + str(round(c1.get_perimetro(), 2)))
    print()
    
    print("c1.contiene(2.5, 0): " + str(c1.contiene(2.5, 0)))
    
    circulo_pequeño = Circulo2D(2, 0, 0.5)
    print("c1.contiene(Circulo2D(2, 0, 0.5)): " + str(c1.contiene_circulo(circulo_pequeño)))
    
    circulo_grande = Circulo2D(0, 0, 2)
    print("c1.sobrepone(Circulo2D(0, 0, 2)): " + str(c1.sobrepone(circulo_grande)))