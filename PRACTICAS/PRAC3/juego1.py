import random

# Clase base
class Juego:
    def __init__(self, numeroDeVidas):
        self.numeroDeVidas = numeroDeVidas
        self.record = 0

    def reiniciaPartida(self):
        self.numeroDeVidas = 3  # se puede ajustar
        print("La partida se reinició, tienes", self.numeroDeVidas, "vidas.")

    def actualizaRecord(self):
        self.record += 1
        print("¡Nuevo record! Tu record actual es:", self.record)

    def quitaVida(self):
        self.numeroDeVidas -= 1
        if self.numeroDeVidas > 0:
            print("Te queda(n)", self.numeroDeVidas, "vida(s).")
            return True
        else:
            print("No te quedan vidas, perdiste.")
            return False


# Clase hija
class JuegoAdivinaNumero(Juego):
    def __init__(self, numeroDeVidas):
        super().__init__(numeroDeVidas)
        self.numeroAAdivinar = 0

    def juega(self):
        self.reiniciaPartida()
        self.numeroAAdivinar = random.randint(0, 10)
        print("Adivina un número entre 0 y 10.")

        while True:
            intento = int(input("Tu número: "))
            if intento == self.numeroAAdivinar:
                print("¡Acertaste!")
                self.actualizaRecord()
                break
            else:
                print("Fallaste.")
                if intento < self.numeroAAdivinar:
                    print("El número es mayor.")
                else:
                    print("El número es menor.")

                if not self.quitaVida():
                    break


# Clase aplicación
class Aplicacion:
    @staticmethod
    def main():
        juego = JuegoAdivinaNumero(3)
        juego.juega()


# Ejecutar aplicación
if __name__ == "__main__":
    Aplicacion.main()