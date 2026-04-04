/* DESCRIPCION: en el siguiente ejercico nos pide realizar el codigo para la gestion de una biblioteca, la cual se
 necesitra clases abstractas, clases normales, una data class, y una interfaz. La clase abstracta "Material" sera la
 clase padre por asi decirlo, ya que las demas clases "Libro y Revista" seran quienes hereden, ademas estan tendran otras
 propiedades, Despues tendremos una data class "Usuario" que tiene las propiedades comunes de un usuario, luego tenemos
 una interfaz "IBiblioteca" que unicamente esta puede y tiene las funciones que despues sobre escribiremos en "Biblioteca",
 despues tenemos la clase "Biblioteca" dende se implemntara las funciones ya dadas por la intefaz, leego ahi mimso nos
 pide que tenr una lista de los materiales que se tiene y un map de los usruarios que posteriormenyye nos ayudara a lo
 son la operaciones de prestamos y devoluciones; por ultimo se instancia las subclases y se ejecuta las operaciones.
 AUTOR: Franco Nicolás Rojas Castro
 FECHA: 02/04/2026
 ULTIMA MODIFICACION: 03/04/2026
 */

/*creamos una clase abstrata "Materiales" que tendra como atributos "tutlo, autor" estos dos de tipo String y val porque
  no se puede cambiar en la vida real, ademas del atributo año de publicacion de tipo entero. Por ultimo se tiene una
  funcion abstracta se mostarara como un resumen de tdo lo que se tiene */
abstract  class Material (
    val titulo: String,
    val autor: String,
    val yearpeublicacion: Int) {
    abstract fun mostrarDetalles()
}

/*creamos una clase "Libro" que tiene atributos "genero (String) y numero de paginas (entero)", ademas contiene los
  atributos de la clase abstracta, ya que esta los hereda (titulo, autor y año de publicacion) y tambien herda la funcion
  que ahora si la sobre escribiremos a lo que nos pide el ejercicio, en este caso mostraremos todas la variables dichas
  anteriormente. Recalcar que para heredar se pone los ":" segudi de la clase con sus atributos*/
class Libro (
    titulo: String,
    autor: String,
    yearpeublicacion: Int,
    val genero: String,
    val numeroPaginas: Int
) : Material(titulo, autor, yearpeublicacion) {
    override fun mostrarDetalles() {
        println("el liibro es: $titulo")
        println("el autor es: $autor")
        println("el año de publicacion es: $yearpeublicacion")
        println("el genero es: $genero")
        println("el numeroPaginas es: $numeroPaginas")
    }

}
/*creamos una clase "Revista" que es similar a la del libro porque tiene atributos nuevos "issn (String), volumen (int),
  numero (entero) y  editorial(String)", ademas tambien contiene los atributos de la clase abstracta (titulo, autor y
  año de publicacion) y tambien herda la funcion que tambien sobre escribiremos a lo que nos pide el ejercicio, en este
  caso mostraremos todas la variables dichas anteriormente. Y nuevamente recordar que para heredar se pone los ":"
  segudo de la clase con sus atributos*/
class Revista (
    titulo: String,
    autor: String,
    yearpeublicacion: Int,
    val issn: String,
    val volume: Int,
    val numero: Int,
    val editorial: String
): Material(titulo, autor, yearpeublicacion) {
    override fun mostrarDetalles() {
        println("la revista es: $titulo")
        println("el autor es: $autor")
        println("el año de publicacion es: $yearpeublicacion")
        println("el issm es: $issn")
        println("el volumen es: $volume")
        println("el numero es: $numero")
        println("la editorial es: $editorial")
    }

}

/*creamos la clase "Biblioteca" que va a heredar las funciones de "IBiblioteca", a esta clase se le agragara dos atributos
  "materiales disponiebles y map de usuario" estas dos son mutables una que es una lista mutable, donde se almacena los
  materiales y la otra de ambas en el sentido que sencesita del usuario para despues saber la lista de materiales cuando
  este en prestamo*/
class Biblioteca : IBiblioteca {
    val materialesDisponibles: MutableList<Material> = mutableListOf()
    val mapUsuario: MutableMap<Usuario, MutableList<Material>> = mutableMapOf()
/*sobre escribimos la funcion "registrarMateriales" la cual decimos que el objeto material es de tipo Material, despues
  agregamos a la lista materiales disponibles con .add y mostramos el material que se agrego */
    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
        println("se registro: ${material.titulo}")
    }

/*sobre escribimos la funcion "registrarUsuario" la cual decimos que el objeto usuario es de tipo Usuario, despues
  agregamos al usuario dentro del map, dicha lista esta vacia porque se le asigna los materiales cuando este se preste,
  y finalmente se imprime el nombre del usuario agregado */
    override fun registrarUsuario(usuario: Usuario) {
        mapUsuario[usuario] = mutableListOf()
        println("se registro el usuario: ${usuario.nombre}")
    }
/*sobre escribimos la funcion "pretamo " la cual recibe un usuario y un material; despues verificamos que el material
  este en la biblioteca, en el caso que este se elimina de la de lista de materiales disponibles, despues se crea un
  atributo lista que tendra toda la lista que tiene ese usuario, y despues se compruba si son iguales o no, en el caso
  sean difrentes este se agregara a la lista porque se supone que no lo tiene ese usuario. Despues se imprime el usuario
  y el material que tiene, en el caso que no sea asi se le dice que es null y es ahi donde se le dice que no existe . */
    override fun prestamo(usuario: Usuario, material: Material) {
        if (material in materialesDisponibles) {
            materialesDisponibles.remove(material)
            val lista = mapUsuario[usuario]
            if (lista != null) {
                lista.add(material)
                println("el usuario: ${usuario.nombre} tiene: ${material.titulo}")
            } else {
                println("no existe el usuario")
            }

        } else {
            println("no esta disponible")
        }
    }

/*sobre escribimos la funcion "devolucion" la cual recibe un usuario y un material, lo primero  buscamos si el usuario
  existe en la lista, si existe buscamos el material en la lista, y si esta se elimina ese materia de la lista del
  usuario, y se se agrega en la lista de materiales disponibles, y se imprime el usuario y el material que devolvio*/
    override fun devolucion(usuario: Usuario, material: Material) {
        val lista = mapUsuario[usuario]
        if (lista != null) {
            if (material in lista) {
                lista.remove(material)
                materialesDisponibles.add(material)
                println("el usuario: ${usuario.nombre} devolvio: ${material.titulo}")
            } else {
                println("el usuario no lo tiene")
            }
        } else {
            println("no existe el usuario")
        }
    }
/*sobre escribimos la funcion "mostrar materiales disponibles" la cual recorreremos toda esta lista y mostraremos lo que
* hay dentro de ella*/
    override fun mostrarMaterialesDisponibles() {
        println("los materiales disponibles son:")
        for (material in materialesDisponibles) {
            println("${material.titulo}")
        }
    }
/*sobre escribimos la funcion "mostrar materiales reservado del usuario" que recive un usario, y se crea una variable
* lista donde esta tdo lo de map usuario permitiendonos comparar despues si esta el usuario nos mostrara el usaurio y
* todos los materiales que este tiene usando el for.  */
    override fun mostraraMaterialesReservadosUsuario(usuario: Usuario) {
        val lista = mapUsuario[usuario]
        if (lista != null) {
            println("el material lo tiene: ${usuario.nombre}")
            for (material in lista) {
                println("el material prestado es: ${material.titulo}")
            }
        } else {
            println("no existe el usuario")
        }
    }

}

/*en la funcion main instanciaremos un usuario, un libro, y una revista y llenaremos sus respectivos atributos que tenga,
  recordar que cremao una variable biblioteca que tendra tdo lo de Biblioteca como es lo de registro de usuarios,
   materiales, los prestamos y las devoluciones. Por ellos despues hacemos uso de esta avriable llamando a su respectiva
    funcion y danle el parametro de solicita o requiere. Por ultimo se imprimira al inicio los materiales que hay,
    despues el libro prestado y el usuario, seguido de otra ves los materiales que hay pra comprobar que esta bien,
    luego los materiales que tiene el usuario, y despues el material devuelto por el usuario, y por ultimo se imprime
    todos los amteriales disponibles*/
fun main() {
    val biblioteca = Biblioteca()
    val usuario1 = Usuario(
        "Juan",
        "Martinez",
        20
    )
    val libro1 = Libro(
        "El principito",
        "Antoine de Saint-Exupéry",
        1943,
        "Ficcion",
        104
    )
    val revista1 = Revista(
        "Mecanica popular",
        "Henry H. Windsor",
        1902,
        "0032-4558",
        40,
        1,
        "Hearst Communications"
    )

    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(revista1)

    println("=====================================================")
    println("materiales disponibles: ")
    biblioteca.mostrarMaterialesDisponibles()
    println("=====================================================")
    println("libro en prestamo a: ")
    biblioteca.prestamo(usuario1, libro1)
    println("=====================================================")
    println("materiales disponibles: ")
    biblioteca.mostrarMaterialesDisponibles()
    println("=====================================================")
    println("el usuario tiene... ")
    biblioteca.mostraraMaterialesReservadosUsuario(usuario1)
    println("=====================================================")
    println("devolvio: ")
    biblioteca.devolucion(usuario1, libro1)
    println("=====================================================")
    println("materiales disponibles: ")
    biblioteca.mostrarMaterialesDisponibles()
}