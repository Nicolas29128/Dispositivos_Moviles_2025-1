package com.example.ejercicio_2
/* DESCRIPCION: en el siguiente ejercico nos pide realizar un tipo de repreoductor de musica, lo
   principal quedebe hacer es (reproducir, pausar y detener), estas funcianalidades seran botones;
   ademas agragar que le aumente algunas funcionalidades (atras, siguiente y aleatorio), tambien
   aumento un poco de diseño que seria una imagen de musica como referencia o para hacer alusion
   al fin del programa (para el diseño me base en lo que seria los dispositivos mp4 de antes xD).
 AUTOR: Franco Nicolás Rojas Castro
 FECHA: 11/04/2026
 ULTIMA MODIFICACION: 12/04/2026
 */

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    //se crea una variable que nos ayduara a contraolar lo que seria la musica
    private var mediaPlayer: MediaPlayer? = null
    //se crea una lista donde estaran las canciones que tenemos dentro raw, en este caso solo son 5
    private val canciones = listOf(
        R.raw.mi_suerte,
        R.raw.swim,
        R.raw.the_emptiness_machine,
        R.raw.como_si_no_importara,
        R.raw.ti_amo
    )
    /*creamos una variable "indieceActual" para ver la posison de la cancion en la lista
    creamos otra varable "psicionPausa" para que nos ayude al momento de pausar la musica y esta
    no se pierda*/
    private var indiceActual = 0
    private var posicionPausa = 0

    /*cramos variables para cada boton de la interfaz */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnReproducir = findViewById<Button>(R.id.btnreproducir)
        val btnPausar = findViewById<Button>(R.id.btnpausar)
        val btnDetener = findViewById<Button>(R.id.btndetener)
        val btnAleatorio = findViewById<Button>(R.id.btnaleatorio)
        val btnAtras = findViewById<Button>(R.id.btnatras)
        val btnSiguiente = findViewById<Button>(R.id.btnsiguiente)
        /*en esta parte se puede observar lo que seria la primera cancion y porque anteriormente
        se creo la variable indice ancual*/
        mediaPlayer = MediaPlayer.create(this, canciones[indiceActual])
        /* en esta aprte es donde diremos,si hacen clic al boton de play o reproducir, este
        continuara doende se quedeo */
        btnReproducir.setOnClickListener {
            mediaPlayer?.seekTo(posicionPausa)
            mediaPlayer?.start()
        }

        /* en esta aprte es donde diremos,si hacen clic al boton de pausa, este se guardara en el
        mismo segundo y asi no se pierda por asi decirlo.
        continuara doende se quedeo */
        btnPausar.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                posicionPausa = mediaPlayer!!.currentPosition
                mediaPlayer?.pause()
            }
        }

        /* en esta aprte es donde diremos,si hacen clic al boton de detener, este se detednra por
        completo y se liberara la memoria y asi empieza desde el inicio es decir desde la posicion
        0 o la cancion inicial*/
        btnDetener.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(this, canciones[indiceActual])
            posicionPausa = 0
        }

        /* en esta parte es donde diremos,si hacen clic al boton de aleatorio, este tomara una cancion
         que este en la lista al azar y luego la reproducira */
        btnAleatorio.setOnClickListener {
            mediaPlayer?.release()
            indiceActual = Random.nextInt(canciones.size)
            mediaPlayer = MediaPlayer.create(this, canciones[indiceActual])
            mediaPlayer?.start()
        }

        /* en esta parte es donde diremos,si hacen clic al boton de atras, este se retrocera una
        * cancion, en el caso que este este en la primera cancion, se retocesara por asi decirlo a
        * la ultima cancion */
        btnAtras.setOnClickListener {
            mediaPlayer?.release()
            indiceActual =
                if (indiceActual == 0) canciones.size - 1
                else indiceActual - 1
            mediaPlayer = MediaPlayer.create(this, canciones[indiceActual])
            mediaPlayer?.start()
        }

        /* en esta parte es donde diremos,si hacen clic al boton de siguiente, pasra algo similar
        como lo del boton para atras. Con la difrencia que este ira para delante y en el caso que
        este este en la ultima cancion o posicion este se volvera a al inicio, como lo seria y
        pasaria dentro de un bucle */
        btnSiguiente.setOnClickListener {
            mediaPlayer?.release()
            indiceActual = (indiceActual + 1) % canciones.size
            mediaPlayer = MediaPlayer.create(this, canciones[indiceActual])
            mediaPlayer?.start()
        }
    }

}