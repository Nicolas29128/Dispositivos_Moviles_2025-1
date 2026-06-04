import 'package:ejercicio_1/pantalla_hobbies.dart';
import 'package:ejercicio_1/pantalla_inicio.dart';
import 'package:ejercicio_1/pantalla_perfil.dart';
import 'package:flutter/material.dart';

/* DESCRIPCION: en el siguiente ejercico nos pide realizar 3 intefaces puras sin
                estas intefaces se diseñaron por separado (inicio, perfil, hobbies)
 AUTOR: Franco Nicolás Rojas Castro
 FECHA: 03/06/2026
 ULTIMA MODIFICACION: 03/06/2026
 */

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Mi app',
      theme: ThemeData(
        colorScheme: .fromSeed(seedColor: Colors.deepPurple),
      ),
        home: const PantallaInicio(),
        //home: const PantallaPerfil(),
        //home: PantallaHobbies()
    );
  }
}
