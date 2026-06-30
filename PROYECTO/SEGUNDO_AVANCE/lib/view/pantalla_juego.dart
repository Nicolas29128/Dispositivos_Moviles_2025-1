//la interfaz de lo que se puentra en el moemnto de jugar

import 'package:flutter/material.dart';

import '../viewmodel/juego_viewmodel.dart';

class PantallaJuego extends StatefulWidget {
  const PantallaJuego({super.key});

  @override
  State<PantallaJuego> createState() => _PantallaJuegoState();
}

class _PantallaJuegoState extends State<PantallaJuego> {
  // para validar el formulario
  final _formKey = GlobalKey<FormState>();
  // controlar el campo donde el usuario ingresa la secuencia
  final TextEditingController _respuestaController = TextEditingController();
  final JuegoViewModel _juegoViewModel = JuegoViewModel();

  @override
  void initState() {
    super.initState();
    // inciar una nueva partida
    _juegoViewModel.iniciarJuego();
  }

  @override
  void dispose() {
    // par liberar la memoria utilizada por el controlador
    _respuestaController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // Barra superior
      appBar: AppBar(
        title: const Text("Memoria Numérica"),
        centerTitle: true,
        backgroundColor: Colors.blue,
      ),

      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(20),
          child: Form(
            key: _formKey,
            child: Column(
              children: [
                // datos de la partida actual
                Container(
                  padding: const EdgeInsets.all(15),
                  decoration: BoxDecoration(
                    color: Colors.indigo.shade50,
                    borderRadius: BorderRadius.circular(12),
                  ),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceAround,
                    children: [
                      // el nivel actual
                      Column(
                        children: [
                          const Icon(Icons.stairs),
                          const SizedBox(height: 5),
                          const Text(
                            "Nivel",
                            style: TextStyle(
                              fontWeight: FontWeight.bold,
                            ),
                          ),
                          Text(
                            "${_juegoViewModel.nivel}",
                          ),
                        ],
                      ),

                      // el puntaje actual
                      Column(
                        children: [
                          const Icon(Icons.emoji_events),
                          const SizedBox(height: 5),
                          const Text(
                            "Puntaje",
                            style: TextStyle(
                              fontWeight: FontWeight.bold,
                            ),
                          ),
                          Text(
                            "${_juegoViewModel.puntaje}",
                          ),
                        ],
                      ),

                      // el timepo restante (falta mejorar)
                      Column(
                        children: [
                          const Icon(Icons.timer),
                          const SizedBox(height: 5),
                          const Text(
                            "Tiempo",
                            style: TextStyle(
                              fontWeight: FontWeight.bold,
                            ),
                          ),
                          Text(
                            "${_juegoViewModel.tiempo} s",
                          ),
                        ],
                      ),
                    ],
                  ),
                ),

                const SizedBox(height: 35),

                // en donde se muestra la secuencia
                Container(
                  width: double.infinity,
                  height: 130,
                  alignment: Alignment.center,
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(15),
                    border: Border.all(
                      color: Colors.black,
                    ),
                  ),
                  child: Text(
                    _juegoViewModel.mostrarSecuencia
                        ? _juegoViewModel.secuenciaTexto
                        : "••••••",
                    style: const TextStyle(
                      fontSize: 34,
                      fontWeight: FontWeight.bold,
                      letterSpacing: 2,
                    ),
                  ),
                ),

                const SizedBox(height: 30),

                // donde el usuario va a a escribir la secuencia
                TextFormField(
                  controller: _respuestaController,
                  keyboardType: TextInputType.number,
                  decoration: const InputDecoration(
                    labelText: "Ingrese la secuencia",
                    prefixIcon: Icon(Icons.numbers),
                    border: OutlineInputBorder(),
                  ),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return "Ingrese la secuencia.";
                    }

                    return null;
                  },
                ),

                const SizedBox(height: 25),


                SizedBox(
                  width: double.infinity,
                  height: 50,
                  child: ElevatedButton(
                    onPressed: () {
                      if (!_formKey.currentState!.validate()) {
                        return;
                      }

                      bool correcta = _juegoViewModel.verificarRespuesta(
                        _respuestaController.text,
                      );

                      setState(() {});

                      ScaffoldMessenger.of(context).showSnackBar(
                        SnackBar(
                          content: Text(
                            _juegoViewModel.mensaje,
                          ),
                        ),
                      );

                      if (correcta) {
                        _respuestaController.clear();
                      }
                    },
                    child: const Text(
                      "Verificar",
                      style: TextStyle(
                        fontSize: 18,
                      ),
                    ),
                  ),
                ),

                const SizedBox(height: 35),

                // parte de los comodines a usar
                const Align(
                  alignment: Alignment.centerLeft,
                  child: Text(
                    "Comodines",
                    style: TextStyle(
                      fontSize: 20,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ),

                const SizedBox(height: 15),

                Row(
                  children: [
                    // comodin de 5 segundo extras
                    Expanded(
                      child: OutlinedButton.icon(
                        onPressed: () {
                          bool usado = _juegoViewModel.usarMasTiempo();

                          setState(() {});

                          ScaffoldMessenger.of(context).showSnackBar(
                            SnackBar(
                              content: Text(
                                usado
                                    ? "+5 segundos agregados."
                                    : "Este comodín ya fue utilizado.",
                              ),
                            ),
                          );
                        },
                        icon: const Icon(Icons.timer),
                        label: const Text(
                          "+5 Segundos",
                          textAlign: TextAlign.center,
                        ),
                      ),
                    ),

                    const SizedBox(width: 10),

                    // comodin de perdonar error
                    Expanded(
                      child: OutlinedButton.icon(
                        onPressed: () {
                          bool usado = _juegoViewModel.usarPerdonError();
                          setState(() {});
                          ScaffoldMessenger.of(context).showSnackBar(
                            SnackBar(
                              content: Text(
                                usado
                                    ? "Comodín activado."
                                    : "Este comodín ya fue utilizado.",
                              ),
                            ),
                          );
                        },
                        icon: const Icon(Icons.favorite),
                        label: const Text(
                          "Perdonar Error",
                          textAlign: TextAlign.center,
                        ),
                      ),
                    ),
                  ],
                ),

                const SizedBox(height: 30),

                Text(
                  _juegoViewModel.mensaje,
                  style: TextStyle(
                    fontSize: 18,
                    fontWeight: FontWeight.bold,
                    color: _juegoViewModel.respuestaCorrecta
                        ? Colors.green
                        : Colors.red,
                  ),
                  textAlign: TextAlign.center,
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}