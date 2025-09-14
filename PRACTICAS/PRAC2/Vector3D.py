import math
class Vector3D:
    def __init__(self, x, y, z=0):
        self.x = x
        self.y = y
        self.z = z
    def __str__(self):
        return "(" + str(self.x) + ", " + str(self.y) + ", " + str(self.z) + ")"
    # a) Suma de vectores
    def __add__(self, other):
        return Vector3D(self.x + other.x, self.y + other.y, self.z + other.z)
    # b) Multiplicación por escalar
    def __mul__(self, escalar):
        return Vector3D(self.x * escalar, self.y * escalar, self.z * escalar)
    # c) Magnitud
    def magnitud(self):
        return math.sqrt(self.x**2 + self.y**2 + self.z**2)
    # d) Normalización
    def normalizado(self):
        mag = self.magnitud()
        if mag == 0:
            return Vector3D(0,0,0)
        return Vector3D(self.x/mag, self.y/mag, self.z/mag)
    
    # e) Producto punto
    def dot(self, other):
        return self.x*other.x + self.y*other.y + self.z*other.z
    # f) Producto cruz
    def cross(self, other):
        return Vector3D(
            self.y*other.z - self.z*other.y,
            self.z*other.x - self.x*other.z,
            self.x*other.y - self.y*other.x
        )

a = Vector3D(2, 3, 4)
b = Vector3D(1, -2, 3)
r = 3
print("Vector a:", a)
print("Vector b:", b)
print("Suma a + b:", a + b)
print("Multiplicación r * a:", a * r)
print("Longitud de a:", a.magnitud())
print("Normal de a:", a.normalizado())
print("Producto punto a·b:", a.dot(b))
print("Producto cruz a x b:", a.cross(b))