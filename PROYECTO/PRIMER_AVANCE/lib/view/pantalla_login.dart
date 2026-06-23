import 'package:flutter/material.dart';
import 'pantalla_menu.dart';
import 'pantalla_registro.dart';

class PantallaLogin extends StatelessWidget {
  const PantallaLogin({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Iniciar Sesión"),
        backgroundColor: Colors.blue,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            const SizedBox(height: 20),
            //aca tenemos lo que seria el espacio donde se colocara el correo y la contarseña
            TextField(
              decoration: InputDecoration(
                labelText: "Correo",
                border: OutlineInputBorder(),
              ),
            ),

            const SizedBox(height: 15),

            TextField(
              obscureText: true,
              decoration: InputDecoration(
                labelText: "Contraseña",
                border: OutlineInputBorder(),
              ),
            ),

            const SizedBox(height: 20),

            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (_) => const PantallaMenu(),
                  ),
                );
              },
              child: const Text("Ingresar"),
            ),
            //colocamos lo que seria el boton y la anavegaciona hacia la pantalla de registarse
            // en caso que no tenga un ceunta creada
            TextButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (_) => const PantallaRegistro(),
                  ),
                );
              },
              child: const Text("Crear cuenta"),
            ),
          ],
        ),
      ),
    );
  }
}