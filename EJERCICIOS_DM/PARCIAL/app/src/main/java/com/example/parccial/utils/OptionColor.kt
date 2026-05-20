package com.example.parccial.utils

import androidx.compose.ui.graphics.Color

/*en esta parte solo ponemos los datos y valores que tendra el juego,
en est caso los colores*/
data class OpcionColor(
    val nombre:String,
    val color:Color

)

val coloresJuego=listOf(

    OpcionColor(
        "ROJO",
        Color.Red
    ),
    OpcionColor(
        "AZUL",
        Color.Blue
    ),
    OpcionColor(
        "VERDE",
        Color.Green
    ),
    OpcionColor(
        "AMARILLO",
        Color.Yellow
    ),
    OpcionColor(
        "MAGENTA",
        Color.Magenta
    )
)