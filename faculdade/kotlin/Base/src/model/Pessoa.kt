package model

class Pessoa constructor(nome: String, idade: Int, peso: Double, altura: Double) {
    var nome: String = nome;
    var idade: Int = idade;
    var peso: Double = peso;
    var altura: Double = altura;

    // Apenas um exemplo de function no get:
    val idadeFinal: Int
        get() {
            return idade - 3;
        }

    fun exibirDados() {
        println("Nome: $nome");
        println("Idade: $idade");
        println("Peso: $peso");
        println("Altura: $altura");
        println("Idade Final: $idadeFinal");
        println("================");
    }
}