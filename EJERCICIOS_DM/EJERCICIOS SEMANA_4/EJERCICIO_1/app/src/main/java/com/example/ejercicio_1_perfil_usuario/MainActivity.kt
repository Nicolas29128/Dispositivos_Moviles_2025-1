package com.example.ejercicio_1_perfil_usuario
/* DESCRIPCION: la app llenar como un perfil de usuario con nombre, edad, ciudad y correo; despues
   de hacer esto se presiona un boton de continuar, y en otra pantalla nos debe mostrar el resumen
   de tod lo que se ingreso y con esto se muestra de bajo dos botones, uno de editar lo que se
   introdujo y otro de confirmar.
   AUTOR: Franco Nicolás Rojas Castro
   FECHA: 18/04/2026
   ULTIMA MODIFICACION: 18/04/2026
 */

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/*declaramos la varibles "nombre, edad, ciudad, btncontinuar, y usamos lateninit porque las
  inicializaresmos despues "*/
class MainActivity : AppCompatActivity() {
    private lateinit var nombre: EditText
    private lateinit var edad: EditText
    private lateinit var ciudad: EditText
    private lateinit var correo: EditText
    private lateinit var btnContinuar: Button

    /**/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        /*creamos la variable luncher para poder abrir la otra actividad y recibir su respuesta.
          precisamente en la accion del if cuando se confirma es donde nos muestra el mensaje de "se
          guardo correctamente"*/
        val launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Perfil guardado correctamente", Toast.LENGTH_SHORT).show()
            }
        }

        /*en esta parte es donde inicializamos las variables y las iniciazliazmos conectando con el
          xml asi interactuar con ella  */
        nombre = findViewById(R.id.nombre)
        edad = findViewById(R.id.edad)
        ciudad = findViewById(R.id.ciudad)
        correo = findViewById(R.id.correo)
        btnContinuar = findViewById(R.id.continuar)

        /*es esta parte decimos cuando el se preciones el boton de "Continuar " se va a extraer en
          cada variable lo que el usuario puso respectivamenete. Creamos usuario para poder tener
          todos de la clase usuario en uno para asi facilitar el uso */
        btnContinuar.setOnClickListener {

            val nombre = nombre.text.toString()
            val edad = edad.text.toString()
            val ciudad = ciudad.text.toString()
            val correo = correo.text.toString()

            val usuario = Usuario(nombre, edad, ciudad, correo)
            /*se crea intent para decir que usaremos la otra actividad "Resumen" y se enviara lo es
                usuario a esa actividad "Resumen"*/
            val intent = Intent(this, ResumenActivity2::class.java)
            intent.putExtra("usuario", usuario)

            launcher.launch(intent)
        }
    }

    /*sobre escribimos la funcion para poder guardar los datos en el caso que se gire la aplicacion*/
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nombre", nombre.text.toString())
        outState.putString("edad", edad.text.toString())
        outState.putString("ciudad", ciudad.text.toString())
        outState.putString("correo", correo.text.toString())
    }

}
