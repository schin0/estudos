x = float(input('Digite o primeiro número: '))
y = float(input('Digite o segundo número: '))
z = float(input('Digite o terceiro número: '))

if (x > y) and (x > z):
  print('O maior número é: ', x)
elif (y > x) and (y > z):
  print('O maior número é: ', y)
else:
  print('O maior número é: ', z)

# or

a = float(input('Digite o primeiro número: '))
b = float(input('Digite o segundo número: '))
c = float(input('Digite o terceiro número: '))

largest = a

if (b > largest):
  largest = b
if (c > largest):
  largest = c

print('O maior número é: ', largest)
