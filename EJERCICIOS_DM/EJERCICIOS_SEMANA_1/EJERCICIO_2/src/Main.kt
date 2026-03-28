import kotlin.random.Random
/*primero creamos la funcion "juego", y tenemos el parametro "usuario" que es la que usaremos para que el
 usuario ponga mediante consola su eleccion (piedra, papel o tijera); y se pone :String porque es el tipo de dato que
 se va retornar. Despues creamos la variable "elecompu" que sera loq ue escoja la computadora al azar, tambien esta
 varible sera quien contenga la lista (piedra, papel o tijera); despues se crea la variable "compu" que obtendra la
 palbra aleatoria que esta genera el "elecompu.random()"*/
fun juego (usuario:String):String {
    val elecompu = listOf("piedra", "papel", "tijera")
    val compu = elecompu.random()
    /*en esta parte se retornara si gano o perdio el usuario, y eso pasara porque con el when compararemos cada caso que
     pude pasar y segun sea el caso saldra si gano o perdio o fue empate*/
    return when{
        usuario == compu -> "empate :|"
        usuario == "piedra" && compu == "tijera" ->"ganaste :) "
        usuario == "papel" && compu == "piedra" ->"ganaste :) "
        usuario == "tijera" && compu == "papel" ->"ganaste :) "
        else -> "perdiste :("

    }

}
/* en la funcion main primero pasara que le diremos al usuario que escoja una opcion (piedra, papel o tijera),
 posteriomente le diremos que ingrese mediantes consola su opcion; si esta es distinta a piedra, papel o tijera, se
 le dira que ingrese otra, por ello es el uso del if. finalmente tenemos la variable result, se llama a lña funcion y
 esta nueva varible es quien obtendra los datos. Y al final se imprime el resultado si gano o perdio o fue un empate*/
fun main() {
    println("escoga uno: ")
    println("piedra")
    println("papel")
    println("tijera")
    val usuarios = readln()
    if (usuarios != "papel" && usuarios != "piedra" && usuarios != "tijera") {
        println("escoge otro")
        return
    }
    val result = juego(usuarios)
    println(result)
}