/*cremos un interfas "IBiblioteca" para definir que funciones tendra la clase "Biblioteca", ademas se le pone parametros
  para que se sepa que es lo que tiene que recibir o con que es lo que va tomar en este caso puede ser usuario o
   material o ambos*/
interface IBiblioteca {
    fun registrarMaterial (material : Material)
    fun registrarUsuario (usuario : Usuario)
    fun prestamo (usuario : Usuario, material: Material)
    fun devolucion (usuario: Usuario, material: Material)
    fun mostrarMaterialesDisponibles ()
    fun mostraraMaterialesReservadosUsuario (usuario: Usuario)
}