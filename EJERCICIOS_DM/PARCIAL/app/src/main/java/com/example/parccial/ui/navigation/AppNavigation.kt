package com.example.parccial.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*

import com.example.parccial.ui.screens.InicioScreen
import com.example.parccial.ui.screens.JuegoScreen
import com.example.parccial.ui.screens.ResultadoScreen
import com.example.parccial.viewmodel.JuegoViewModel

//en esta parte se ve la navegacion entre pantallas
@Composable
fun AppNavigation(viewModel:JuegoViewModel)
{
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "bienvenida"
    ){

        composable("bienvenida")
        {
            InicioScreen(navController)
        }

        composable("juego")
        {
            JuegoScreen(
                navController,
                viewModel
            )
        }

        composable("resultado")
        {
            ResultadoScreen(
                navController,
                viewModel
            )
        }
    }
}