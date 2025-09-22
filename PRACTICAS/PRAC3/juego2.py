import random

class Juego:
    def __init__(self, numeroDeVidas):
        self.numeroDeVidas = numeroDeVidas
        self.record = 0

    def reiniciaPartida(self):
        self.numeroDeVidas = 3  # fijo en este juego2
        print("\nLa partida se reinició, tienes", self.numeroDeVidas, "vidas.")

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

    def validaNumero(self, num):
        return 0 <= num <= 10

    def juega(self):
        self.reiniciaPartida()
        self.numeroAAdivinar = random.randint(0, 10)
        print("Adivina un número entre 0 y 10.")

        while True:
            intento = int(input("Tu número: "))
            if not self.validaNumero(intento):
                print("Número inválido, ingresa entre 0 y 10.")
                continue

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


# Clase para adivinar los pares
class JuegoAdivinaPar(JuegoAdivinaNumero):
    def validaNumero(self, num):
        if 0 <= num <= 10 and num % 2 == 0:
            return True
        else:
            print("Número inválido: debe ser PAR entre 0 y 10.")
            return False


# Class para los impares
class JuegoAdivinaImpar(JuegoAdivinaNumero):
    def validaNumero(self, num):
        if 0 <= num <= 10 and num % 2 != 0:
            return True
        else:
            print("Número inválido: debe ser IMPAR entre 0 y 10.")
            return False


# Clase de aplicación
class Aplicacion:
    @staticmethod
    def main():
        juegos = [
            JuegoAdivinaNumero(3),
            JuegoAdivinaPar(3),
            JuegoAdivinaImpar(3)
        ]

        for juego in juegos:
            juego.juega()


# Ejecutacion de app
if __name__ == "__main__":
    Aplicacion.main()