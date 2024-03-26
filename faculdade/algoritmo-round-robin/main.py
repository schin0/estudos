def contas():
    global pessoas
    for i in range(0, NumEscolhidoPessoas):
        print("Digite o número de contas a pagar da pessoa", i + 1)
        numero = int(input())
        pessoas.append(numero)

def fila():
    global pessoas
    contadorFila = NumEscolhidoPessoas
    frenteFila = 0
    while contadorFila != 0:
        if pessoas[frenteFila] > 0:
            print("A pessoa", frenteFila + 1)
            print("vai para o caixa com %d contas" % pessoas[frenteFila])
            if pessoas[frenteFila] <= quantum:
                print("Paga %d contas" % pessoas[frenteFila])
                pessoas[frenteFila] = 0
                contadorFila -= 1
                print("E sai da fila.")
            else:
                print("Paga até %d contas" % quantum)
                pessoas[frenteFila] -= quantum
                print("E vai para o final da fila com %d contas restantes." % pessoas[frenteFila])
        frenteFila = (frenteFila + 1) % NumEscolhidoPessoas

print(":::::Programa exemplo sobre Round-Robin:::::")
print("Digite o número máximo de contas a pagar no caixa (quantum): ")
quantum = int(input())
print("Digite o número de pessoas na fila: ")
NumEscolhidoPessoas = int(input())
pessoas = []
contas()
fila()
print("::::::::FIM:::::::::")