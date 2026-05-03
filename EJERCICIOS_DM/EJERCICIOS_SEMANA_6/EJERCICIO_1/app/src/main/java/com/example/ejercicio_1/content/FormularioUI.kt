package com.example.ejercicio_1.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ejercicio_1.components.CampoTexto
import com.example.ejercicio_1.model.Usuario

@Composable
fun FormularioUI(
    nombre: String,
    telefono: String,
    errorNombre: Boolean,
    errorTelefono: Boolean,
    formularioValido: Boolean,
    onNombreChange: (String) -> Unit,
    onTelefonoChange: (String) -> Unit,
    onRegistrar: () -> Unit

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            "Registro de usuario",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth().background(Color.Red).padding(16.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        CampoTexto(
            nombre, "nombre", errorNombre,
            "El nombre no puede estar vacio", onNombreChange
        )
        CampoTexto(
            telefono, "telefono", errorTelefono, "Solo numeros",
            onTelefonoChange
        )

        Button(
            onClick = onRegistrar,
            enabled = formularioValido
        ) {
            Text("Registrar")
        }

    }
}
