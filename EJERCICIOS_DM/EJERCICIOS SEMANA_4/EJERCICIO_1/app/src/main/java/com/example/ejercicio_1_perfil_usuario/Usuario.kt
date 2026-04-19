package com.example.ejercicio_1_perfil_usuario

import java.io.Serializable
/* creamos un data class para despues poder guardar y enviar estos datos para que sea de cierta
   forma ordenada y mas simple */
data class Usuario(
    val nombre: String,
    val edad: String,
    val ciudad: String,
    val correo: String
) : Serializable
