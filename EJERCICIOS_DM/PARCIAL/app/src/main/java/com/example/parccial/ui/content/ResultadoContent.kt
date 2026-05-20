package com.example.parccial.ui.content

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.parccial.data.local.entity.Partida

//esta parte sirve para mostrar los reusltados finales, casi similar a juegoContent
@Composable
fun ResultadoContent(
    puntaje:Int,
    mayorPuntaje:Int,
    historial:List<Partida>,
    onReplay:()->Unit
){
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(20.dp)

    ){
        Text(
            "Final del juego",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(20.dp))
        Text("Puntaje: $puntaje")

        Text("Record: $mayorPuntaje")

        Spacer(Modifier.height(20.dp))
        Text("Historial")

        Spacer(Modifier.height(15.dp))
        LazyColumn{
            items(historial)
            {
                Card(
                    modifier=
                        Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                ){
                    Column(
                        modifier=
                            Modifier.padding(
                                15.dp
                            )
                    ){
                        Text("Puntaje: ${it.puntaje}")
                        Text(it.fecha)
                    }
                }
            }
        }

        Spacer(Modifier.height(20.dp))
        Button(
            onClick = onReplay,
            modifier = Modifier.fillMaxWidth()
        ){

            Text("Jugar de nuevo")
        }
    }
}