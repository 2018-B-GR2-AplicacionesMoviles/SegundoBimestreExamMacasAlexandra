package com.example.usrdel.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCrear.setOnClickListener { crearTienda() }
        btnListar.setOnClickListener{ listarTienda() }
    }

    fun crearTienda(){
        var intentCrear= Intent(this, GuardarActivity::class.java)
        startActivity(intentCrear)
    }
    fun listarTienda(){
        var intentListar= Intent(this, MostrarActivity::class.java)
        startActivity(intentListar)
    }
}
