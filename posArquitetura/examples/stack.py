def inverte_string(s):
  resultado = " "
  for c in s:
    resultado = c + resultado

  return resultado

string = input("Digite uma string para inverter: ")
string_invertida = inverte_string(string)
print(f"A string invertida é: {string_invertida}")