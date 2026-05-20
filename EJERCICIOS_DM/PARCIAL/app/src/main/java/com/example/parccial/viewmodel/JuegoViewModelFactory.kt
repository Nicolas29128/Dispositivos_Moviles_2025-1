package com.example.parccial.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.parccial.data.local.DAO.PartidaDao
import com.example.parccial.utils.PreferenceManager
/*en esta parte se puede decir que en necesria porque se comunica con el juego viewmodel y asi le
envia lo que seria la base de datos y preferencias*/
class JuegoViewModelFactory(
    //se guardan las dependecias como lo es la partida y el maximo puntaje
    private val dao:PartidaDao,
    private val preferences:PreferenceManager
):ViewModelProvider.Factory{

    //en esta parte sirve para crear y devolver el viewmodel correcto
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ):T{

        //comprueba si es el que se pide asi evitamos cerar objetos equivocados
        if(modelClass.isAssignableFrom(JuegoViewModel::class.java))
        {
            @Suppress("UNCHECKED_CAST")

            //permite el acceso a lo que seria la base de datos, historial, mayor porcentaje
            return JuegoViewModel(
                dao,
                preferences
            ) as T
        }
        //para el manejo de un posible error
        throw IllegalArgumentException(
            "ViewModel desconocido"
        )
    }
}