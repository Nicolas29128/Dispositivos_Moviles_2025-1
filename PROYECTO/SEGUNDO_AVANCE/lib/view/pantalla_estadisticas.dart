//aqui se muetran lo que seria las estadisticas o rendimientos del usuario
import 'package:flutter/material.dart';

import '../viewmodel/partida_viewmodel.dart';

class PantallaEstadisticas extends StatefulWidget {
  const PantallaEstadisticas({super.key});

  @override
  State<PantallaEstadisticas> createState() => _PantallaEstadisticasState();
}

class _PantallaEstadisticasState extends State<PantallaEstadisticas> {
  // para administrar las estadísticas
  final PartidaViewModel _partidaViewModel = PartidaViewModel();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // Barra superior
      appBar: AppBar(
        title: const Text("Estadísticas"),
        centerTitle: true,
        backgroundColor: Colors.blue,
      ),

      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(20),
          child: Column(
            children: [
              const Text(
                "Resumen del Desempeño",
                style: TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                ),
              ),

              const SizedBox(height: 25),

              // donde va a ir la grafica
              Container(
                width: double.infinity,
                height: 250,
                decoration: BoxDecoration(
                  color: Colors.indigo.shade50,
                  borderRadius: BorderRadius.circular(15),
                  border: Border.all(
                    color: Colors.black,
                  ),
                ),
                child: const Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Icon(
                      Icons.bar_chart,
                      size: 70,
                      color: Colors.indigo,
                    ),
                    SizedBox(height: 10),
                    Text(
                      "Gráfica de Puntajes",
                      style: TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ],
                ),
              ),

              const SizedBox(height: 30),

              //se visualiza la infromacion del usario en sus partidas
              Row(
                children: [
                  Expanded(
                    child: _TarjetaEstadistica(
                      titulo: "Mejor Puntaje",
                      valor: "${_partidaViewModel.mejorPuntaje}",
                      icono: Icons.emoji_events,
                      color: Colors.amber,
                    ),
                  ),
                  const SizedBox(width: 12),
                  Expanded(
                    child: _TarjetaEstadistica(
                      titulo: "Mayor Nivel",
                      valor: "${_partidaViewModel.nivelMaximo}",
                      icono: Icons.stairs,
                      color: Colors.green,
                    ),
                  ),
                ],
              ),

              const SizedBox(height: 15),

              Row(
                children: [
                  Expanded(
                    child: _TarjetaEstadistica(
                      titulo: "Partidas",
                      valor: "${_partidaViewModel.totalPartidas}",
                      icono: Icons.sports_esports,
                      color: Colors.blue,
                    ),
                  ),
                  const SizedBox(width: 12),
                  Expanded(
                    child: _TarjetaEstadistica(
                      titulo: "Monedas",
                      valor: "${_partidaViewModel.totalMonedas}",
                      icono: Icons.monetization_on,
                      color: Colors.orange,
                    ),
                  ),
                ],
              ),

              const SizedBox(height: 15),

              SizedBox(
                width: double.infinity,
                child: _TarjetaEstadistica(
                  titulo: "Promedio de Puntaje",
                  valor: _partidaViewModel.promedioPuntaje.toStringAsFixed(1),
                  icono: Icons.analytics,
                  color: Colors.purple,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

// para reutilizar al mostar los datos
class _TarjetaEstadistica extends StatelessWidget {
  final String titulo;
  final String valor;
  final IconData icono;
  final Color color;

  const _TarjetaEstadistica({
    required this.titulo,
    required this.valor,
    required this.icono,
    required this.color,
  });

  @override
  Widget build(BuildContext context) {
    return Card(
      elevation: 4,
      child: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(
              icono,
              color: color,
              size: 40,
            ),
            const SizedBox(height: 10),
            Text(
              titulo,
              textAlign: TextAlign.center,
              style: const TextStyle(
                fontSize: 16,
                fontWeight: FontWeight.bold,
              ),
            ),
            const SizedBox(height: 10),
            Text(
              valor,
              style: const TextStyle(
                fontSize: 22,
                fontWeight: FontWeight.bold,
              ),
            ),
          ],
        ),
      ),
    );
  }
}