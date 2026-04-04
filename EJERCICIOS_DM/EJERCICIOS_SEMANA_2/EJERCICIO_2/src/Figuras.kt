/*DESCRIPCION: el problema trata hacer un programa donde se pueda calcular el area y el perimetro de un cuadrado, un
 circulo y de un rectangulo; estas figuras son subclases, y la clase padre es una clase abtractacta "Shape" que es la
 unica que tendra las funciones para que despues las clases hijas puedan sobrescribir sus funciones como lo el del area,
 perimetro y resultado
 AUTOR: Franco Nicolás Rojas Castro
 FECHA: 02/04/2026
 ULTIMA MODIFICACION: 02/04/2026*/

/*primero cramos una clase abstracta "Shape" esta tiene sus propiedad de "area y perimetro" ambas doouble y var, porque
 pueden que tengan decimales y var que por mi logica por el hecho que despues se puden modificar y no son estables.
 Adicionar que esta clase abstracta tiene funciones abstractas "calcular area, calcular perimetro y resultados" (esta
 en ingles porque le di tap a la sugerencia)*/
abstract class Shape (var area: Double, var perimetro: Double) {
    abstract fun calculateArea(): Double
    abstract fun calculatePerimetro(): Double
    abstract fun resultado()

}
/*creamos primero la clase "Cuadro" que  tiene como atributo "lado" que es lo que tiene un cudrado, decimos que esa
  clase va a heredar de la clase abstracta "Shape", y le dcimos que se inicializa en 0.0 para evitar errores. Despues
  sobre escribimos las funciones que heredamos y las implementamos, en el caso del area es lado x lado; en el caso del
  perimetro es 4 veces el lado; y finalmente  en resultado colocamos los resultados que se obtendra*/
class Cuadrado (lado: Double) : Shape(0.0, 0.0) {
    var lado : Double = lado

    override fun calculateArea(): Double {
        area = lado * lado
        return area
    }

    override fun calculatePerimetro(): Double {
        perimetro = 4 * lado
        return perimetro
    }

    override fun resultado() {
        println("el area del cudrado es: ${calculateArea()}")
        println("el perimetro del cudrado es: ${calculatePerimetro()}")
    }

}

/*creamos primero la clase "Circulo" que  tiene como atributo "radio" que es lo que se tiene un circulo y es necesario
  para hallar el area y el perimetro, despues esta clase hereda de la clase abstracta "Shape", y le decimos que se
  inicializa en 0.0 para evitar errores. Despues sobre escribimos las funciones que heredamos y las implementamos, en
  el caso del area es pi x radio al cuadrado; en el caso del perimetro es 2 x pi x radio ; y finalmente  en resultado
  colocamos los resultados que se obtendra*/
class Circulo (radio: Double) : Shape(0.0, 0.0) {
    var radio : Double = radio
    val pi = 3.1415926535

    override fun calculateArea(): Double {
        area = pi * radio * radio
        return area
    }

    override fun calculatePerimetro(): Double {
        perimetro = 2 * pi * radio
        return perimetro
    }

    override fun resultado() {
        println("el area del circulo es: ${calculateArea()}")
        println("el perimetro del circulo es: ${calculatePerimetro()}")
    }

}

/*creamos primero la clase "Rectangulo" que tiene como atributo "largo y ancho" que seran utiles para calcular su area y
  perimetro, decimos que esa clase va a heredar de la clase abstracta "Shape", y le dcimos que se inicializa en 0.0 para
  evitar errores. Despues sobre escribimos las funciones que heredamos y las implementamos, en el caso del area es
  largo x ancho; en el caso del perimetro es largo + ancho, tdo esto x 2; y finalmente  en resultado colocamos los
  resultados que se obtendra*/
class Rectangulo (largo: Double, ancho: Double) : Shape(0.0, 0.0) {
    var largo : Double = largo
    var ancho : Double = ancho

    override fun calculateArea(): Double {
        area = largo * ancho
        return area
    }

    override fun calculatePerimetro(): Double {
        perimetro = (largo + ancho) * 2
        return perimetro
    }

    override fun resultado() {
        println("el area del rectangulo es: ${calculateArea()}")
        println("el perimetro del rectangulo es: ${calculatePerimetro()}")
    }

}
/*en la funcion main veremos donde se le dira al usuario que coloque el lado del cuadrado, posteriormente se hace un
  llamado a cuadrado que este ya tendra tdo de la funcion "Cuadrado" y el .resultado para que nos los muestre el
  resultado. De igual froma se hara con el circulo, se le pedira al usuario que ingrese el radio para despues mostrar
  los resultados que se hizo en Circulo. En el caso de rectangulo cambia un poco solo en el heccho que se le pedira dos
  cosas al usuario (largo y ancho), despues esto rectangulo tendra tdo lode Rectangulo y se mostarar despues llamando a
  resultado mostrando el resultado del area y perimetro*/
fun main () {
    println("ponga el tamaño del lado del cuadrado: ")
    val cuadrado = Cuadrado(readln().toDouble())
    cuadrado.resultado()

    println("ponga el tamaño del radio del circulo: ")
    val circulo = Circulo(readln().toDouble())
    circulo.resultado()

    println("ponga el tamaño del largo del rectangulo: ")
    val largo = readln().toDouble()
    println("ponga el tamaño del ancho del rectangulo: ")
    val ancho = readln().toDouble()
    val rectangulo = Rectangulo (largo, ancho)
    rectangulo.resultado()
}