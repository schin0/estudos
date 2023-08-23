class Nodo:
    def __init__(self, valor, proximo=None, anterior=None):
        self.valor = valor
        self.proximo = proximo
        self.anterior = anterior

    def __str__(self):
        return str(self.valor)

class ListaDuplamenteEncadeada:
    def __init__(self):
        self.cabeca = None
        self.cauda = None

    def adicionarNodo(self, nodo):
        if self.cabeca is None and self.cauda is None:
            self.cabeca = nodo
            self.cauda = nodo
        elif self.cabeca.proximo is None:
            nodo.anterior = self.cabeca
            self.cabeca.proximo = nodo
            self.cauda = nodo
        else:
            self.cauda.proximo = nodo
            nodo.anterior = self.cauda
            self.cauda = nodo

    def imprimirPelaCabeca(self):
        nodo = self.cabeca
        while nodo is not None:
            print(nodo, end=' ')
            nodo = nodo.proximo

    def imprimirPelaCauda(self):
        nodo = self.cauda
        while nodo is not None:
            print(nodo, end=' ')
            nodo = nodo.anterior

    # Exercícios:
    # 1: Construa um método para verificar se existe um valor na lista encadeada.
    def existeValor(self, valor):
        nodo = self.buscar(valor)

        return nodo is not None

    def buscar(self, valor):
        nodo = self.cabeca

        while nodo is not None:
            if nodo.valor == valor:
                return nodo

            nodo = nodo.proximo

        return None

    # 2: Faça o método de remover um elemento da lista.
    def remover(self, valor):
        if self.existeValor(valor):
            nodo = self.buscar(valor)

            if (nodo.anterior is not None):
                nodo.anterior.proximo = nodo.proximo
            else:
                self.cabeca = nodo.proximo

            if nodo.proximo is not None:
                nodo.proximo.anterior = nodo.anterior
            else:
                self.cauda = nodo.anterior

            nodo = None
        else:
            print("Valor não existente!")