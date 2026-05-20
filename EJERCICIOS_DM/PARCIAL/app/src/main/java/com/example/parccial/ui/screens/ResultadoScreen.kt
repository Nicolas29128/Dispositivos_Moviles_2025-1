package com.example.parccial.ui.screens

import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.example.parccial.ui.content.ResultadoContent
import com.example.parccial.viewmodel.JuegoViewModel
// en esta parte sirve para ver lo que seria la parte de los reusltados y lo qu seria para reiniciar
@Composable
fun ResultadoScreen(
    navController: NavController,
    viewModel: JuegoViewModel
){

    val historial by viewModel.historial.collectAsState()

    ResultadoContent(
        puntaje = viewModel.puntaje,
        mayorPuntaje = viewModel.mayorPuntaje,
        historial = historial,
        onReplay = {
            viewModel.reiniciar()
            navController.navigate("juego")
        }
    )
}