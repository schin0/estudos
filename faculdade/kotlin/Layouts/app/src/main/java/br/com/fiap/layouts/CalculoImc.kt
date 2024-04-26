package br.com.fiap.layouts

import kotlin.math.pow

fun calcularImc(peso: Double, altura: Double): Double {
    return peso / (altura / 100).pow(2);
}

fun obterStatusImc(imc: Double): String {
    return if (imc < 18.5) {
        "Abaixo do peso"
    } else if (imc >= 18.5 && imc < 25.0) {
        "Peso ideal"
    } else if (imc >= 25 && imc < 30.0) {
        "Levemente acima do peso"
    } else if (imc >= 30.0 && imc < 35.0) {
        "Obsesidade Grau I"
    } else if (imc >= 35 && imc < 40.0) {
        "Obsesidade Grau II"
    } else {
        "Obesidade Grau III"
    }
}