package com.example.ejercicio_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejercicio_1.navigation.AppNavigation
import com.example.ejercicio_1.screems.FormularioScreen
import com.example.ejercicio_1.ui.theme.EJERCICIO_1Theme

/*DESCRIPCION: en el siguiente ejercico nos pide realizar, un registro de contactos o usuario que
  tenga nombre y telefono, y que esta lista de registro de contactos se puda poner favoritos que
  este este en orden del favorino al no favorito, ademas de un boton elimanar para eliminar el
  contacto; y tdo esto usando listas en jetpack compose y navegacion entre patallas.
  COMENTARIO EXTRA: reutilice el codigo anterior modificando y adecuando los datos para este problema
 AUTOR: Franco Nicolás Rojas Castro
 FECHA: 02/05/2026
 ULTIMA MODIFICACION: 03/05/2026
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        AppNavigation()
        //FormularioScreen()
        }
        /*setContent {
            EJERCICIO_1Theme {
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
    EJERCICIO_1Theme {
        //FormularioScreen()
        AppNavigation()
    }
}