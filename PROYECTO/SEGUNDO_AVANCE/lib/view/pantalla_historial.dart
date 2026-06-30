// aqui se puede observar el historial de partidas y puntajes del usario
import 'package:flutter/material.dart';
import '../viewmodel/partida_viewmodel.dart';

class PantallaHistorial extends StatefulWidget {
  const PantallaHistorial({super.key});

  @override
  State<PantallaHistorial> createState() => _PantallaHistorialState();
}

class _PantallaHistorialState extends State<PantallaHistorial> {
  final PartidaViewModel _partidaViewModel = PartidaViewModel();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // Barra superior
      appBar: AppBar(
        title: const Text("Historial de Partidas"),
        centerTitle: true,
        backgroundColor: Colors.blue,
      ),

      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            // Título de la pantalla
            const Text(
              "Mis Partidas",
              style: TextStyle(
                fontSize: 24,
                fontWeight: FontWeight.bold,
              ),
            ),

            const SizedBox(height: 20),

            // para lo que es el resumen general
            Container(
              width: double.infinity,
              padding: const EdgeInsets.all(15),
              decoration: BoxDecoration(
                color: Colors.indigo.shade50,
                borderRadius: BorderRadius.circular(12),
              ),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: [
                  Column(
                    children: [
                      const Icon(Icons.history),
                      const SizedBox(height: 5),
                      const Text(
                        "Partidas",
                        style: TextStyle(
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                      Text(
                        "${_partidaViewModel.totalPartidas}",
                      ),
                    ],
                  ),

                  Column(
                    children: [
                      const Icon(Icons.emoji_events),
                      const SizedBox(height: 5),
                      const Text(
                        "Mejor Puntaje",
                        style: TextStyle(
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                      Text(
                        "${_partidaViewModel.mejorPuntaje}",
                      ),
                    ],
                  ),
                ],
              ),
            ),

            const SizedBox(height: 20),

            // la lista del historial
            Expanded(
              child: _partidaViewModel.partidas.isEmpty
              // en caso que no exista una partida
                  ? const Center(
                child: Text(
                  "Aún no existen partidas registradas.",
                  style: TextStyle(
                    fontSize: 18,
                  ),
                ),
              )

              // cuando existe una o mas partidas
                  : ListView.builder(
                itemCount: _partidaViewModel.partidas.length,
                itemBuilder: (context, index) {
                  final partida = _partidaViewModel.partidas[index];

                  return Padding(
                    padding: const EdgeInsets.only(bottom: 12),
                    child: _TarjetaPartida(
                      nivel: partida.nivel,
                      puntaje: partida.puntaje,
                      monedas: partida.monedasGanadas,
                      fecha: partida.fecha.toString(),
                    ),
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}

// reutilizar para mostarar los datos
class _TarjetaPartida extends StatelessWidget {
  final int nivel;
  final int puntaje;
  final int monedas;
  final String fecha;

  const _TarjetaPartida({
    required this.nivel,
    required this.puntaje,
    required this.monedas,
    required this.fecha,
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return Card(
      elevation: 3,
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.circular(12),
      ),
      child: Padding(
        padding: const EdgeInsets.all(15),
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const CircleAvatar(
              radius: 24,
              backgroundColor: Colors.indigo,
              child: Icon(
                Icons.history,
                color: Colors.white,
              ),
            ),

            const SizedBox(width: 15),

            // la infromacion de la partida
            Expanded(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    "Nivel alcanzado: $nivel",
                    style: const TextStyle(
                      fontWeight: FontWeight.bold,
                      fontSize: 17,
                    ),
                  ),

                  const SizedBox(height: 8),

                  Row(
                    children: [
                      const Icon(Icons.emoji_events, size: 18),
                      const SizedBox(width: 5),
                      Text("Puntaje: $puntaje"),
                    ],
                  ),

                  const SizedBox(height: 6),

                  Row(
                    children: [
                      const Icon(Icons.monetization_on, size: 18),
                      const SizedBox(width: 5),
                      Text("Monedas: $monedas"),
                    ],
                  ),

                  const SizedBox(height: 6),

                  Row(
                    children: [
                      const Icon(Icons.calendar_today, size: 18),
                      const SizedBox(width: 5),
                      Expanded(
                        child: Text("Fecha: $fecha"),
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}