package com.example.parccial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.tooling.preview.Preview
import com.example.parccial.ui.navigation.AppNavigation
import com.example.parccial.ui.theme.ParccialTheme
import com.example.parccial.data.local.database.GameDatabase
import com.example.parccial.utils.PreferenceManager
import com.example.parccial.viewmodel.JuegoViewModel
import com.example.parccial.viewmodel.JuegoViewModelFactory

/* DESCRIPCION: en el siguiente ejercico nos pide crear un juego basico de relacionar colores, es
                nos muestra un color y segun ese tenemos que presionar el boton de ese color y
                tambien tiene su nombre del color.
 AUTOR: Franco Nicolás Rojas Castro
 FECHA: 19/05/2026
 ULTIMA MODIFICACION: 19/05/2026
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val database = GameDatabase.getDatabase(this)
        val dao = database.partidaDao()
        val preferences = PreferenceManager(this)

        setContent {
            ParccialTheme {
                val viewModel: JuegoViewModel = viewModel(
                    factory = JuegoViewModelFactory(
                        dao,
                        preferences
                    )
                )
                AppNavigation(viewModel)
            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ParccialTheme {

    }
}