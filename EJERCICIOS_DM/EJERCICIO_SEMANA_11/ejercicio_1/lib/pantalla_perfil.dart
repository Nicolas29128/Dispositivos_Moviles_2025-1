import 'package:flutter/material.dart';

class PantallaPerfil extends StatelessWidget {
  const PantallaPerfil({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      //para lo que es parte o franja de arriba
      appBar: AppBar(
        title: const Text("Mi Perfil"),
        centerTitle: false,
        backgroundColor: Colors.red,
        actions: const [
          Icon(Icons.person),
          SizedBox(width: 12),
          Icon(Icons.favorite),
        ],
      ),
      //para usar el scrol en caso se extienda la pantalla
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(16),
          child: Column(
            children: [
              Image.network(
                "https://cdn-icons-png.flaticon.com/512/5906/5906160.png",
                height: 180,
              ),

              const SizedBox(height: 15),

              const Text(
                "Soy Franco Nicolás",
                style: TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                  color: Colors.black,
                ),
              ),

              const SizedBox(height: 10),

              const Text(
                "Soy estudiante de ingenieria de software y me gusta desarrollar en java y actualemente me esta llamando la atencion flutter",
                textAlign: TextAlign.center,
              ),

              const SizedBox(height: 20),

              //donde ira toda la info de correo y telefono
              Container(
                padding: const EdgeInsets.all(12),
                decoration: BoxDecoration(
                  color: Colors.red.shade50,
                  borderRadius: BorderRadius.circular(12),
                ),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceAround,
                  children: [
                    Column(
                      children: const [
                        Icon(
                          Icons.email,
                          color: Colors.black,
                        ),
                        SizedBox(height: 5),
                        Text("Correo"),
                        Text("frojasc@ulasalle.edu.pe")
                      ],
                    ),

                    Column(
                      children: const [
                        Icon(
                          Icons.phone,
                          color: Colors.black,
                        ),
                        SizedBox(height: 5),
                        Text("Teléfono"),
                        Text("987654321")
                      ],
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}