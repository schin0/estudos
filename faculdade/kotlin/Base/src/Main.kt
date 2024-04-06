// Comentários são assim

enum class TipoCalculo {
    Adicao,
    Subtracao,
    Multiplicacao,
    Divisao
}

fun main() {
    exemplificar();
    processarVariaveisEConstantes();

    processarColecoes();

    processarIfs();

    processarValoresNulos();

    // Closed Range
    processarIntervaloFechado();
    // Half Closed Range
    processarIntervaloMeioFechado();

    // processarWhen(); //Switch

    processarWhiles();

    processarFor();

    processarEnum();
}

fun processarVariaveisEConstantes() {
    var variavel = "variavel";
    var variavelTipada: String = "variavel tipada";
    val constante = "constante";
    val exemploChar = 'G';
    val concatenacao = "O seu nome começa com a letra $exemploChar";

    // /t gera um tab no texto

    // Exemplo Pair:
    var (codigo, produto) = Pair(123, "notebook");
    // Ou
    var produto2: Pair<Byte, String> = Pair(111, "celular");

}

fun processarColecoes() {
    processarArrays();

    processarHashSets();

    processarMapFilterReduceLista();
    processarMapFilterArray();
    processarReduceArray();
}

private fun processarArrays() {
    val times = arrayOf("Corinthians", "Champirra FC");

    // length
    val tamanhoArray = times.size;
    val arrayVazio = times.isEmpty();

    var frutas = ArrayList<String>();
    frutas.add("Melancia");
    frutas.add("Laranja");
    frutas.remove("Melancia");
}

private fun processarHashSets() {
    // Nessa lista não é possível repetir itens
    var filmes = HashSet<String>();

    filmes.add("Homem Aranha");
    filmes.add("A Fuga das Galinhas");

    filmes.add("Homem Aranha"); // Não irá adicionar como terceiro item

    // Maneira mais curta
    var carros = setOf("Civic", "Celta", "Corsa");

    // Lista com Pair
    var produtos = HashMap<String, Double>();
    produtos.put("Caneta", 2.00);
    produtos.put("Copo", 5.50);

    produtos.remove("Caneta") // Remove todas Canetas
    produtos.remove("Caneta", 2.00) // Remove só Caneta com 2.00

    val valor = produtos.get("Copo")
}

private fun processarMapFilterReduceLista() {
    val numeros = listOf(1,2,3,4,5,6,7,8,9,10)

    // it é uma variável sem tipo (any)
    val numerosPares = numeros.filter { it % 2 == 0 }
    var numerosImpares = numeros.filter { it % 2 != 0 }
    val numerosMultiplicados = numeros.map { it * it }
    val somaDosNumeros = numeros.reduce {
        //Captura o valor anterior ou atual (acc) e o valor atual(it)
        acc, it ->
            acc + it
    }
}

private fun processarMapFilterArray() {
    val nomes = arrayOf("João", "Paulo", "Henrique", "Ana", "Beatriz", "Carla", "Caroline")

    val nomesEmMaiusculo = nomes.map({it.toUpperCase()})

    val nomesComMenosDeSeisCaracteres = nomes.filter({it.length < 6})
    println(nomesComMenosDeSeisCaracteres)
}

private fun processarReduceArray() {
    var transacoes = arrayOf<Double>(500.0, -45.0, -70.0, -25.80, -321.72, 190.0, -35.15, -100.0);

    var carteira = transacoes.reduce {
            atual, proximo -> println("Saldo: ${String.format("%.2f", atual)} => Próximo Lançamento: ${String.format("%.2f", proximo)}")

        (atual + proximo)
    };

    // println("Seu saldo é R$ ${String.format("%.2f", carteira)}");
    // Seu saldo é R$ 92,33
}

private fun processarIfs() {
    var notaMinima = 7.5
    var situacao1: String?;

    if (notaMinima > 7.0) {
        situacao1 = "aprovado";
    } else {
        situacao1 = "reprovado";
    }

    var ifTernario = if (notaMinima > 7.0) "aprovado" else "reprovado"
}

private fun processarValoresNulos() {
    var idade: Int? = null
    var minhaIdade = idade ?: 0 // 0
    idade = 57
    var idadeFinal = idade ?: 0 // 57
}

private fun processarIntervaloFechado() {
    val numeros = 1..5
    for (numero in numeros) {
        // println(numero) //Imprime de 1 a 5
    }
}

private fun processarIntervaloMeioFechado() {
    val numeros = (1 until 5)
    for (numero in numeros) {
        // println(numero) // Imprime de 1 a 4
    }
}

private fun processarWhen() {
    val numero = 7
    when (numero % 2) {
        0 ->
            println("$numero é par")
        else ->
            println("$numero é ímpar")
    }

    //Exemplo com vários cenários no mesmo case
    val letra = "z"
    when (letra) {
        "a", "e", "i", "o", "u" ->
            println("vogal")
        else ->
            println("consoante")
    }
}

private fun processarWhiles() {
    var tentativas = 10
    while (tentativas > 0) {
        tentativas = tentativas - 1
        // println("Você tem mais $tentativas tentativas")
    }

    //Usando: do while
    var tentativas2 = 0
    var numeroSorteado = 0
    do {
        tentativas2 += 1

        numeroSorteado = ((Math.random() * 6) + 1).toInt()

        //println("Tentativa:$tentativas2 <-> Número Randomizado: $numeroSorteado")
    } while (numeroSorteado != 6)

    //println("\nVocê tirou 6 após $tentativas2 tentativas")
}

private fun processarFor() {
    // Como percorrer uma sequência (range)
    for (dia in 1..30) {
        // println("Estou no dia $dia")
    }

    //Como percorrer uma coleção, imprimindo sua chave e valor.
    val pessoas = mapOf(
        (25 to "Paulo"),
        (18 to "Renata"),
        (33 to "Kleber"),
        (51 to "Roberto"),
        (36 to "Carol")
    )
    for (pessoa in pessoas) {
        //println(" ${pessoa.key} => ${pessoa.value}")
    }
}

private fun processarEnum() {
    val operacaoEscolhida = TipoCalculo.Adicao;
    val numero1 = 10;
    val numero2 = 3;
    var resultado: Int?;


    when (operacaoEscolhida) {
        TipoCalculo.Adicao ->
            resultado = numero1 + numero2;
        else ->
            resultado = 0;
    }

    // println(resultado);
}







// Funções:


// Maneira reduzida:
fun escreverOla() = println("Ola");

// Funcao com parametro e retorno tipado:
fun adicionar(numero1: Float, numero2: Float): Float {
    return numero1 + numero2;
}


// Simple-expressions:
fun exemplificar() {
    fun duplicar(x: Int): Int = x * 2;
    //println(double(8));
    fun triplicar(x: Int) = x * 3;
    //println(triple(10));
}
