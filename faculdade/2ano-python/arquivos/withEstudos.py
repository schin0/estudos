# Com o with, podemos garantir que a função close será chamada automaticamente

with open("C:\\Users\\gabriel.schincariol\\Downloads\\teste.txt", encoding="UTF-8") as arquivo:
    print(arquivo.read())