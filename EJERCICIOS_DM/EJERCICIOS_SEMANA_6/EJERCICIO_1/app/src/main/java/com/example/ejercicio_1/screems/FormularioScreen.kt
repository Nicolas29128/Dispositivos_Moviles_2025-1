package com.example.ejercicio_1.screems

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.ejercicio_1.content.FormularioUI
import com.example.ejercicio_1.model.Usuario

@Composable
fun FormularioScreen(
    navController: NavController
){

    var nombre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }

    //VALIDACIONES
    var errorNombre = nombre.isBlank()
    var errorTelefono = telefono.isBlank() || telefono.toIntOrNull() == null
    var formularioValido = !errorNombre && !errorTelefono

    FormularioUI(
        nombre = nombre,
        telefono = telefono,
        errorNombre = errorNombre,
        errorTelefono = errorTelefono,
        formularioValido = formularioValido,
        onNombreChange = { nombre = it.uppercase() },
        onTelefonoChange = { telefono = it },

        onRegistrar = {
            val nuevoUsuario = Usuario(nombre, telefono)
            //usuarios = usuarios + nuevoUsuario
            nombre = ""
            telefono = ""
            navController.popBackStack()

        }

    )

}
