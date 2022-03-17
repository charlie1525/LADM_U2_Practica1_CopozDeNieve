package mx.edu.ittepic.ladm_u2_practica1_copozdenieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Copo (lienzo : LienzoNevado){
    //Variables de definicion del copo
    var posX = 0f; var tamaño = 0f; var posY = 0f;var dy = 0f
    var localColor  = Color.WHITE

    //Variables de control del copo
    var linLocal = lienzo;var dentroCanvas = true



    init {
        posY= randomIn(130,719)
        posX = genRandom(1280)
        tamaño = randomIn(3,8)
        dy = randomIn(2,8)
        localColor = Color.WHITE
    }

    fun nevando(){
        posY += dy
        if (posY>linLocal.height) dentroCanvas = false

    }

    fun pintarseLaCara(c: Canvas){
        var pintura = Paint()
        pintura.color = localColor
        c.drawCircle(posX,posY,tamaño,pintura)
    }

    private fun genRandom(until: Int):Float{
        return Random.nextInt(until).toFloat()
    }

    fun randomIn(min:Int, max:Int): Float {
        return Random.nextInt((max - min + 1) + min).toFloat()
    }

}