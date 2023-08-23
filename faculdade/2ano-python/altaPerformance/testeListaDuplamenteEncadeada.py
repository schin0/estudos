from listaDuplamenteEncadeada import *

listaDupla = ListaDuplamenteEncadeada()

listaDupla.adicionarNodo(Nodo(10))
listaDupla.adicionarNodo(Nodo(11))
listaDupla.adicionarNodo(Nodo(12))
listaDupla.adicionarNodo(Nodo(13))
listaDupla.adicionarNodo(Nodo(14))

listaDupla.imprimirPelaCabeca()

print("====")

listaDupla.imprimirPelaCauda()

print("====")

print(listaDupla.existeValor(2))
print(listaDupla.existeValor(12))

listaDupla.remover(10)

print("====")

listaDupla.imprimirPelaCabeca()
