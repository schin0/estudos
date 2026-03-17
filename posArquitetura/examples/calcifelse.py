x = float(input('Digite o primeiro número: '))
y = float(input('Digite o segundo número: '))

print('(1) = Soma')
print('(2) = Subtração')
print('(3) = Multiplicação')
print('(4) = Divisão')

option = int(input('Digite a opção desejada: '))

if option == 1:
  print('A soma dos números é: %2.2f' % (x+y))
elif option == 2:
  print('A subtração dos números é: %2.2f' % (x-y))
elif option == 3:
  print('A multiplicação dos números é: %2.2f' % (x*y))
elif option == 4:
  if y != 0:
    print('A divisão dos números é: %2.2f' % (x/y))
  else:
    print('Não é possível dividir por zero')
else:
  print('Opção inválida')
