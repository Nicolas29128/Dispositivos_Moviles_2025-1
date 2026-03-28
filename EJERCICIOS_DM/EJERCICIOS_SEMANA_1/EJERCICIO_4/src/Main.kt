import kotlin.random.Random
/*creamos la funcion "adivina" en este caso no tendra parametros, posteriormente creamos nuestra variable "num" que sera
 val ya que esta no cambiara (esta avariable puede tener numeros del 1 al 30), de ahi cremos otra variable "numrandom"
 esta obtendra un numero al azar dentro de los parametros de "num" (del 1 al 30); despues creamos un contador que nos
  ayudara a saber la cantidad de intentos que esta haciendo el usurio, esta se inicializa en 1 porque es el primer
  intento que hara el usuario. Luego hacemos un bucle que se repetira hata 5 ya que es los intentos que tiene el usuario;
  dentro del bucle diremos al usuario que ingrese un numero para que intente adivinar; despues creamos una variable
  "numusario" que sera quien guarde el numero del usuario que ingrese, y es val porque en cada iteracion del bucle
  cambiara segun lo que le diga despues; luego hacemos un if donde campararemos si es igual el numero del usuario con
  el numero que es al azar, si son saldra un mensaje que ha ganado (se usa break para romper y finzalizar. Despues se
  hace un else if en el caso que el numeor del usuario sea menor que el numero al azar, en el caso que sea asi, se le
  mandara un mensaje (pista) doende se le indicara que el numero a adivinar es mayor que el que coloco. Despues se hace
  otro else if en el caso que el numero del usuario sea mayor que el numero al azar, en el caso que sea asi, se le
  mandara un mensaje indicandole que el numero a adivinar es menor que el que coloco. Por ultimo el caso que el usuario
  no pueda adivinar en el quinto intento se le mostrata y se le dira que el numero que esocgio no es y era otro (el
  numero al azar)*/
fun adivina(){
    val num = 1 .. 30
    var numrandom = num.random()
    var contador = 1
    while (contador < 6){
        println("ingresa un numero: ")
        val numusuario = readln().toInt()
        if (numusuario == numrandom){
            println("has ganado")
            break
        }
        else if (numusuario < numrandom){
            println("el numero es mayor")
            contador++
        }
        else if (numusuario > numrandom){
            println("el numero es menor")
            contador++
        }
    }
    println ("el numero era: $numrandom")

}
/*en la funcion main solo se llamara a la funcion ("adivina")*/
fun main() {
    adivina()
}