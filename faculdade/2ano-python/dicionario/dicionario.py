# Dicionário vazio:
dicionario = {}

dicionario = {
    "Time": "Corinthians",
    "Idade": 53,
    "Celular": "A71"
}

# Valores:
for valor in dicionario.values():
    print(valor)

print("==========")

# Chaves:
for chave in dicionario.keys():
    print(chave)

# Acessando via tupla:
for chave, valor in dicionario.items():
    print(f"{chave}: {valor}")

# Adicionando valores:
dicionario["chave"] = "valor"

nome = input("Digite seu nome: ")
cargo = input("Digite seu cargo: ")

dicionario[nome] = cargo

# Removendo valores:

# Remover o último item:
dicionario.popitem()
# Remover um item específico:
dicionario.pop(nome)
# Remover todos os itens:
dicionario.clear()

# Exemplo:
contatos = {
    "Gabriel": {
        "Time": "Corinthians",
        "Idade": 53
    },
    "Maria": {
        "Time": "Barcelona",
        "Idade": 43
    }
}

for nome, informacoresPessoais in contatos.items():
    print(f"O contato {nome}")
    for chave, valor in informacoresPessoais.items():
        if (type(chave) == str and chave == "Time"):
            print(f"torce para o time {valor} e ")
        else:
            print(f"tem {valor} anos")

    print("\n")

