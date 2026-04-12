/* DESCRIPCION: En el siguiente ejercicio nos dice al tocar la imagen en este caso "Yoshi" nos
   salga un TOAST  donde nos muestre un mensaje "Hurra, Me llamo Yoshi" en este caso,
   adicinr que aparte por mi lado le aumente lo que seria un boton para que sune la voz
   de Yoshi (esta bajo el volumen :'v )
 AUTOR: Franco Nicolás Rojas Castro
 FECHA: 11/04/2026
 ULTIMA MODIFICACION: 11/04/2026
 */
package com.example.ejercicio_1

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* primero creamos dos variables uno que es para la interaccion con la imagen y el otro
           para lo que seria el boton de la voz, y la mariable mediapleyer es para el reproductor
            del sonido; agregar que para poner el sonido de la voz de Yoshi se tuvo que crear un
            nuevo directorio "raw" donde se puso la voz en mp3*/
        val imagen = findViewById<ImageView>(R.id.imagenPrueba1)
        val botonSonido = findViewById<Button>(R.id.btnSonido)
        val mediaPlayer = MediaPlayer.create(this, R.raw.voicy_yoshi)

        /* en esta aparte nos ayuda a la interaccion con el click cuando se le da a la imagen y
        nos muestra el toast */
        imagen.setOnClickListener {
            Toast.makeText(this, getString(R.string.mensaje_img1), Toast.LENGTH_LONG).show()
        }

        /* en esta aparte nos ayuda a la interaccion con el click del boton se le da al boton y este
        nos reproduce lo que seria la voz del personaje "Yoshi" (el audio esta bajo porfe:( )*/
        botonSonido.setOnClickListener {
            mediaPlayer.start()
        }

    }
}