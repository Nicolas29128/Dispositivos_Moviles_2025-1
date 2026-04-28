package com.example.ejercicio_.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.ejercicio_.ui.content.FormularioUI

/*definimos la variables que vamos a usar en tdo el codigo de la parte de Screem*/
@Composable
fun FormularioScreem(){
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }

    var genero by remember { mutableStateOf("Masculino") }
    var aceptaTerminos by remember { mutableStateOf(false) }
    var activo by remember { mutableStateOf(true) }
    //se le pone 5f para inicie en el nivel 5
    var nivel by remember { mutableStateOf(5f) }

    var resultado by remember { mutableStateOf("") }
    var mostrarResultado by remember { mutableStateOf(false) }

    // creamos las validaciones
    val nombreError = nombre.isBlank()
    val edadError = edad.isBlank() || edad.toIntOrNull() == null
    val correoError = !correo.contains("@")
    val terminosError = !aceptaTerminos
    val formularioValido = !nombreError && !edadError && !correoError && !terminosError


    FormularioUI(
        nombre = nombre,
        edad = edad,
        correo = correo,
        genero = genero,
        aceptaTerminos = aceptaTerminos,
        activo = activo,
        nivel = nivel,

        nombreError = nombreError,
        edadError = edadError,
        correoError = correoError,
        terminosError = terminosError,

        onNombreChange = { nombre = it.uppercase() },
        onEdadChange = { edad = it },
        onCorreoChange = { correo = it },
        onGeneroChange = { genero = it },
        onAceptaTerminosChange = { aceptaTerminos = it },
        onActivoChange = { activo = it },
        onNivelChange = { nivel = it },

        formularioValido = formularioValido,
        resultado = resultado,
        mostrarResultado = mostrarResultado,

        //cuando cuando cumpla las condiciones de tdos los campos se podra presionar el
        // boton Registrar y es ahi donde se motrarar toda la infromacion
        onRegistrar = {
            resultado = "Hola $nombre, tienes ${edad} años, tu estas " +
                    "${if (activo) "activo" else "inactivo"}, tu nivel es ${nivel.toInt()}"
            mostrarResultado = true
        },

        //como su propio nombre lo dice aca limpiamos tdo parq eu este como el inicio.
        onLimpiar = {
            nombre = ""
            edad = ""
            correo = ""
            genero = "Masculino"
            aceptaTerminos = false
            activo = true
            nivel = 5f
            resultado = ""
            mostrarResultado = false
        }
    )
}