// en est parte se ve la intefaz de login, ademas se controla el acceso a los usarios
import 'package:flutter/material.dart';

import '../viewmodel/usuario_viewmodel.dart';
import 'pantalla_menu.dart';
import 'pantalla_registro.dart';

class PantallaLogin extends StatefulWidget {
  const PantallaLogin({super.key});

  @override
  State<PantallaLogin> createState() => _PantallaLoginState();
}

class _PantallaLoginState extends State<PantallaLogin> {

  // para validar el formulario
  final _formKey = GlobalKey<FormState>();

  // para controlar los distintos campos
  final TextEditingController _correoController =  TextEditingController();

  final TextEditingController _passwordController = TextEditingController();

  // para el manejo de usuarios
  final UsuarioViewModel _usuarioViewModel = UsuarioViewModel();

  @override
  void dispose() {

    // liberar la memoria utilizada
    _correoController.dispose();
    _passwordController.dispose();

    super.dispose();
  }

  @override
  Widget build(BuildContext context) {

    return Scaffold(

      // para lo que seria la parte superior de la pantalla
      appBar: AppBar(
        title: const Text("Iniciar Sesión"),
        centerTitle: true,
        backgroundColor: Colors.blue,
      ),

      body: SingleChildScrollView(

        child: Padding(
          padding: const EdgeInsets.all(20),
          child: Form(
            key: _formKey,
            child: Column(
              children: [
                const SizedBox(height: 30),
                const Icon(
                  Icons.lock_outline,
                  size: 110,
                  color: Colors.black,
                ),

                const SizedBox(height: 20),

                const Text(
                  "Bienvenido",
                  style: TextStyle(
                    fontSize: 28,
                    fontWeight: FontWeight.bold,
                  ),
                ),

                const SizedBox(height: 35),

                // para el correo
                TextFormField(
                  controller: _correoController,
                  keyboardType: TextInputType.emailAddress,
                  decoration: const InputDecoration(
                    labelText: "Correo electrónico",
                    prefixIcon: Icon(Icons.email),
                    border: OutlineInputBorder(),
                  ),

                  validator: (value){
                    if(value == null || value.isEmpty){
                      return "Ingrese su correo.";
                    }
                    return null;
                  },

                ),

                const SizedBox(height: 20),

                // para la contraseña
                TextFormField(
                  controller: _passwordController,
                  obscureText: true,
                  decoration: const InputDecoration(
                    labelText: "Contraseña",
                    prefixIcon: Icon(Icons.lock),
                    border: OutlineInputBorder(),
                  ),

                  validator: (value){
                    if(value == null || value.isEmpty){
                      return "Ingrese su contraseña.";
                    }
                    return null;
                  },
                ),

                const SizedBox(height: 30),

                SizedBox(
                  width: double.infinity,
                  height: 50,
                  child: ElevatedButton(
                    onPressed: () {
                      if(_formKey.currentState!.validate()){
                        // para verificar si el usuario existe
                        bool acceso = _usuarioViewModel.iniciarSesion(
                          _correoController.text,
                          _passwordController.text,
                        );

                        if(acceso){
                          ScaffoldMessenger.of(context).showSnackBar(
                            const SnackBar(
                              content: Text(
                                "Inicio de sesión correcto.",
                              ),
                            ),
                          );

                          Navigator.pushReplacement(
                            context,
                            MaterialPageRoute(
                              builder: (_) =>
                              const PantallaMenu(),
                            ),
                          );
                        }
                        else{
                          ScaffoldMessenger.of(context).showSnackBar(
                            const SnackBar(
                              content: Text(
                                "Correo o contraseña incorrectos.",
                              ),
                            ),
                          );
                        }
                      }
                    },

                    child: const Text(
                      "Ingresar",
                      style: TextStyle(fontSize: 18),
                    ),

                  ),

                ),

                const SizedBox(height: 20),

                // para ir a lo que seria la pantalla de registro
                TextButton(
                  onPressed: (){
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (_) =>
                        const PantallaRegistro(),
                      ),
                    );
                  },
                  child: const Text(
                    "¿No tienes una cuenta? Regístrate",
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