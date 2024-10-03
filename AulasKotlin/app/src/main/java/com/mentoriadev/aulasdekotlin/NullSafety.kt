package com.mentoriadev.aulasdekotlin

class Carro {
    var cor = "Vermelho"

    fun acelerar() {
        println("Acelerando o carro")
    }
}

fun main() {
    val carro :Carro? = null
    println(carro?.cor)

}