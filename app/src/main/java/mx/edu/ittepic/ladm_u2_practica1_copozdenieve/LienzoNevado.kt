package mx.edu.ittepic.ladm_u2_practica1_copozdenieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class LienzoNevado(ActMain : MainActivity) : View(ActMain) {

    // declaracion de variables
    var actPrincipal = ActMain

    //inicio del metodo onDraw
    override fun onDraw(c: Canvas) {

        var p = Paint()
        var equis : Float = x
        var ye: Float = y
        actPrincipal.setTitle("Ancho: ${equis}, Alto: ${ye}")

        p.setColor(Color.GREEN)



        super.onDraw(c)
    }
}