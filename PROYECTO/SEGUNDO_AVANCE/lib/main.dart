import 'package:flutter/material.dart';
import 'view/pantalla_inicio.dart';

void main() {
  runApp(const MyApp());
}

/* DESCRIPCION: desarrollo del juego educativo de memoria numerica, consiste en
   que el usuario debe recordar los nuemro que saldra en la pantalla y debe
   colorcralos correctamente, aparte de ello por cdaa cierdo se le dara comodines
   de tiempo, permitir un error entre otros.
   Recordar que esta solo es la primera version solo se muestra interfaz.

   AUTOR: Franco Nicolás Rojas Castro
          Joel Matias Choquepata Guarniz
          Cinthia America Blanco Rodrigo
   FECHA VERSION1: 22/06/2026
*/

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: "Memoria Numérica",
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
          seedColor: Colors.indigo,
        ),
      ),
      home: const PantallaInicio(),
    );
  }
}