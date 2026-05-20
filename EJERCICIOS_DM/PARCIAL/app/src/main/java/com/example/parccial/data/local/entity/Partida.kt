package com.example.parccial.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="partidas")
//esta parte es solo los datos de la base de datos y la pk
data class Partida(
    val puntaje:Int,
    val fecha:String,

    @PrimaryKey(autoGenerate = true)
    val id:Int=0

)