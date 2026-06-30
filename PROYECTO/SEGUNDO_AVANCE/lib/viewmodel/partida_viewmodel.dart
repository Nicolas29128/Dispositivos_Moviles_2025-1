/* para controlar el historial de partidas, se puede agregar,
   consultar, editar y eliminar partidas, y de calcular estadísticas generales
*/

import '../model/partida.dart';

class PartidaViewModel {

  //  donde se almacenan todas las partidas
  final List<Partida> _partidas = [];

  // regresa el historial sin permitir modificaciones
  List<Partida> get partidas =>
      List.unmodifiable(_partidas);

  int get totalPartidas => _partidas.length;
  //revisa las partidas y obtiene los puntajes de ahi encuentra el mayor
  int get mejorPuntaje {
    if (_partidas.isEmpty) {
      return 0;
    }
    return _partidas
        .map((partida) => partida.puntaje)
        .reduce((a, b) => a > b ? a : b);
  }

  // ver todas las partidas, se suma los puntajes y hace un promedio
  double get promedioPuntaje {
    if (_partidas.isEmpty) {
      return 0;
    }
    int suma = 0;
    for (Partida partida in _partidas) {
      suma += partida.puntaje;
    }
    return suma / _partidas.length;
  }

  // ve todas las partidas y toma el ma alto
  int get nivelMaximo {
    if (_partidas.isEmpty) {
      return 0;
    }
    return _partidas
        .map((partida) => partida.nivel)
        .reduce((a, b) => a > b ? a : b);
  }

  // para saber el total de monedas ganadas
  int get totalMonedas {
    int total = 0;
    for (Partida partida in _partidas) {
      total += partida.monedasGanadas;
    }
    return total;
  }

  // para guaradar las partidas
  void agregarPartida(Partida partida) {
    _partidas.add(partida);
  }

  // para guardar lo que seria esa partida, es com un seguir jugando
  void editarPartida(int index, Partida partida) {
    if (index >= 0 &&
        index < _partidas.length) {
      _partidas[index] = partida;

    }

  }

  // elimnar una partida
  void eliminarPartida(int index) {
    if (index >= 0 &&
        index < _partidas.length) {
      _partidas.removeAt(index);
    }
  }

  // para obtener la mejor partida en caso de no haya no hya, y la primera es la mejor
  Partida? obtenerMejorPartida() {
    if (_partidas.isEmpty) {
      return null;
    }
    Partida mejor = _partidas.first;
    for (Partida partida in _partidas) {
      if (partida.puntaje >
          mejor.puntaje) {
        mejor = partida;
      }
    }
    return mejor;
  }

  // para buscar un aprtida
  Partida? buscarPorId(String id) {
    try {
      return _partidas.firstWhere(
            (partida) => partida.id == id,
      );
    } catch (e) {
      return null;
    }
  }

  // elimina todas las partidas
  void limpiarHistorial() {
    _partidas.clear();
  }
}