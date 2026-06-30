/*aqui se ve la logica como tal del juego como las reglas, niveles puntajes,
   comodines */
import 'dart:math';

class JuegoViewModel {
  // definimos las variables
  int _puntaje = 0;
  int _nivel = 1;
  int _tiempo = 30;
  int _monedas = 0;
  //los distintos modos o estados que hay
  bool _juegoIniciado = false;
  bool _partidaFinalizada = false;
  bool _mostrarSecuencia = true;
  bool _puedeResponder = false;
  bool _respuestaCorrecta = false;
  bool _perdonErrorDisponible = false;
  bool _masTiempoUsado = false;

  String _mensaje = "";
  List<int> _secuencia = [];
  String _respuestaUsuario = "";

  // se genran los numeros aleatorios
  final Random _random = Random();

  // lo que seria los gets
  int get puntaje => _puntaje;
  int get nivel => _nivel;
  int get tiempo => _tiempo;
  int get monedas => _monedas;
  bool get juegoIniciado => _juegoIniciado;
  bool get partidaFinalizada => _partidaFinalizada;
  bool get mostrarSecuencia => _mostrarSecuencia;
  bool get puedeResponder => _puedeResponder;
  bool get respuestaCorrecta => _respuestaCorrecta;
  bool get perdonErrorDisponible => _perdonErrorDisponible;
  bool get masTiempoUsado => _masTiempoUsado;
  String get mensaje => _mensaje;
  String get respuestaUsuario => _respuestaUsuario;
  List<int> get secuencia => List.unmodifiable(_secuencia);
  String get secuenciaTexto => _secuencia.join(" ");
  int get longitudSecuencia => _secuencia.length;


  void iniciarJuego() {
    // para evitar avrias partidas
    if (_juegoIniciado) return;
    _juegoIniciado = true;
    _partidaFinalizada = false;
    _mensaje = "";

    generarSecuencia();
    mostrarSecuenciaNumerica();
  }

  //metodos para mostrar y ocultar la secunecia de numeros
  void mostrarSecuenciaNumerica() {
    _mostrarSecuencia = true;
    _puedeResponder = false;
  }

  void ocultarSecuencia() {
    _mostrarSecuencia = false;
    _puedeResponder = true;
  }

  // generar una nueva secuencia

  void generarSecuencia() {
    _secuencia.clear();
    // por cda nivel aumenta un numero
    for (int i = 0; i < _nivel + 2; i++) {
      _secuencia.add(_random.nextInt(10));
    }
  }

  bool verificarRespuesta(String respuesta) {
    // se guarda la respuesta ingresada
    _respuestaUsuario = respuesta;

    // transfroma la secuencia texto
    String respuestaCorrecta = _secuencia.join("");

    // comprobar si ambas respuestas coinciden
    _respuestaCorrecta = respuesta == respuestaCorrecta;

    // en caso de ser corrcto
    if (_respuestaCorrecta) {
      // se incrementa el puntaje segun el nivel
      _puntaje += (_nivel * 10);

      // se da las monedas por superar el nivel
      _monedas += (_nivel * 2);
      _mensaje = "¡Correcto!";
      siguienteNivel();
      return true;
    }

    // en caso de tener un comodin
    if (_perdonErrorDisponible) {
      _perdonErrorDisponible = false;
      _mensaje = "Error perdonado";
      return false;
    }
    // finaliza la partida
    _mensaje = "Respuesta incorrecta";
    finalizarPartida();
    return false;
  }

  // pasar al sigueinte nivel
  void siguienteNivel() {
    _nivel++;
    generarSecuencia();
    mostrarSecuenciaNumerica();
  }

  // finaliza y bloquea el juego por asi decirlo

  void finalizarPartida() {
    _partidaFinalizada = true;
    _juegoIniciado = false;
    _puedeResponder = false;
    _mostrarSecuencia = false;
  }

  // incrementar el puntaje

  void agregarPuntaje(int puntos) {
    _puntaje += puntos;
  }

  // incrmentar las monedas
  void agregarMonedas(int cantidad) {
    _monedas += cantidad;
  }

  // descontar la cantidad de monedas

  bool descontarMonedas(int cantidad) {
    if (_monedas >= cantidad) {
      _monedas -= cantidad;
      return true;
    }
    return false;
  }

  void actualizarMensaje(String texto) {
    _mensaje = texto;
  }

  void limpiarMensaje() {
    _mensaje = "";
  }

  // disminuir el tiempo

  void disminuirTiempo() {
    // solo en el caso que la partida siga
    if (_partidaFinalizada) {
      return;
    }
    if (_tiempo > 0) {
      _tiempo--;
    }
    // en caso que el tiempo se termine
    if (_tiempo <= 0) {
      _tiempo = 0;
      _mensaje = "Tiempo agotado";
      finalizarPartida();
    }
  }

  // el comodinde 5 segundos mas
  bool usarMasTiempo() {
    // solo uno por partida
    if (_masTiempoUsado) {
      return false;
    }
    _tiempo += 5;
    _masTiempoUsado = true;
    _mensaje = "+5 segundos";

    return true;
  }

  // =comodin de perdonar un error

  bool usarPerdonError() {
    if (_perdonErrorDisponible) {
      return false;
    }
    _perdonErrorDisponible = true;
    _mensaje = "Perdonar error activado";
    return true;
  }

  // guardar la partida
  void guardarPartida() {
  }

  // para reiniciar la partida
  void reiniciarJuego() {
    _puntaje = 0;
    _nivel = 1;
    _tiempo = 30;
    _monedas = 0;
    _mensaje = "";
    _respuestaUsuario = "";
    _respuestaCorrecta = false;
    _juegoIniciado = false;
    _partidaFinalizada = false;
    _mostrarSecuencia = true;
    _puedeResponder = false;
    _perdonErrorDisponible = false;
    _masTiempoUsado = false;
    _secuencia.clear();
  }

  // para obtener lso datos de la aprtida

  Map<String, dynamic> obtenerDatosPartida() {
    return {
      "puntaje": _puntaje,
      "nivel": _nivel,
      "monedas": _monedas,
      "tiempo": _tiempo,
    };
  }

  // reiniciar el nivel
  void reiniciarNivel() {
    generarSecuencia();
    mostrarSecuenciaNumerica();
  }

  // verifica si la partida termino
  bool partidaTerminada() {
    return _partidaFinalizada;
  }
}