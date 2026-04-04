/* DESCRIPCION: en el siguiente jercico nos pide que hagamos como una calculadora basica para saber el precio final
 de un producto, dicho precio es ingresado por el usuario y de igual forma el descuento; ademas se debe implementar
 los set y get para cada uno y debe tener un pequeña validacion
 AUTOR: Franco Nicolás Rojas Castro
 FECHA: 2/04/2026
 ULTIMA MODIFICACION: 02/04/2026
 */
/* creamos una clase "Producto" esta clase tendra las variables "precio y descuento" ambas var, porque seria lo mas
 adecuado a mi parecer, porque talves en otro caso se pude modificar, y estas dos varibles son double, porque el precio
 puede tener centavos, y eldescuento puede ser con decimales en algunos casos que son muy raros pero existententes. Por
 cada variable se creo su set y get, y en la parte del set del "precio" se hizo una validacion que sirve para el caso
 que el usuario ingrese un valor negativo este le diga que no se acepta; de igual forma en el caso de "descuento se hizo
 una validacion para el caso que solo sea hasta 100 porque no hay mas descuento que el 100%.
 Despues creamos la funcion "precio final" dicha funcion es double porque nos dara el calculo final del precio con su
 descuento respectivo.
 */
class Producto (){
    var precio: Double = 0.0
        get() {return field}
        set(value) {
            require(value >= 0) {"no puede ser negativo"}
            field = value}

    var descuento: Double = 0.0
        get() {return field}
        set(value) {
            require(value in 0.0 .. 100.0) {"el desceunto puede ser hasta el 100%"}
            field = value}

    fun preciofinal (): Double {
        return precio - (precio * descuento / 100)
    }
}

/* en la funcion main es donde crearemos un prooducto, ademas es donde se le pedira al usuario que ingrese el valor de
 "precio y descuento "; al final se le dara el precio final (se pone el preoducto en este caso, pero podria a ver mas
 de uno y ahi si se especificaria seguido de la funcion en ambos casos es seguido de la funcion)*/
fun main () {
    val producto = Producto()
    println("ingrese el precio del prodcuto: ")
    producto.precio = readln().toDouble()
    println("ingrese el descuento del produto: ")
    producto.descuento = readln().toDouble()
    println("el precio final del producto es: ${producto.preciofinal()} ")
}