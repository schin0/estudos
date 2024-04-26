package br.com.fiap.layouts

import kotlin.math.pow

fun calcularImc(peso: Double, altura: Double): Double {
    return peso / (altura / 100).pow(2);
}