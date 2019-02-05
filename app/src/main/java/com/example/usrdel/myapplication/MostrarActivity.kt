package com.example.usrdel.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.tapadoo.alerter.Alerter


class MostrarActivity : AppCompatActivity() {
    lateinit var array: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)
        val listView = findViewById(R.id.lstView) as ListView
        array = arrayOf("Jackie Chan", "Zac Efron", "Jennifer Aliston", "Madonna Tevez", "Arnold Shuazneger", "Cristiano Ronaldo", "Adam Sandler")
        llenar()
        val adp = ArrayAdapter(this@MostrarActivity, android.R.layout.simple_list_item_1, array)
        listView.adapter = adp
        registerForContextMenu(listView)
    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu!!.setHeaderTitle("Select Option")
        menu.add(0, v!!.id, 0, "Editar")
        menu.add(0, v.id, 1, "Eliminar")
        menu.add(0, v.id, 2, "Listar Peliculas")
        menu.add(0, v.id, 3, "Compartir")
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val selectedItemOrder = item!!.order
        val selectedItemTitle = item.title
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val listPosition = info.position
        val name = array[listPosition]
        when(listPosition){
            1 -> Log.i("hola", "jpña")
            2 -> Alerter.create(this@MostrarActivity)
                    .setTitle("Eliminación")
                    .setText("Actor Eliminada con éxito")
                    .setBackgroundColorRes(R.color.colorAccent)
                    .show()
            3-> Log.i("hola", "jpña")
            4-> {
                val webIntent = Intent(Intent.ACTION_SEND)
                webIntent.setType("image/*");
                startActivity(Intent.createChooser(webIntent, "Compartir!"));
            }
        }
        return true
    }






    fun llenar(){
        val url = "http://192.168.100.8:1337/actor"
         url.httpGet().responseString { request, response, result ->
             when(result){
                 is Result.Failure ->{
                     val exepcion = result.getException()
                 }
                 is Result.Success ->{
                     val responseTienda = result.get()

                     Toast.makeText(this, "${responseTienda}", Toast.LENGTH_SHORT).show()
                 }
             }
         }

    }
}
