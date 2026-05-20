package com.example.parccial.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parccial.data.local.DAO.PartidaDao
import com.example.parccial.data.local.entity.Partida
import com.example.parccial.utils.PreferenceManager
import com.example.parccial.utils.coloresJuego
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.random.Random
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/*en esta parte vemos como es el funcionamiento que hay, como es el puntaje, colores, los guardados
  de partida y lo qu eseria como el historial de las partidas*/

//en est parte usamos para cconservar los datos
class JuegoViewModel(
    private val dao: PartidaDao,
    private val preferences: PreferenceManager
):ViewModel(){


    var puntaje by mutableIntStateOf(0)
        private set


    var tiempo by mutableIntStateOf(30)
        private set

    var colorActual by mutableIntStateOf(0)
        private set

    var mensaje by mutableStateOf("")
        private set

    var mayorPuntaje by mutableIntStateOf(
        preferences.obtenerMayor()
    )
        private set

    //para evitar que existan multiples cronometros
    private var juegoIniciado=false

//para guardar el historial
    val historial= dao.obtenerPartidas().stateIn(
        scope=viewModelScope,
        started= SharingStarted.WhileSubscribed(),
        initialValue= emptyList()
        )


    init{
        generarColor()
    }

//aca se ve mejor lo que dije anteriormente de tener varios cronmetros
    fun iniciarJuego(){
        if(juegoIniciado)return
        juegoIniciado=true
        viewModelScope.launch{

            while(tiempo>0){
                delay(1000)
                tiempo--

            }
            guardarPartida()
        }
    }


    fun verificarColor(
        respuesta:String
    ){

        if(respuesta == coloresJuego[colorActual].nombre)
        {
            puntaje++
            mensaje="Correcto"
            generarColor()
        }
        else{
            mensaje="Incorrecto"
        }
        viewModelScope.launch {
            delay(800)
            mensaje = ""
        }
    }


    private fun generarColor(){
        colorActual=
            Random.nextInt(
                coloresJuego.size
            )
    }


    private fun guardarPartida(){

        viewModelScope.launch{

            val fechaActual = SimpleDateFormat(
                    "dd/MM/yyyy HH:mm",
                    Locale.getDefault()
                ).format(Date())


            dao.insertar(
                Partida(
                    puntaje=puntaje,
                    fecha=fechaActual
                )
            )
            preferences.guardarMayor(
                puntaje
            )
            mayorPuntaje=
                preferences.obtenerMayor()

        }
    }

    fun reiniciar(){
        puntaje=0
        tiempo=30
        mensaje=""
        juegoIniciado=false
        generarColor()
        juegoIniciado = false
        generarColor()
    }
}