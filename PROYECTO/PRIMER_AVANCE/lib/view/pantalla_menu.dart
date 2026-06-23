import 'package:flutter/material.dart';
import 'pantalla_juego.dart';

class PantallaMenu extends StatelessWidget {
  const PantallaMenu({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Menú Principal"),
        backgroundColor: Colors.blue,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            Container(
              padding: const EdgeInsets.all(12),
              decoration: BoxDecoration(
                color: Colors.indigo.shade50,
                borderRadius: BorderRadius.circular(12),
              ),
              //aca se muestra lo que seria las modenda que tiene el usuario y su mejor puntaje
              child: const Column(
                children: [
                  Text("Monedas: 0"),
                  Text("Mejor puntaje: 0"),
                ],
              ),
            ),

            const SizedBox(height: 20),
            //en esta parte es el boton y la navehgacion a el juego como tal
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (_) => const PantallaJuego(),
                  ),
                );
              },
              child: const Text("Jugar"),
            ),

            const SizedBox(height: 10),
            //en est parte es los botones de historial, estadisticas y comodinesdel usuario
            //pero aun no esta completamente implementada
            ElevatedButton(
              onPressed: () {},
              child: const Text("Historial"),
            ),

            const SizedBox(height: 10),

            ElevatedButton(
              onPressed: () {},
              child: const Text("Estadísticas"),
            ),

            const SizedBox(height: 10),

            ElevatedButton(
              onPressed: () {},
              child: const Text("Comodines"),
            ),
          ],
        ),
      ),
    );
  }
}