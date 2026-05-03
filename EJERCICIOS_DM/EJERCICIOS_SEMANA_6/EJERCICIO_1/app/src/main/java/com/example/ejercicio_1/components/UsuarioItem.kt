package com.example.ejercicio_1.components
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ejercicio_1.model.Usuario

@Composable
fun UsuarioItem (
    usuario: Usuario,
    onEliminar: (Usuario) -> Unit,
    onFavorito: (Usuario) -> Unit) {

    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text(usuario.nombre)
                Text(usuario.telefono)
            }

            Row {
                /* creo lo que seria el boton del apartado de favoritos y uso el icno que hay por
                   defecto */
                IconButton(onClick = { onFavorito(usuario) }) {
                    /* en est parte es donde ponemos el icono de favorito (estrella), el cual cuando
                       se presione este se llenara, sino solo estara normal*/
                    Icon(
                        imageVector = if (usuario.favorito)
                            Icons.Default.Star
                        else
                            Icons.Default.StarBorder,
                        contentDescription = "Favorito"
                    )
                }

                // creo el boton elimnar que esta representado por el tachito de basura
                IconButton(onClick = { onEliminar(usuario) }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Eliminar"
                    )
                }
            }
        }
    }
}