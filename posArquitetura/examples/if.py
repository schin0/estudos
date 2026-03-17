print('exemplos de if/else')

numero = float(input('Digite um número: '))

# if numero%2==0:
#   print('O número é par')
# else:
#   print('O número é ímpar')

x = int(input('Digite o primeiro número: '))
y = int(input('Digite o segundo número: '))

if (x > y):
  print('O primeiro número (%2d) é maior que o segundo número (%2d)' % (x, y))
else:
  print('O segundo número (%2d) é maior que o primeiro número (%2d)' % (y, x))

