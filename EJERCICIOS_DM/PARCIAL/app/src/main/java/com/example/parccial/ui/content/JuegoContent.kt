package com.example.parccial.ui.content

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.example.parccial.ui.components.BotonColor
import com.example.parccial.ui.components.Puntaje
import com.example.parccial.utils.coloresJuego
import kotlinx.coroutines.delay

//en esta parte es para mostrar el puntaje, timepo, color, mensaje y lo que serian las opciones
@Composable
fun JuegoContent(
    puntaje:Int,
    tiempo:Int,
    colorActual:Int,
    mensaje:String,
    onRespuesta:(String)->Unit
){
    //para la parte de animacion mas que tod
    var agrandado by remember { mutableStateOf(false) }
    LaunchedEffect(colorActual) {
        agrandado = true
        delay(150)
        agrandado = false
    }

    val escala by animateFloatAsState(
        targetValue = if (agrandado) 1.15f else 1f,
        label = "escalaColor"
    )

    Column(
        modifier=
            Modifier
                .fillMaxSize()
                .padding(20.dp),

        horizontalAlignment=
            Alignment.CenterHorizontally

    ){

        //para mostrar la infromacion que hay en cada uno
        Puntaje(
            puntaje,
            tiempo
        )

        Spacer(Modifier.height(30.dp))

        //lo que seria el color principal
        Box(
            modifier =
                Modifier
                    .size(180.dp)
                    .scale(escala)
                    .background(

                        coloresJuego[colorActual].color,
                        RoundedCornerShape(
                            20.dp
                        )

                    )

        )
        Spacer(Modifier.height(20.dp))
        Text(
            text=mensaje,
            style = MaterialTheme.typography.titleLarge

        )

        Spacer(Modifier.height(30.dp))
        coloresJuego.forEach{

            BotonColor(
                texto = it.nombre,
                color = it.color
            ){
                onRespuesta(it.nombre)
            }
            Spacer(Modifier.height(10.dp))
        }
    }
}