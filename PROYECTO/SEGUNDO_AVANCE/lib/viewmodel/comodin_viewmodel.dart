/* aca se peude ver la logica de lo que seria los comodines disponibles, y este
   permite agregar, comprar, utilizar y eliminar comodines
*/

import '../model/comodin.dart';

class ComodinViewModel {

  // cxa se almacena los comodines disponibles
  final List<Comodin> _comodines = [];

  // para acceder a la lista de comodines
  List<Comodin> get comodines => List.unmodifiable(_comodines);
  //en caso de comprar los comodines
  int _monedasDisponibles = 0;
  int get monedasDisponibles => _monedasDisponibles;

    // para desbloquear un nuevo comodin
  void agregarComodin(Comodin comodin) {
    _comodines.add(comodin);
  }

  // para actualizar los datos del comodin
  void editarComodin(int index, Comodin comodin) {

    if (index >= 0 && index < _comodines.length) {
      _comodines[index] = comodin;
    }
  }

  // para elminar un  comodin
  void eliminarComodin(int index) {

    if (index >= 0 && index < _comodines.length) {
      _comodines.removeAt(index);
    }
  }

  // para encontara el comodin

  Comodin? buscarComodin(String nombre) {

    for (Comodin comodin in _comodines) {
      if (comodin.nombre == nombre) {
        return comodin;
      }
    }
    return null;
  }

  // seria tipo tienda del juego de comodines
  bool comprarComodin(Comodin comodin) {
    if (_monedasDisponibles >= comodin.costo) {
      comodin.cantidad++;
      _monedasDisponibles -= comodin.costo;
      return true;
    }
    return false;
  }

  // para al momento de dar uso a un comodin
  bool usarComodin(String nombre) {
    Comodin? comodin = buscarComodin(nombre);
    if (comodin == null) {
      return false;
    }

    if (comodin.cantidad > 0) {
      comodin.cantidad--;
      return true;
    }
    return false;
  }

  // borrar tod los comodines
  void limpiarComodines() {
    _comodines.clear();
  }
}