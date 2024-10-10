package com.barral.firstApp

fun main(){
    //declarando las variables
    val nombre = "Branko"
    val edad = 15
    val antecedentes = false
    val chileno = true
    val estaVivo = true

    // llamando a la funcion
    puedeVotar(nombre, edad, antecedentes, chileno, estaVivo)

}

//funcion para verificar si puede votar
fun puedeVotar(nombre: String, edad: Int, antecendentes: Boolean, chileno: Boolean, estaVivo: Boolean){
      when {
        !estaVivo -> println("Esta persona ya no se encuentra con nosotros.")
        edad < 18 -> println("Hola, $nombre,Usted no tiene  la edad sufiente.")
        antecendentes -> println("Hola, $nombre,Usted no  puede votar porque posee antecedentes criminales.")
        !chileno -> println("Hola, $nombre,Usted no es Chileno para votar.")
        else -> println("Hola, $nombre, Usted cumple con todos los requisitos para sufragar.")
    }
}







