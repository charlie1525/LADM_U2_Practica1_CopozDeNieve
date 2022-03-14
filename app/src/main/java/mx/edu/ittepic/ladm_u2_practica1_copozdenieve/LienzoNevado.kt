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
        super.onDraw(c)
        var p = Paint()
        var ajusteAlto = 140f
        actPrincipal.setTitle("Ancho: ${width}, Alto: ${height}")

        c.drawColor(Color.WHITE)
        var colorPiso = Color.rgb(108,79,79)
        p.setColor(colorPiso)
        //c.drawCircle(280f,640f,3400f,p)
        c.drawOval(-140f,290+ajusteAlto,400f,720+ajusteAlto,p)




    }
}