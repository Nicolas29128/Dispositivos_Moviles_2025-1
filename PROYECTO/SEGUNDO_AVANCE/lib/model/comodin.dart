
class Comodin {

  // aqui ponemos la infromacionde los comodines tipo "perdonar una"
  String nombre;
  int costo;
  String descripcion;
  int cantidad;

  // aqui creamos los objetos de comodin
  Comodin({
    required this.nombre,
    required this.costo,
    required this.descripcion,
    this.cantidad = 0,

  });

  // aqui convertimos el map en un objeto, para asi cargar los datos.
  factory Comodin.fromMap(Map<String, dynamic> map){

    return Comodin(
      nombre: map["nombre"] ?? "",
      costo: map["costo"] ?? 0,
      descripcion: map["descripcion"] ?? "",
      cantidad: map["cantidad"] ?? 0,
    );

  }

  // aqui pasa lo contrario de arriba pas de un objeto a map para guardar los datos
  Map<String, dynamic> toMap(){

    return{
      "nombre": nombre,
      "costo": costo,
      "descripcion": descripcion,
      "cantidad": cantidad,

    };
  }
}