from listaEncadeadaSimples import *

nodo = Nodo(1)

listaSimples = ListaEncadeadaSimples(nodo)
listaSimples.adicionarNodo(Nodo(2))
listaSimples.adicionarNodo(Nodo(3))
listaSimples.adicionarNodo(Nodo(4))

listaSimples.imprimirLista()

print("========")

listaSimples.excluirPorValor(4)

listaSimples.imprimirLista()

print("========")

print(listaSimples.existeValor(1))
print(listaSimples.existeValor(10))