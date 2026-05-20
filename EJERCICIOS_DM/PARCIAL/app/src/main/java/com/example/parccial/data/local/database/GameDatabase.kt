package com.example.parccial.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parccial.data.local.DAO.PartidaDao
import com.example.parccial.data.local.entity.Partida

//esta parte es para tipo decir que tablas existen
@Database(
    entities=[Partida::class],
    version=1,
    exportSchema=false
)

abstract class GameDatabase:
    RoomDatabase(){
    abstract fun partidaDao():
            PartidaDao
    companion object{
        /*en est aparte decimos que si existe una instancia la devuelve y si no pues la crea, no
          se puede repetir*/
        @Volatile
        private var INSTANCE:GameDatabase?=null
        fun getDatabase(context:Context):GameDatabase{
            return INSTANCE?: synchronized(this){
                    val instance = Room.databaseBuilder(
                        context,
                        GameDatabase::class.java,
                        "game_db"
                        ).build()

                    INSTANCE=instance
                    instance

            }
        }
    }
}