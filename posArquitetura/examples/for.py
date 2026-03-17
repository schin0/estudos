string = input("Digite uma string: ")
for char in string:
  print(char)

numbers = [1, 2, 3, 4, 5]
for num in numbers:
  print(num)

# Imprime os números de 0 a 4
for i in range(5):
  print(i)

# Imprime os números de 1 a 9, pulando de 2 em 2
for j in range(1, 10, 2):
  print(j)

# Imprime os números de 10 a 1, em ordem decrescente
for k in range(10, 0, -1):
  print(k)

# Imprime os números de 1 a 5
for l in range(1, 6):
  print(l)

# Imprime os caracteres de uma string usando o índice
string = input("Digite uma string: ")
for caracter in range(len(string)):
  print(string[caracter])

string = input("Digite uma string: ")
for palavra in string.split():
  print(palavra)

string_numbers = input("Digite uma sequência de números separados por espaço: ")
list_numbers = string_numbers.split()
count = 0

for num in list_numbers:
  print(num)
  count += 1

print(f"Total de números: {count}")
