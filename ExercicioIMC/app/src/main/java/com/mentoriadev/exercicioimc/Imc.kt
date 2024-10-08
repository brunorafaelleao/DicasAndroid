package com.mentoriadev.exercicioimc

data class Imc(
    var peso: Double,
    var altura: Double,
    var imc: Double = peso / (altura * altura)
)

object DataManager {
    var imc: Imc? = null
}