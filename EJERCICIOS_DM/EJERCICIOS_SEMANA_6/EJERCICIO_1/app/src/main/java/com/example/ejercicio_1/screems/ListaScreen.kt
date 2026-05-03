package com.example.ejercicio_1.screems

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.ejercicio_1.content.ListaContent
import com.example.ejercicio_1.model.Usuario

@Composable
fun ListaScreen(
    navController: NavController
){
    var usuarios by remember { mutableStateOf(listOf<Usuario>(
        Usuario("Juan", "999111222"),
        Usuario("Pedro", "987654321"),
        Usuario("Luis", "912345678")
    )) }

    Scaffold(
        /*creo lo que seria un boton de agrgar usuario y cuando le das click te manda a la pantalla
          donde llenas un nuevo usuario*/
        floatingActionButton = {
            FloatingActionButton(
                onClick = {navController.navigate("formulario")}) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Agregar"
                )
            }
        }
    ) {
        padding ->

        //creo la variable listaOrdenada para poner el contacto favorito primero
        val listaOrdenada = usuarios.sortedByDescending { it.favorito }

        ListaContent(
            usuarios = listaOrdenada,
            padding,
            // en esta parte es donde se elima el contacto, crea una nueva lista sin ese contacto
            onEliminar = { usuario ->
                usuarios = usuarios.filter { it != usuario }
            },

            /* en esta parte cuando precionar el boton de favorito, crea una buena lista ordenada
               poniendo ese favorito al inicio*/
            onFavorito = { usuario ->
                usuarios = usuarios.map {
                    if (it == usuario){
                        it.copy(favorito = !it.favorito)
                    }else it
                }
            }
        )

    }

}