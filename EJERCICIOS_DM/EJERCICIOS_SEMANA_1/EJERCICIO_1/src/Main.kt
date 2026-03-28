/*primero vamos a crear una funcion "empleados" donde se inicializa los parametros salario y puntuacion
que es lo que nos pide para ingresar los datos de los mismos; decirle profe que tuve que usar pair para guardar los
valores y despues retornarlos, sin eso me salia error :(, ademas que al final necesitamos poner el primer valor y el
segundo. Despues creamos la variable "nivel" (que sera la que nos diga uno de los tres tipos que hay), esta varibale
se compara con "puntuacion", y comzara el switch case*/
fun emplpeados (salario: Double, puntuacion: Int): Pair <String, Double> {
    val nivel = when (puntuacion) {
        in 0 .. 3 -> "inaceptable"
        in 4..6 -> "aceptable"
        in 7..10 -> "meritorio"
        else -> "error"
    }
    /*se crea una varibale "total" que es donde se guardara la cantidad de dinero del usurio en cada nivel (en si se
    aplica la formula que nos dio); despues retorno lo "nivel y total" y el Pair es para que nos retorne los dos valores,
     porque sino solo retornaria uno y el otro saldria como error */
    val total: Double = salario * (puntuacion/10.0)
    return Pair (nivel, total);

}
/*creamos la funcion main donde primero le diremos al usuario que ponga  sus salario y su puntuacion, despues leemos
esos datos usando "readln" acompañado del tipo de dato que vamos a leer o que el usurio va a ingresar.
 despues se crea una variable "result" se llama a la funcion y esta nueva variable tendra los datos de "salario y
 puntuacion"*/
fun main() {
    print("ponga el salario: ")
    val salario = readln().toDouble()
    print("ponga su puntuacion: ")
    val puntuacion = readln().toInt()
    val result = emplpeados(salario, puntuacion)

    /*usamos el println para mostar los resultados de nivel de rendimiento y de cantidad de dinero; se usa ${} porque
    llamaremos a nuestra varaible donde esta los datos "salario y puntuacion", recalcar que se usar .first y .second para
    indicar que queremo el primer valor "salrio", y de la misma forma con second para indicar que queremos el segundo valor*/

    println("nivel de rendimiento: ${result.first}")
    println("cantidad de dinero recibido: ${result.second}")

}