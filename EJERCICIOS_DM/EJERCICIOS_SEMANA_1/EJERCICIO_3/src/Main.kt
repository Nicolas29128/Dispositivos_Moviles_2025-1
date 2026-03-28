import kotlin.system.exitProcess
/*primero creamos la funcion "calculadora" con los parametros "num1, num2 estasdos de tipo entero y "accion que sera
 Char porque solo tiene un carcater; y se usa any porque decimos que devolvera cualquier tipo de dato. Retornaremos
 siempre  y cunado "accion" sea 1 o 2 o 3 o 4 sino saldra oppcion incorrecta; recalcar que cada una de las acciones
 devolvera ya sea la suma, resta , multipliacion o divison segun lo que se haya seleccionado. Agregar que se le aumento
 como una comprovacion en el caso de la division cunado el segundo numnero sea 0 ya que no se pude*/
fun calculadora (num1: Int, num2: Int, accion: Char): Any {
    return when (accion) {
        '1' -> return num1 + num2
        '2' -> return num1 - num2
        '3' -> return num1 * num2
        '4' -> {
            if (num2 == 0)  return "no es valido dividir entre 0 "
            else num1 / num2
        }
        else -> return "opcion incorrecta"
    }
}
/*implementamos la funsion main, que tendra un buble que dice que se cumple siempre y cunado lo que este adentro se
 se cumpla, es decir que el caso  que pongan 5 se termina ese bucle y se acaba el programa.
 Primero hemos impreso el menu que nos dice el problema con sus opciones, y tambien para que escoja el usurio la opcion,
 usando y creando "accion" y se pone "[0]" para que obtener el primer caracter, en el caso de no ponerlo se sale error,
 ya que lo tomaria como String. */
fun main() {
    while (true){
        println("=====MENU=====")
        println("1 -> suma")
        println("2 -> resta")
        println("3 -> multiplicacion")
        println("4 -> division")
        println("5 -> salir")
        println(" ")
        println("elige una opccion: ")
        val accion:Char = readln()[0]
        /* hacemos un if en el caso que le usuario ponga otra opcion que no este en el menu este le diga de que es una opcion
         invalida y ponga una que este en el menu */
        if (accion != '5' && accion != '4' && accion != '3' && accion != '2' && accion != '1') {
            println("ponga una opccion valida: ")
            return
        }
        /*hacemos este if en el caso que el usuario ponga 5 la calculadora termine y diga accion terminada*/
        if (accion == '5') {
            println("accion terminada")
            return
        }
        /*imprimimos para decirle al usuario que ingrese los datos como el primeor numero, el segundo numeor; se le pone .toint
        * para que abjo cunado se llame a la funcion este sepa que tipo de dato es, en el caso que no se ponga sale un error*/
        print("ponga el primer numero: ")
        val num1 = readln().toInt()

        print("ponga el segundo número: ")
        val num2 = readln().toInt()
        /*cremoa la varible result, se llama a la variable y esta variable "result es la que ahora tendra los datos; finalmente
         se impreme el resultado "*/
        val result = calculadora(num1, num2, accion)
        println("resultado: $result")
    }

}