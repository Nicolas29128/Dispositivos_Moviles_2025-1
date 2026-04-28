package com.example.ejercicio_

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejercicio_.ui.theme.EJERCICIO_Theme
import com.example.ejercicio_.ui.screens.FormularioScreem

/* DESCRIPCION: en el siguiente ejercico nos pide realizar una mejora al formulario trabajado en
   clase, este debe tener validaciones y agragar componentes en mi caso use (radiobutton, checkbox,
   switch y slider).
 AUTOR: Franco Nicolás Rojas Castro
 FECHA: 26/04/2026
 ULTIMA MODIFICACION: 27/04/2026
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormularioScreem()
        }
        /*setContent {
            EJERCICIO_Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }*/
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EJERCICIO_Theme {
        FormularioScreem()
    }
}