package com.example.ejercicio_.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ejercicio_.ui.components.CampoTexto

@Composable
fun FormularioUI(
    nombre: String,
    edad: String,
    correo: String,
    genero: String,
    aceptaTerminos: Boolean,
    activo: Boolean,
    nivel: Float,

    nombreError: Boolean,
    edadError: Boolean,
    correoError: Boolean,
    terminosError: Boolean,

    onNombreChange: (String) -> Unit,
    onEdadChange: (String) -> Unit,
    onCorreoChange: (String) -> Unit,
    onGeneroChange: (String) -> Unit,
    onAceptaTerminosChange: (Boolean) -> Unit,
    onActivoChange: (Boolean) -> Unit,
    onNivelChange: (Float) -> Unit,

    formularioValido: Boolean,
    resultado: String,
    mostrarResultado: Boolean,

    onRegistrar: () -> Unit,
    onLimpiar: () -> Unit
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

        CampoTexto(nombre, "nombre", nombreError,
            "El nombre no puede estar vacio", onNombreChange)
        CampoTexto(edad, "edad", edadError, "Solo numeros",
            onEdadChange)
        CampoTexto(correo, "correo", correoError, "Debe tener @",
            onCorreoChange)


        // aca usamos el rediobutton, para el genero sea masculino o femenino, y por defecto lo
        // ponemos esta en masculino
        Text("Género")
        Row {
            RadioButton(
                selected = genero == "Masculino",
                onClick = { onGeneroChange("Masculino") }
            )
            Text("Masculino")

            Spacer(modifier = Modifier.width(10.dp))

            RadioButton(
                selected = genero == "Femenino",
                onClick = { onGeneroChange("Femenino") }
            )
            Text("Femenino")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // en esta parte uso checkbox para lo que seria la aceptacion de terminos, se
        // puede marcar y desmarcar, ademas es obligatorio marcarlo sino saldra un mensaje de error
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = aceptaTerminos,
                onCheckedChange = onAceptaTerminosChange
            )
            Text("Aceptar términos")
        }

        if (terminosError) {
            Text("Debes aceptar los términos", color = Color.Red)
        }

        Spacer(modifier = Modifier.height(20.dp))

        // en esta parte uso el switch para ver si el usurio esta activo por defecto esta activo
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Usuario activo")
            Switch(
                checked = activo,
                onCheckedChange = onActivoChange
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // en esta parte uso slider para que el usurio desplace y ponga su nivel, ademas arriba
        // de este vera en que nivel esta el numero
        Text("Nivel: ${nivel.toInt()}")
        Slider(
            value = nivel,
            onValueChange = onNivelChange,
            valueRange = 0f..10f
        )

        Spacer(modifier = Modifier.height(20.dp))


        Button(
            onClick = onRegistrar,
            enabled = formularioValido
        ) {
            Text("Registrar")
        }

        Spacer(modifier = Modifier.height(10.dp))


        Button(
            onClick = onLimpiar
        ) {
            Text("Limpiar")
        }

        Spacer(modifier = Modifier.height(20.dp))


        if (mostrarResultado) {
            Text(
                text = resultado,
                color = if (formularioValido) Color(0xFF2E7D32) else Color.Red
            )
        }
    }
}