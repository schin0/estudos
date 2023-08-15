# from modularizacao.operacoesMatematicas import somar -> Import somente da função
# from modularizacao.operacoesMatematicas import * -> Import de todas as funções
# import modularizacao -> import do módulo, para usar: modularizacao.funcaoDesejada()
from modularizacao.operacoesMatematicas import *

def calcular():
    op = -1

    while op != 5:
        print("1 - Somar")
        print("2 - Subtrair")
        print("3 - Dividir")
        print("4 - Multiplicar")
        print("5 - Sair")
        op = int(input("Digite sua opção: "))

        if op == 1:
            print(somar(float(input("Digite o primeiro valor: ")), float(input("Digite o segundo valor: "))))
        elif op == 2:
            print(subtrair(float(input("Digite o primeiro valor: ")), float(input("Digite o segundo valor: "))))
        elif op == 3:
            print(dividir(float(input("Digite o primeiro valor: ")), float(input("Digite o segundo valor: "))))
        elif op == 4:
            print(multiplicar(float(input("Digite o primeiro valor: ")), float(input("Digite o segundo valor: "))))
        else:
            print("Opção inválida!")

calcular()
