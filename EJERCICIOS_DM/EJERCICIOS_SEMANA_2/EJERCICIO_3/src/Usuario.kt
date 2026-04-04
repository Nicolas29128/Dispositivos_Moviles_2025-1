/*en esta parte tenemos una dta class donde unicamente tendremos propiedades, en este caso de un usuario "nombre y
  apellido ambos de tipo String" "edad de tipo entero", esta data class se usara tanto en la interfaz y en el File para
  definir el tipo de propiedades que tiene "Usuario"*/
data class Usuario(
    var nombre: String,
    var apellido: String,
    var edad: Int
)
