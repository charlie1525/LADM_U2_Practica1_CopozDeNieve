package mx.edu.ittepic.ladm_u2_practica1_copozdenieve

class ElEfecto {
    var posX = 0f; var tamaño = 0f; var posY = 0f
    var estado = true

    init {
        posY= (Math.random()*-580).toFloat()
        posX = ((Math.random()*1280)).toFloat()
        tamaño = ((Math.random()*6)+5).toFloat()
        estado = true
    }

    fun LaNevadaEfecto(){
        posY +=((Math.random() * 10) + 20).toFloat()
        if (posY >= 800) estado = false
    }
}