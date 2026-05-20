package com.example.parccial.data.local.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.parccial.data.local.entity.Partida
import kotlinx.coroutines.flow.Flow

/*en esta parte es mas que tod las consultas de la base de datos, es decir segun la consulta hace
 la funsion */
@Dao
interface PartidaDao {

    @Insert
    suspend fun insertar(partida: Partida)

    @Query("SELECT * FROM partidas ORDER BY id DESC")

    fun obtenerPartidas():
            Flow<List<Partida>>

    @Query("SELECT MAX(puntaje) FROM partidas")
    fun obtenerMayorPuntaje(): Flow<Int?>

}