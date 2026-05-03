package com.example.ejercicio_1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ejercicio_1.screems.FormularioScreen
import com.example.ejercicio_1.screems.ListaScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lista"
    ){
        composable("lista"){
            ListaScreen(navController)
        }
        composable("formulario"){
            FormularioScreen(navController)
        }
    }
}