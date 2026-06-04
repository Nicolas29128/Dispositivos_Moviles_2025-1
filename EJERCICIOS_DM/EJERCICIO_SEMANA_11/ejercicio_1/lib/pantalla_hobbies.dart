import 'package:flutter/material.dart';

class PantallaHobbies extends StatelessWidget {
  const PantallaHobbies({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      //para lo que es parte o franja de arriba
      appBar: AppBar(
        title: const Text("Mis Hobbies"),
        centerTitle: false,
        backgroundColor: Colors.red,
        actions: const [
          Icon(Icons.star),
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
              const Text(
                "Mis hobbies favoritos",
                style: TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                  color: Colors.black,
                ),
              ),

              const SizedBox(height: 20),

              Container(
                padding: const EdgeInsets.all(12),
                decoration: BoxDecoration(
                  color: Colors.red.shade50,
                  borderRadius: BorderRadius.circular(12),
                ),
                child: Column(
                  children: const [
                    Row(
                      children: [
                        Icon(
                          Icons.sports_baseball,
                          color: Colors.black,
                          size: 40,
                        ),
                        SizedBox(width: 10),
                        Text("Deporte: jugar basquet, futbol y la natacion"),
                      ],
                    ),

                    SizedBox(height: 15),

                    Row(
                      children: [
                        Icon(
                          Icons.music_note,
                          color: Colors.black,
                          size: 40,
                        ),
                        SizedBox(width: 10),
                        Text("Eschar musica de diferentes generos "),
                      ],
                    ),

                    SizedBox(height: 15),

                    Row(
                      children: [
                        Icon(
                          Icons.videogame_asset,
                          color: Colors.black,
                          size: 40,
                        ),
                        SizedBox(width: 10),
                        Text("Jugar video juegos mas que todo shutters como Valorant"),
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