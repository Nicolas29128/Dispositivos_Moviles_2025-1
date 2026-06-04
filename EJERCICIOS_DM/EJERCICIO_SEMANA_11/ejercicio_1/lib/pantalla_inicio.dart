import 'package:flutter/material.dart';

class PantallaInicio extends StatelessWidget {
  const PantallaInicio({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      //para lo que es parte o franja de arriba
      appBar: AppBar(
        title: const Text("Bienvenido"),
        centerTitle: false,
        backgroundColor: Colors.red,
        actions: const [
          Icon(Icons.settings),
          SizedBox(width: 12),
          Icon(Icons.add),
        ],
      ),
      //para usar el scrol en caso se extienda la pantalla
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(16),
          child: Center(
            child: Column(
              children: [
                const Text(
                  "Hola, esta es mi app personal",
                  style: TextStyle(
                    fontSize: 24,
                    fontWeight: FontWeight.bold,
                    color: Colors.black,
                  ),
                  textAlign: TextAlign.center,
                ),

                const SizedBox(height: 15),

                Container(
                  padding: const EdgeInsets.all(12),
                  decoration: BoxDecoration(
                    color: Colors.red.shade50,
                    borderRadius: BorderRadius.circular(12),
                  ),
                  child: const Column(
                    children: [
                      Text(
                        "Algunas cosas sobre mi",
                        textAlign: TextAlign.center,
                      ),
                    ],
                  ),
                ),

                const SizedBox(height: 20),

                ElevatedButton(
                  onPressed: () {},
                  child: const Text("Ver mi perfil"),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}