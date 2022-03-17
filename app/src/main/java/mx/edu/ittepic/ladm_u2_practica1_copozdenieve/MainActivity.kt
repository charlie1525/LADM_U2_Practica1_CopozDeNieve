package mx.edu.ittepic.ladm_u2_practica1_copozdenieve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var lienzo : LienzoNevado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lienzo = LienzoNevado(this)
        setContentView(lienzo)
    }
}