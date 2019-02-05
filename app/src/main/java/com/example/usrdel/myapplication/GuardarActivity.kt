package com.example.usrdel.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_registrar.*

class GuardarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        btnAceptar.setOnClickListener { aceptar() }
        btnCancelar.setOnClickListener { cancelar() }
    }

    fun aceptar(){
        val url = "http://192.168.100.8:1337/actor"
        val actor = Actor(nombres= txtNombre.text.toString(), apellidos = txtApellidos.text.toString(),
                            fechaNacimiento = txtFechaNacimiento.text.toString(), numeroPeliculas = txtNumPeliculas.text.toString(), retirado = "")
        val parametro = listOf("nombres" to actor.nombres,
                                "apellidos" to actor.apellidos,
                                "fechaNacimiento" to actor.fechaNacimiento,
                                "numeroPeliculas" to actor.numeroPeliculas,
                                "retirado" to actor.retirado)
        url.httpPost(parametro).responseString { request, response, result ->
            when(result){
                is Result.Failure ->{
                    val exepcion = result.getException()
                    Toast.makeText(this, "Error:${exepcion}", Toast.LENGTH_SHORT).show()
                }
                is Result.Success ->{
                    Alerter.create(this@GuardarActivity)
                            .setTitle("Registro")
                            .setText("Actor Guardado con éxito")
                            .setBackgroundColorRes(R.color.colorPrimary)
                            .show()
                }
            }
        }
        txtNombre.setText("")
        txtApellidos.setText("")
        txtFechaNacimiento.setText("")
        txtNumPeliculas.setText("")
    }

    fun cancelar(){
        txtNombre.setText("")
        txtApellidos.setText("")
        txtFechaNacimiento.setText("")
        txtNumPeliculas.setText("")
    }
}
