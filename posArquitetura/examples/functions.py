def equacaoReta(x):
  return 2*x + 1

x = float(input("Digite um valor para x: "))
resultado = equacaoReta(x)
print(f"O resultado da equação da reta para x = {x} é: {resultado}")

lista_x = [1,2,3,4,5,10,88,123]

lista_y = []
for valor in lista_x:
  lista_y.append(equacaoReta(valor))

for valor_x, valor_y in zip(lista_x, lista_y):
  print(f"Para x = {valor_x}, y = {valor_y}")

