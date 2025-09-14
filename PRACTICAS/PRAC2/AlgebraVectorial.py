import math
class AlgebraVectorial:
    def __init__(self, x, y, z=0):
        self.x = x
        self.y = y
        self.z = z
    def __str__(self):
        return "(" + str(self.x) + ", " + str(self.y) + ", " + str(self.z) + ")"
    def magnitud(self):
        return math.sqrt(self.x**2 + self.y**2 + self.z**2)
    def __add__(self, other):
        return AlgebraVectorial(self.x + other.x, self.y + other.y, self.z + other.z)
    def __sub__(self, other):
        return AlgebraVectorial(self.x - other.x, self.y - other.y, self.z - other.z)
    def dot(self, other):
        return self.x*other.x + self.y*other.y + self.z*other.z
    def cross(self, other):
        return AlgebraVectorial(
            self.y*other.z - self.z*other.y,
            self.z*other.x - self.x*other.z,
            self.x*other.y - self.y*other.x
        )
    def __mul__(self, escalar):
        return AlgebraVectorial(self.x*escalar, self.y*escalar, self.z*escalar)
    # a) Perpendicular: |a+b| = |a-b|
    def perpendiculares_a(self, other):
        return math.isclose((self+other).magnitud(), (self-other).magnitud())
    # b) Perpendicular: |a-b| = |b-a|
    def perpendiculares_b(self, other):
        return math.isclose((self-other).magnitud(), (other-self).magnitud())
    # c) Perpendicular: a·b = 0
    def perpendiculares_c(self, other):
        return math.isclose(self.dot(other), 0)
    # d) Perpendicular: |a+b|^2 = |a|^2 + |b|^2
    def perpendiculares_d(self, other):
        return math.isclose((self+other).magnitud()**2, self.magnitud()**2 + other.magnitud()**2)
    # e) Paralelo: a = r*b
    def paralelos_e(self, other):
        try:
            r1 = self.x / other.x if other.x != 0 else None
            r2 = self.y / other.y if other.y != 0 else None
            r3 = self.z / other.z if other.z != 0 else None
            ratios = [r for r in (r1, r2, r3) if r is not None]
            return all(math.isclose(r, ratios[0]) for r in ratios)
        except ZeroDivisionError:
            return False
    # f) Paralelo: a x b = 0
    def paralelos_f(self, other):
        return self.cross(other).magnitud() == 0
    # g) Proyección de a sobre b
    def proyeccion_sobre(self, other):
        escalar = self.dot(other) / (other.magnitud()**2)
        return other * escalar
    # h) Componente de a en b
    def componente_en(self, other):
        return self.dot(other) / other.magnitud()

a = AlgebraVectorial(3, 4, 0)
b = AlgebraVectorial(4, -3, 0)
print("Vector a:", a)
print("Vector b:", b)
print("¿a ⟂ b (método c)?", a.perpendiculares_c(b))
print("¿a ∥ b (método f)?", a.paralelos_f(b))
print("Proyección de a sobre b:", a.proyeccion_sobre(b))
print("Componente de a en b:", a.componente_en(b))