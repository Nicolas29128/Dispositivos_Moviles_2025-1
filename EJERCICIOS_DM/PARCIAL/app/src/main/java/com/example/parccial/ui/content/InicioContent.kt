package com.example.parccial.ui.content

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Games
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//esta parte sirve para mostrar tod lo que hay al inicio, similar a lo que es resultadosContent

@Composable
fun InicioContent(
    onStart:()->Unit

){

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(20.dp),

        verticalArrangement = Arrangement.Center,

        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            Icons.Default.Games,
            contentDescription="",
            modifier = Modifier.size(100.dp)
        )

        Spacer(Modifier.height(20.dp))
        Text(
            text="RELACIONA EL COLOR",
            style = MaterialTheme.typography.headlineLarge

        )

        Spacer(Modifier.height(20.dp))
        Text(text = "Presiona el color con el color.")

        Spacer(Modifier.height(10.dp))
        Text(text = "Tiene 30sec.")

        Spacer(Modifier.height(10.dp))
        Button(
            onClick = onStart
        ){
            Text("Iniciar")
        }
    }
}