package com.example.ejercicio_1.content

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ejercicio_1.components.UsuarioItem
import com.example.ejercicio_1.model.Usuario

@Composable
fun ListaContent(
    usuarios : List<Usuario>,
    padding: PaddingValues,
    onEliminar : (Usuario) -> Unit,
    onFavorito : (Usuario)-> Unit
){

    //respecto a lo anteior y hecho en clase, solo se le agrego lo que seria la funcion onFavorito
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ){
        items(usuarios){
            usuario -> UsuarioItem(usuario, onEliminar, onFavorito)
        }
    }

}