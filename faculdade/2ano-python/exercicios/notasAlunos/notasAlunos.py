notas = []
opcao = -1

while opcao != 4:
    print("1 - Cadastrar nota")
    print("2 - Exibir notas por aluno")
    print("3 - Calcular média da sala")
    print("4 - Sair")
    opcao = int(input("Informe a opção desejada: "))

    if opcao == 1:
        notas.append(float(input("Insira a nota do aluno: ")))
    elif opcao == 2:
        for nota in notas:
            print(f"A nota do aluno {notas.index(nota) + 1} é igual a: {nota}")
    elif opcao == 3:
        soma = 0

        for nota in notas:
            soma += nota

        media = soma / len(notas)

        print(f"A média da sala foi igual a: {media}")
    elif opcao == 4:
        print("Saindo.")
    else:
        print("Opção inválida!")
