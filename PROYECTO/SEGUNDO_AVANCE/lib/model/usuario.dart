//
class Usuario {

  final String id;
  String nombre;
  String correo;
  String contrasena;
  int mejorPuntaje;
  int monedas;
  int nivelAlcanzado;

  Usuario({
    required this.id,
    required this.nombre,
    required this.correo,
    required this.contrasena,
    this.mejorPuntaje = 0,
    this.monedas = 0,
    this.nivelAlcanzado = 1,
  });

  factory Usuario.fromMap(Map<String, dynamic> map) {

    return Usuario(
      id: map["id"] ?? "",
      nombre: map["nombre"] ?? "",
      correo: map["correo"] ?? "",
      contrasena: map["contrasena"] ?? "",
      mejorPuntaje: map["mejorPuntaje"] ?? 0,
      monedas: map["monedas"] ?? 0,
      nivelAlcanzado: map["nivelAlcanzado"] ?? 1,
    );
  }

  Map<String, dynamic> toMap() {

    return {
      "id": id,
      "nombre": nombre,
      "correo": correo,
      "contrasena": contrasena,
      "mejorPuntaje": mejorPuntaje,
      "monedas": monedas,
      "nivelAlcanzado": nivelAlcanzado,
    };
  }
}