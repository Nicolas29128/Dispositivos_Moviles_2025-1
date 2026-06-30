//ordenar la info de la partida
class Partida {

  // aaqui se ven los atributos que son importante en la partida
  final String id;
  int puntaje;
  int nivel;
  int monedasGanadas;
  DateTime fecha;

  //aca decimos que creamos partidas de forma controlada
  Partida({
    required this.id,
    required this.puntaje,
    required this.nivel,
    required this.monedasGanadas,
    required this.fecha,
  });

  // se convierte un map en un objeto
  factory Partida.fromMap(Map<String, dynamic> map) {
    //en caso que no exista bota valores por defecto
    return Partida(
      id: map["id"] ?? "",
      puntaje: map["puntaje"] ?? 0,
      nivel: map["nivel"] ?? 1,
      monedasGanadas: map["monedasGanadas"] ?? 0,
      fecha: DateTime.parse(
        map["fecha"] ?? DateTime.now().toIso8601String(),
      ),
    );

  }

  // se convierte un objeto en un Map
  Map<String, dynamic> toMap() {

    return {
      "id": id,
      "puntaje": puntaje,
      "nivel": nivel,
      "monedasGanadas": monedasGanadas,
      "fecha": fecha.toIso8601String(),
    };

  }

}