import json

contatos = {
    "Clark Kent":
        {"Celular":"123456",
         "Email":"super@krypton.com"},
    "Bruce Wayne":
        {"Celular":"654321",
         "Email":"bat@caverna.com.br"}
}

# Convertendo o dicionário para uma string o formato json
final = json.dumps(contatos, indent=4)

arquivo = open("C:\\Users\\gabriel.schincariol\\Downloads\\teste.txt", "w", encoding="UTF-8")

arquivo.write(final)

arquivo.close()

print(final)


conteudo = "Estou testando criar um arquivo de texto. Então, estou... textando?"

arquivo2 = open("C:\\Users\\gabriel.schincariol\\Downloads\\teste.txt")

conteudo_do_arquivo = arquivo2.read()

arquivo2.close()

# Converter uma string no formato json em um dicionário
agenda = json.loads(conteudo_do_arquivo)

print(agenda)

# Comprovando que o objeto agenda é do tipo dicionário
print("O tipo do objeto agenda é {}".format(type(agenda)))