package com.example.parccial.ui.screens

import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.example.parccial.ui.content.JuegoContent
import com.example.parccial.viewmodel.JuegoViewModel

//en esta parte se ve la logica que hay en lo que seria la parte del juego como tal
@Composable
fun JuegoScreen(
    navController: NavController,
    viewModel: JuegoViewModel
){
    LaunchedEffect(Unit) {
        viewModel.iniciarJuego()
    }

    LaunchedEffect(viewModel.tiempo) {
        if (viewModel.tiempo == 0) {
            navController.navigate("resultado")
        }
    }

    JuegoContent(
        puntaje = viewModel.puntaje,
        tiempo = viewModel.tiempo,
        colorActual = viewModel.colorActual,
        mensaje = viewModel.mensaje,
        //ve si esta bien o no
        onRespuesta={
            viewModel.verificarColor(it)
        }
    )
}