package com.example.parccial.utils

import android.content.Context

class PreferenceManager(
    context:Context
){
//en esta parte se guarda lo que seria el record mayor
    private val preferences = context.getSharedPreferences(
        "juego",
        Context.MODE_PRIVATE
        )

    fun guardarMayor(
        puntaje:Int
    ){
        if(puntaje>obtenerMayor()){
            preferences.edit()
                .putInt(
                    "record",
                    puntaje
                )
                .apply()
        }
    }


    fun obtenerMayor():Int{

        return preferences.getInt(
            "record",
            0
        )
    }
}