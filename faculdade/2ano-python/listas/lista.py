lista_instrumentos = ["Violino", "Bateria", "Violão"]

#Inserção:
lista_instrumentos.append("Triângulo")
lista_instrumentos.append(input("Insira um instrumento:"))
lista_instrumentos.insert(0, "Viola")

#Remoção:
lista_instrumentos.pop(0)
lista_instrumentos.remove("Bateria")
lista_instrumentos.pop()

for instrumento in lista_instrumentos:
    print(instrumento)

# Testes:

# Tamanho lista:
print(f"A lista possui {len(lista_instrumentos)} itens.")

# Quantas vezes o elemento Violão apareceu?
quantidadeViolao = lista_instrumentos.count('Violão')
vezes = "vezes" if quantidadeViolao > 1 else "vez"

print(f"O elemento 'Violão' apareceu {quantidadeViolao} {vezes}'")

# Como alterar a ordem dos elementos da lista?
lista_instrumentos.reverse()
print(lista_instrumentos)

# Ordenar por ordem alfabética crescente
lista_instrumentos.sort()
print(lista_instrumentos)

# Ordenar por ordem alfabética decrescente
lista_instrumentos.sort(reverse=True)
print(lista_instrumentos)