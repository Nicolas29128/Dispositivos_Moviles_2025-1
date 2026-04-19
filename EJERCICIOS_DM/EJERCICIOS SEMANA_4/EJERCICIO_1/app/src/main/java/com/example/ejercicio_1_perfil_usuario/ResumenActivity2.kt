package com.example.ejercicio_1_perfil_usuario

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResumenActivity2 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resumen2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /*creamos las variables para poder conectar el codigo con el xml "activity_resumen2"*/
        val txtResumen = findViewById<TextView>(R.id.txtResumen)
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmar)
        val btnEditar = findViewById<Button>(R.id.btnEditar)

        /*creamos "usuario para poder recibir lo que se mando desde la primera actividad"*/
        val usuario = intent.getSerializableExtra("usuario") as Usuario
        /*mostramos los datos de la data class usuario con los datos optenidos (se usa trimindent
          para elminar espacios, esto para darle un poco mas de estetica. )*/
        txtResumen.text = """
            Nombre: ${usuario.nombre}
            Edad: ${usuario.edad}
            Ciudad: ${usuario.ciudad}
            Correo: ${usuario.correo}
        """.trimIndent()

        /*decimos cuando se aprete el boton "Confirmar" entoces decimos que termino la segunda
          actividad */
        btnConfirmar.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        /*decimos cuando se aprete el boton "Editar" decimos que el usario quiere ediatr lo anterior
          escrito, y lo lleva a la pantalla principal de la app*/
        btnEditar.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}