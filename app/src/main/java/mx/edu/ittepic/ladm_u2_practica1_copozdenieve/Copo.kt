package mx.edu.ittepic.ladm_u2_practica1_copozdenieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Copo (lienzo : LienzoNevado){
    //Variables de definicion del copo
    private var posX = 0f; private var tamano = 0f; var posY = 0f;var dy = 0f; var dx = 0f
    private var localColor  = Color.WHITE

    //Variables de control del copo
    var linLocal = lienzo;var dentroCanvas = true


    init {
        posY= randomIn(130,719)
        posX = genRandom(1280)
        tamano = randomIn(3,8)
        dy = genRandom(6)+2
        dx = genRandom(6)+2
        localColor = Color.WHITE
    }

    fun nevando(){
        posY += dy
        posX += dx
        if (posY>linLocal.height || posY<0) dentroCanvas = false
        else if (posX>linLocal.width || posX<0) dentroCanvas = false

    }

    fun pintarseLaCara(c: Canvas){
        var pintura = Paint()
        pintura.color = localColor
        c.drawCircle(posX,posY,tamano,pintura)
    }

    private fun genRandom(until: Int):Float{
        return Random.nextInt(until).toFloat()
    }

    fun randomIn(min:Int, max:Int): Float {
        return Random.nextInt((max - min + 1) + min).toFloat()
    }

    fun acelerar(){
        dy*=7
        dx*=7
        if (posY>linLocal.height || posY<0) dentroCanvas = false
        else if (posX>linLocal.width || posX<0) dentroCanvas = false
    }

}