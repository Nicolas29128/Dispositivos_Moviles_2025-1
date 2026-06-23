import 'package:flutter/material.dart';

class PantallaJuego extends StatelessWidget {
  const PantallaJuego({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Memoria Numérica"),
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
                  Text("Nivel: 1"),
                  Text("Puntaje: 0"),
                ],
              ),
            ),

            const SizedBox(height: 30),
            // en est parte seria la secuencia que el usuario debera memorizar, pero por ahora solo esta en mensaje
            const Text(
              "8 - 3 - 5",
              style: TextStyle(
                fontSize: 40,
                fontWeight: FontWeight.bold,
              ),
            ),

            const SizedBox(height: 30),
            //aca es dodne el usario debe colocar su respuesta
            TextField(
              decoration: InputDecoration(
                labelText: "Ingrese la secuencia",
                border: OutlineInputBorder(),
              ),
            ),

            const SizedBox(height: 20),
            //el boton para validar la respuesta
            ElevatedButton(
              onPressed: () {},
              child: const Text("Verificar"),
            ),
          ],
        ),
      ),
    );
  }
}