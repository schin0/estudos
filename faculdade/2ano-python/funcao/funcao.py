# Calcular velocidade média:

def calc(a, b):
    return a ** b

print(calc(10, 2))

def calcularVelocidadeMedia():
    distancia = float(input("Digite a distância percorrida (km): "))
    tempo = float(input(f"Digite o tempo gasto para percorrer {distancia} km: "))

    velocidadeMedia = distancia / tempo

    print("A velocidade média é {} km/h".format(velocidadeMedia))

# calcularVelocidadeMedia()

def somar(valor1, valor2):
    return valor1 + valor2

valor1Informado = float(input("Digite o primeiro valor: "))
valor2Informado = float(input("Digite o segundo valor: "))

soma = somar(valor1Informado, valor2Informado)
media = soma / 2
print(media)
