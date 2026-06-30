// acac se ve el registro, login, y acctuliazacioes de los datos
import '../model/usuario.dart';

class UsuarioViewModel {

  // aqui se puede decri que es el usuario que ta en tod ese proceso o juego
  static final List<Usuario> _usuarios = [];
  static Usuario? _usuarioActual;
  List<Usuario> get usuarios => List.unmodifiable(_usuarios);
  Usuario? get usuarioActual => _usuarioActual;

  // registara un nuevo usario
  void registrarUsuario(Usuario usuario) {
    _usuarios.add(usuario);
  }

  // en caso que uno ya tenga entra normal sino no
    bool iniciarSesion(String correo, String contrasena) {
    for (Usuario usuario in _usuarios) {
      if (usuario.correo == correo &&
          usuario.contrasena == contrasena) {
        _usuarioActual = usuario;
        return true;
      }
    }
    return false;
  }

  // para cerrar sesion
  void cerrarSesion() {
    _usuarioActual = null;
  }

  // para remplazar o editar un usuario
  void editarUsuario(int index, Usuario usuario) {
    if (index >= 0 && index < _usuarios.length) {
      _usuarios[index] = usuario;
    }
  }

  // elimina un usuario
  void eliminarUsuario(int index) {
    if (index >= 0 && index < _usuarios.length) {
      _usuarios.removeAt(index);
    }
  }

  // actualiza las monedas del usuario actual
  void actualizarMonedas(int monedas) {
    if (_usuarioActual != null) {
      _usuarioActual!.monedas = monedas;
    }
  }

  // para actualizar el mejor puntaje solo si es un recod nuevo
  void actualizarMejorPuntaje(int puntaje) {
    if (_usuarioActual != null &&
        puntaje > _usuarioActual!.mejorPuntaje) {
      _usuarioActual!.mejorPuntaje = puntaje;
    }
  }

  // para la subida de nivel
  void actualizarNivel(int nivel) {
    if (_usuarioActual != null &&
        nivel > _usuarioActual!.nivelAlcanzado) {
      _usuarioActual!.nivelAlcanzado = nivel;
    }
  }
}