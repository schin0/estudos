try: 
  numerador = int(input("Digite o numerador: "))
except ValueError:
  print("Valor inválido para o numerador. Por favor, digite um número inteiro.")
  exit(0)

try:
  denominador = int(input("Digite o denominador: "))
except ValueError:
  print("Valor inválido para o denominador. Por favor, digite um número inteiro.")
  exit(0)

try:
  if numerador % denominador == 0:
    print(f"{numerador} é divisível por {denominador}.")
  else:
    print("A divisão não é exata.")
except ZeroDivisionError:
  print("Erro: Divisão por zero não é permitida. O denominador deve ser diferente de zero.")

# or

people = {'Tulio': 30, 'Maria': 25, 'João': 40}
person = input("Digite o nome da pessoa: ")

try:
  print(f"{person} tem {people[person]} anos.") 
except KeyError:
  print("Pessoa não encontrada.")
