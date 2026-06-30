
import 'package:flutter/material.dart';

import 'pantalla_login.dart';
import 'pantalla_registro.dart';

class PantallaInicio extends StatelessWidget {
  const PantallaInicio({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Memoria Numérica"),
        centerTitle: true,
        backgroundColor: Colors.blue,
      ),

      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(20),
          child: Center(
            child: Column(
              children: [
                const SizedBox(height: 40),
                const Icon(
                  Icons.psychology,
                  size: 130,
                  color: Colors.amber,
                ),

                const SizedBox(height: 20),

                // nombre de nuestra app como tal
                const Text(
                  "Don't Forget The Numbers",
                  textAlign: TextAlign.center,
                  style: TextStyle(
                    fontSize: 28,
                    fontWeight: FontWeight.bold,
                  ),
                ),

                const SizedBox(height: 15),

                // una pequeña descripcion de la app
                const Text(
                  "Entrena tu memoria y concentración.",
                  textAlign: TextAlign.center,
                  style: TextStyle(
                    fontSize: 16,
                  ),
                ),

                const SizedBox(height: 40),

                // boton de inicio de sesion
                SizedBox(
                  width: double.infinity,
                  height: 50,
                  child: ElevatedButton(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (_) => const PantallaLogin(),
                        ),
                      );

                    },

                    child: const Text(
                      "Iniciar Sesión",
                      style: TextStyle(fontSize: 18),
                    ),

                  ),
                ),

                const SizedBox(height: 15),

                // boton de crear una nueva ceunta
                SizedBox(
                  width: double.infinity,
                  height: 50,
                  child: OutlinedButton(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (_) => const PantallaRegistro(),
                        ),
                      );

                    },

                    child: const Text(
                      "Crear Cuenta",
                      style: TextStyle(fontSize: 18),
                    ),

                  ),
                ),

              ],

            ),
          ),
        ),
      ),
    );
  }
}