// la intefaz de lo que seria los comodines
import 'package:flutter/material.dart';

import '../viewmodel/comodin_viewmodel.dart';

class PantallaComodines extends StatefulWidget {
  const PantallaComodines({super.key});

  @override
  State<PantallaComodines> createState() => _PantallaComodinesState();
}

class _PantallaComodinesState extends State<PantallaComodines> {
  // aqui se conecta la logica con la intefaz
  final ComodinViewModel _comodinViewModel = ComodinViewModel();

  //para lo que seri ala barra superior de la interfaz
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Comodines"),
        centerTitle: true,
        backgroundColor: Colors.blue,
      ),

      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(20),
          child: Column(
            children: [
              const Text(
                "Tienda de Comodines",
                style: TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                ),
              ),

              const SizedBox(height: 25),

              // las monedas que tiene
              Container(
                width: double.infinity,
                padding: const EdgeInsets.all(15),
                decoration: BoxDecoration(
                  color: Colors.amber.shade100,
                  borderRadius: BorderRadius.circular(12),
                ),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    const Icon(
                      Icons.monetization_on,
                      color: Colors.orange,
                      size: 35,
                    ),
                    const SizedBox(width: 10),
                    Text(
                      "Monedas disponibles: "
                          "${_comodinViewModel.monedasDisponibles}",
                      style: const TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ],
                ),
              ),

              const SizedBox(height: 30),

              // parte del primer comodin
              _TarjetaComodin(
                icono: Icons.timer,
                nombre: _comodinViewModel.comodines[0].nombre,
                descripcion: _comodinViewModel.comodines[0].descripcion,
                costo: _comodinViewModel.comodines[0].costo,
                onComprar: () {
                  setState(() {
                    _comodinViewModel.comprarComodin(
                      _comodinViewModel.comodines[0],
                    );
                  });
                },
              ),

              const SizedBox(height: 20),

              // parte del segundo comodin
              _TarjetaComodin(
                icono: Icons.favorite,
                nombre: _comodinViewModel.comodines[1].nombre,
                descripcion: _comodinViewModel.comodines[1].descripcion,
                costo: _comodinViewModel.comodines[1].costo,
                onComprar: () {
                  setState(() {
                    _comodinViewModel.comprarComodin(
                      _comodinViewModel.comodines[1],
                    );
                  });
                },
              ),

              const SizedBox(height: 20),

              // parte del tercer comodin
              _TarjetaComodin(
                icono: Icons.visibility,
                nombre: _comodinViewModel.comodines[2].nombre,
                descripcion: _comodinViewModel.comodines[2].descripcion,
                costo: _comodinViewModel.comodines[2].costo,
                onComprar: () {
                  setState(() {
                    _comodinViewModel.comprarComodin(
                      _comodinViewModel.comodines[2],
                    );
                  });
                },
              ),
            ],
          ),
        ),
      ),
    );
  }
}

// para reutilizar para mostrar los comodines

class _TarjetaComodin extends StatelessWidget {
  final IconData icono;
  final String nombre;
  final String descripcion;
  final int costo;
  final VoidCallback onComprar;

  const _TarjetaComodin({
    required this.icono,
    required this.nombre,
    required this.descripcion,
    required this.costo,
    required this.onComprar,
  });

  @override
  Widget build(BuildContext context) {
    return Card(
      elevation: 4,
      child: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            Icon(
              icono,
              size: 60,
              color: Colors.indigo,
            ),

            const SizedBox(height: 15),

            Text(
              nombre,
              style: const TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold,
              ),
            ),

            const SizedBox(height: 10),

            Text(
              descripcion,
              textAlign: TextAlign.center,
            ),

            const SizedBox(height: 15),

            Text(
              "Costo: $costo monedas",
              style: const TextStyle(
                fontWeight: FontWeight.bold,
                fontSize: 16,
              ),
            ),

            const SizedBox(height: 15),

            SizedBox(
              width: double.infinity,
              child: ElevatedButton(
                onPressed: onComprar,
                child: const Text(
                  "Comprar",
                  style: TextStyle(
                    fontSize: 16,
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}