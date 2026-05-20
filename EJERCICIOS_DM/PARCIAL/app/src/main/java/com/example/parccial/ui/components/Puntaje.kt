package com.example.parccial.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
/* en esta parte es para mostara lo que seria el puntaje y el timepo restante es decir solo en la p
 l parte del juego*/
@Composable
fun Puntaje(
    puntaje:Int,
    tiempo:Int

){

    Card(
        modifier = Modifier.fillMaxWidth()
    ){
        Row(
            modifier=
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

            horizontalArrangement = Arrangement.SpaceBetween
        ){

            Text(
                text = "Puntaje: $puntaje",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "Tiempo: $tiempo",
                style = MaterialTheme.typography.titleMedium

            )
        }
    }
}