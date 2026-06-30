/* la interfaz de registro de usuario, asi mismo guardarlo y validarlos
*/

import 'package:flutter/material.dart';

import '../model/usuario.dart';
import '../viewmodel/usuario_viewmodel.dart';
import 'pantalla_login.dart';

class PantallaRegistro extends StatefulWidget {
  const PantallaRegistro({super.key});

  @override
  State<PantallaRegistro> createState() => _PantallaRegistroState();
}

class _PantallaRegistroState extends State<PantallaRegistro> {

  // para validar el formulario
  final _formKey = GlobalKey<FormState>();

  // para comprobar la infromacion de cada elemento
  final TextEditingController _nombreController = TextEditingController();
  final TextEditingController _correoController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();
  final TextEditingController _confirmarPasswordController = TextEditingController();

  // para administrar los usuarios
  final UsuarioViewModel _usuarioViewModel =
  UsuarioViewModel();

  @override
  void dispose() {

    // para liberar la memoria utilizada
    _nombreController.dispose();
    _correoController.dispose();
    _passwordController.dispose();
    _confirmarPasswordController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      //para lo que seria la parte supeior de la pantalla
      appBar: AppBar(
        title: const Text("Crear Cuenta"),
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
                const SizedBox(height: 20),
                const Icon(
                  Icons.person_add,
                  size: 100,
                  color: Colors.black,
                ),
                const SizedBox(height: 20),
                const Text(
                  "Crea una cuenta",
                  style: TextStyle(
                    fontSize: 28,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                const SizedBox(height: 30),

                // para el nombre del usuario
                TextFormField(
                  controller: _nombreController,
                  decoration: const InputDecoration(
                    labelText: "Nombre",
                    prefixIcon: Icon(Icons.person),
                    border: OutlineInputBorder(),
                  ),

                  validator: (value){
                    if(value == null || value.isEmpty){
                      return "Ingrese su nombre.";
                    }
                    return null;
                  },
                ),

                const SizedBox(height: 20),

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
                      return "Ingrese una contraseña.";
                    }
                    if(value.length < 6){
                      return "La contraseña debe tener 6 a más caracteres.";
                    }
                    return null;

                  },
                ),

                const SizedBox(height: 20),

                // para comprobar si es la contraseña o difrente
                TextFormField(
                  controller: _confirmarPasswordController,
                  obscureText: true,
                  decoration: const InputDecoration(
                    labelText: "Confirmar contraseña",
                    prefixIcon: Icon(Icons.lock_outline),
                    border: OutlineInputBorder(),
                  ),

                  validator: (value){
                    if(value == null || value.isEmpty){
                      return "Confirme su contraseña.";
                    }
                    if(value != _passwordController.text){
                      return "Las contraseñas no coinciden.";
                    }
                    return null;
                  },
                ),

                const SizedBox(height: 30),

                // boton para registrar el usario
                SizedBox(
                  width: double.infinity,
                  height: 50,
                  child: ElevatedButton(
                    onPressed: () {
                      if(_formKey.currentState!.validate()){

                        // aqui se crea un nuevo usario
                        Usuario nuevoUsuario = Usuario(
                          id: DateTime.now()
                              .millisecondsSinceEpoch
                              .toString(),
                          nombre: _nombreController.text,
                          correo: _correoController.text,
                          contrasena: _passwordController.text,
                        );

                        // aquie se agraga ese usario creado
                        _usuarioViewModel.registrarUsuario(
                          nuevoUsuario,
                        );

                        ScaffoldMessenger.of(context).showSnackBar(
                          const SnackBar(
                            content: Text(
                              "Usuario registrado correctamente.",
                            ),
                          ),
                        );

                        // despues de registarse correctamente se va a la pantalla de login
                        Navigator.pushReplacement(
                          context,
                          MaterialPageRoute(
                            builder: (_) => const PantallaLogin(),
                          ),
                        );
                      }

                    },

                    child: const Text(
                      "Registrarse",
                      style: TextStyle(fontSize: 18),
                    ),
                  ),
                ),

                const SizedBox(height: 20),
                // para regresar a la pantalla de incio de sesion
                TextButton(
                  onPressed: (){
                    Navigator.pushReplacement(
                      context,
                      MaterialPageRoute(
                        builder: (_) => const PantallaLogin(),
                      ),
                    );
                  },

                  child: const Text(
                    "¿Ya tienes una cuenta? Inicia sesión",
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