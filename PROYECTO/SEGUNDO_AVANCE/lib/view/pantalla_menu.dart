/*la intefaz de la pantala de menu donde hay el mejor puntaje, y monedas, ademas
de los botones de iiciar, historial, estadistica, comodines que te dirigiran
a sus respectivas pantallas*/

import 'package:flutter/material.dart';

import '../viewmodel/usuario_viewmodel.dart';
import 'pantalla_juego.dart';
import 'pantalla_historial.dart';
import 'pantalla_estadisticas.dart';
import 'pantalla_comodines.dart';
import 'pantalla_inicio.dart';

class PantallaMenu extends StatelessWidget {
  const PantallaMenu({super.key});

  @override
  Widget build(BuildContext context) {

    final UsuarioViewModel usuarioViewModel =
    UsuarioViewModel();

    return Scaffold(
      appBar: AppBar(
        title: const Text("Menú Principal"),
        centerTitle: true,
        backgroundColor: Colors.blue,

        actions: [
          // para cerrar la sesion
          IconButton(
            onPressed: () {
              usuarioViewModel.cerrarSesion();
              Navigator.pushAndRemoveUntil(
                context,
                MaterialPageRoute(
                  builder: (_) => const PantallaInicio(),
                ),
                    (route) => false,
              );
            },
            icon: const Icon(Icons.logout),
          ),
        ],

      ),

      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(20),
          child: Column(
            children: [

              // infromacion del usiario como monedas y mejor puntaje
              Container(
                width: double.infinity,
                padding: const EdgeInsets.all(20),
                decoration: BoxDecoration(
                  color: Colors.indigo.shade50,
                  borderRadius: BorderRadius.circular(15),
                ),
                child: Column(
                  children: [
                    const CircleAvatar(
                      radius: 40,
                      child: Icon(
                        Icons.person,
                        size: 45,
                      ),

                    ),

                    const SizedBox(height: 10),

                    Text(
                      "Bienvenido ${usuarioViewModel.usuarioActual?.nombre ?? ""}",
                      style: const TextStyle(
                        fontSize: 24,
                        fontWeight: FontWeight.bold,
                      ),
                    ),

                    const SizedBox(height: 15),

                    Row(
                      mainAxisAlignment:
                      MainAxisAlignment.spaceEvenly,
                      children: [
                        Column(
                          children: [
                            const Icon(Icons.monetization_on),
                            const SizedBox(height: 5),
                            const Text("Monedas"),
                            Text(
                              "${usuarioViewModel.usuarioActual?.monedas ?? 0}",
                            ),
                          ],
                        ),

                        Column(
                          children: [
                            const Icon(Icons.emoji_events),
                            const SizedBox(height: 5),
                            const Text("Mejor Puntaje"),
                            Text(
                              "${usuarioViewModel.usuarioActual?.mejorPuntaje ?? 0}",
                            ),
                          ],
                        ),
                      ],
                    ),
                  ],
                ),

              ),

              const SizedBox(height: 30),

              // para iniciar el juego
              SizedBox(
                width: double.infinity,
                height: 55,
                child: ElevatedButton.icon(
                  onPressed: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (_) => const PantallaJuego(),
                      ),
                    );
                  },
                  icon: const Icon(Icons.play_arrow),
                  label: const Text(
                    "Iniciar Juego",
                  ),
                ),
              ),

              const SizedBox(height: 15),

              // para ir al historial
              SizedBox(
                width: double.infinity,
                height: 55,
                child: ElevatedButton.icon(
                  onPressed: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (_) =>
                        const PantallaHistorial(),
                      ),
                    );
                  },

                  icon: const Icon(Icons.history),
                  label: const Text(
                    "Historial",
                  ),
                ),
              ),

              const SizedBox(height: 15),

              // para ir a las estadisticas
              SizedBox(
                width: double.infinity,
                height: 55,
                child: ElevatedButton.icon(
                  onPressed: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (_) =>
                        const PantallaEstadisticas(),
                      ),
                    );
                  },

                  icon: const Icon(Icons.bar_chart),
                  label: const Text(
                    "Estadísticas",
                  ),
                ),
              ),

              const SizedBox(height: 15),

              // para ir a los comodines
              SizedBox(
                width: double.infinity,
                height: 55,
                child: ElevatedButton.icon(
                  onPressed: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (_) =>
                        const PantallaComodines(),
                      ),
                    );
                  },
                  icon: const Icon(Icons.shopping_cart),
                  label: const Text(
                    "Comodines",
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

}