# Abrir arquivo:
arquivo = open("c:\\oi.txt", encoding="UTF-8")

# Ler apenas uma linha por vez:
print(arquivo.readline())
# Ler várias linhas:
print(arquivo.readlines())

# Fechar:
arquivo.close()

conteudo = "teste do gabriel"

arquivo2 = open("C:\\Users\\gabriel.schincariol\\Downloads\\teste.txt", "w", encoding="UTF-8")

arquivo2.write(conteudo)

arquivo2.close()