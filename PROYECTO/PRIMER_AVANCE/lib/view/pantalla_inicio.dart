import 'package:flutter/material.dart';
import 'pantalla_login.dart';

class PantallaInicio extends StatelessWidget {
  const PantallaInicio({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // en esta parte hacemos lo que seria la parte superior de la interfaz y
      // esto tendra lo mismo en todas las de mas interfaces.
      appBar: AppBar(
        title: const Text("Memoria Numérica"),
        backgroundColor: Colors.blue,
      ),
      // para ponerle lo que seria el espacio y asi tener un poco mas de forma
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Center(
          child: Column(
            children: [
              const SizedBox(height: 40),
              //para el icono que se muestra al principio, aun tamos viendo asi
              // o cmabiarlo por otro, solo lo usamos para als pruebas
              const Icon(
                Icons.psychology,
                size: 120,
              ),

              const SizedBox(height: 20),
              //esta aprte esta centrado y va lo que seria muestro nombre de la app
              const Text(
                "Don't Forget The Numbers",
                style: TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                ),
              ),

              const SizedBox(height: 10),
              //colocamos un descripcion breve para el usuario de que es lo que trata el juego
              const Text(
                "Entrena tu memoria y concentración",
                textAlign: TextAlign.center,
              ),

              const SizedBox(height: 30),
              //colocamos lo que seria el boton y la anavegaciona hacia el inicio de sesion
              ElevatedButton(
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (_) => const PantallaLogin(),
                    ),
                  );
                },
                child: const Text("Iniciar Sesión"),
              ),
            ],
          ),
        ),
      ),
    );
  }
}