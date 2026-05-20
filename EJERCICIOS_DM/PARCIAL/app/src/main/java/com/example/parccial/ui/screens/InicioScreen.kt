package com.example.parccial.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.parccial.ui.content.InicioContent
//en esta parte es para ver la conexion entre el inicio  y el juego
@Composable
fun InicioScreen(navController: NavController)
{
    InicioContent(
        onStart={
            navController.navigate("juego")
        }
    )

}