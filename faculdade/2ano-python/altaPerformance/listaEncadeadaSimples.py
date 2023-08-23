class Nodo:
    # Construtor:
    def __init__(self, valor, proximo=None):
        self.valor = valor
        self.proximo = proximo

    def __str__(self):
        return str(self.valor)


class ListaEncadeadaSimples:
    def __init__(self, cabeca=None):
        self.cabeca = cabeca

    def adicionarNodo(self, nodo):
        if self.cabeca is None:
            self.cabeca = nodo
        else:
            cauda = self.procurarCauda(self.cabeca)
            cauda.proximo = nodo

    def procurarCauda(self, nodo):
        if nodo.proximo is None:
            return nodo

        return self.procurarCauda(nodo.proximo)

    def imprimirLista(self):
        nodo = self.cabeca
        while nodo is not None:
            print(nodo, end=' ')
            nodo = nodo.proximo

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

    # 2:  Faça o método de remover um elemento da lista.
    def excluirPorValor(self, valor):
        if self.cabeca is None:
            return

        if self.cabeca.valor == valor:
            self.cabeca = self.cabeca.proximo
            return

        nodoAnterior = self.encontrarNodoAnterior(valor)
        if nodoAnterior is not None:
            nodoAnterior.proximo = nodoAnterior.proximo.proximo

    def encontrarNodoAnterior(self, valor):
        nodo = self.cabeca

        while nodo.proximo is not None:
            if nodo.proximo.valor == valor:
                return nodo

            nodo = nodo.proximo

        return None
