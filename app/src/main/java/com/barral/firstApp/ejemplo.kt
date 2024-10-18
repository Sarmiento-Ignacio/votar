package com.barral.firstApp

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException


fun main(){
    //Solicitando nombre de votatante
    val nombre = solicitarNombre()

    //Solicita la fecha de nacimiento del usuario
    val fechaNacimiento = solicitarFechaNacimiento()

    //Calculando la edad usando la fecha de nacimiento
    val edad = calcularEdad(fechaNacimiento)

    //Comprueba que la edad es suficiente para votar para continuar con la siguiente pregunta
    if (edad < 18) {
        println("Hola, $nombre, Usted no tiene la edad suficiente para votar.")
        return // Finaliza el programa si no es mayor de edad
    }

    // Solicitando si tiene antecedentes (sí/no)
    val antecedentes = solicitarSiNo("¿Tiene antecedentes? (sí/no): ")

    // Solicitando si es chileno (sí/no)
    val chileno = solicitarSiNo("¿Es Chileno? (sí/no): ")



    // llamando a la funcion para votar
    puedeVotar(nombre, edad, antecedentes, chileno)

}
//Funcion para comprobar que el formato del nombre este bien ingresado
fun solicitarNombre(): String {
    while (true) {
        print("Ingrese su nombre: ")
        val nombre = readLine() ?: ""

        // Verificar que el nombre no esté vacío y que contenga solo letras
        if (nombre.isNotBlank() && nombre.all { it.isLetter() }) {
            return nombre
        } else {
            println("Por favor, ingrese un nombre válido (solo letras y no vacío).")
        }
    }
}

// Función para solicitar una fecha de nacimiento válida
fun solicitarFechaNacimiento(): LocalDate {
    while (true) {
        print("Ingrese su fecha de nacimiento (dd/MM/yyyy): ")
        val fechaNacimientoStr = readLine() ?: ""

        try {
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            return LocalDate.parse(fechaNacimientoStr, formatter)
        } catch (e: DateTimeParseException) {
            println("Fecha inválida, por favor ingrese una fecha válida en el formato dd/MM/yyyy.")
        }
    }
}

// Función para calcular la edad basada en la fecha de nacimiento
fun calcularEdad(fechaNacimiento: LocalDate): Int {
    val fechaActual = LocalDate.now()
    return Period.between(fechaNacimiento, fechaActual).years
}

// Función para solicitar respuestas de si/no
fun solicitarSiNo(pregunta: String): Boolean {
    while (true) {
        print(pregunta)
        val respuesta = readLine()?.lowercase() ?: ""
        if (respuesta == "si") return true
        if (respuesta == "no") return false
        println("Por favor, responda con 'si' o 'no'.")
    }
}
//funcion para verificar si puede votar
fun puedeVotar(nombre: String, edad: Int, antecendentes: Boolean, chileno: Boolean){
      when {
        antecendentes -> println("Hola, $nombre,Usted no  puede votar porque posee antecedentes criminales.")
        chileno -> println("Hola, $nombre,Usted no es Chileno para votar.")
        else -> println("Hola, $nombre, Usted cumple con todos los requisitos para sufragar.")
    }
}







