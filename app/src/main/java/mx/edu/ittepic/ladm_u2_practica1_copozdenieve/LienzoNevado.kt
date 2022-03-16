package mx.edu.ittepic.ladm_u2_practica1_copozdenieve

import android.graphics.*
import android.provider.Settings
import android.view.MotionEvent
import android.view.View
import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.random.Random

class LienzoNevado(ActMain: MainActivity) : View(ActMain) {

    // declaracion de variables
    val actPrincipal = ActMain
    val fondoApp = BitmapFactory.decodeResource(actPrincipal.resources, R.drawable.fondoapp)
    var contador = 0f
    var efecto = ArrayList<ElEfecto>()
    var nevada = ArrayList<ElEfecto>()

    val scope = CoroutineScope(Job() + Dispatchers.Main)
    val objNevada = scope.launch(
        EmptyCoroutineContext,
        CoroutineStart.LAZY
    ) { actPrincipal.runOnUiThread { laNevada.start() } }


    //inicio del metodo onDraw
    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val general = Paint()
        val ajusteAlto = 140f
        actPrincipal.setTitle("Ancho: ${width}, Alto: ${height}")
        c.drawColor(Color.BLACK)
        c.drawBitmap(fondoApp, 0f, 0f, general)


        //-------------------------------------------------- bloque para los ovalos del piso --------------------------------------------------
        val ovaloPiso = Paint(); ovaloPiso.isAntiAlias = true
        val colorPiso = Color.rgb(169, 141, 141)
        ovaloPiso.setColor(colorPiso)
        c.drawOval(-140f, 300 + ajusteAlto, 600f, 600 + ajusteAlto, ovaloPiso)
        c.drawOval(340f, 230 + ajusteAlto, 1100f, 720 + ajusteAlto, ovaloPiso)
        c.drawOval(900f, 270 + ajusteAlto, 1600f, 550f + ajusteAlto, ovaloPiso)

        // -------------------------------------------------- bloque de los arboles --------------------------------------------------
        // ------------------------------- primer arbol a la derecha ----------------------------
        val arbolTronco = Paint(); arbolTronco.isAntiAlias = true
        val arbolHojas = Paint(); arbolHojas.isAntiAlias = true

        // ----------------- Tronco del arbol 1 -------------------------
        arbolTronco.setColor(Color.rgb(77, 60, 60))
        c.drawRect(61f, 495f - ajusteAlto, 118f, 620f - ajusteAlto, arbolTronco)

        // ----------------- Hojas del arbol 1 -------------------------
        arbolHojas.setColor(Color.rgb(128, 181, 131))
        c.drawOval(7f, 431 - ajusteAlto, 180f, 517 - ajusteAlto, arbolHojas)
        c.drawOval(7f, 369 - ajusteAlto, 180f, 455 - ajusteAlto, arbolHojas)
        c.drawOval(7f, 307 - ajusteAlto, 180f, 393 - ajusteAlto, arbolHojas)

        // ------------------------------- segundo arbol en medio ----------------------------
        // ----------------- Tronco del arbol 2 -------------------------
        arbolTronco.setColor(Color.rgb(77, 60, 60))
        c.drawRect(514f, 470f - ajusteAlto, 551f, 562f - ajusteAlto, arbolTronco)

        // ----------------- Hojas del arbol 2 -------------------------
        arbolHojas.setColor(Color.rgb(128, 181, 131))
        c.drawOval(481f, 449 - ajusteAlto, 576f, 490 - ajusteAlto, arbolHojas)
        c.drawOval(481f, 422 - ajusteAlto, 576f, 463 - ajusteAlto, arbolHojas)
        c.drawOval(481f, 389 - ajusteAlto, 576f, 430 - ajusteAlto, arbolHojas)

        // ------------------------------- tercer arbol de enfrente ----------------------------
        // ----------------- Tronco del arbol 3 -------------------------
        arbolTronco.setColor(Color.rgb(77, 60, 60))
        c.drawRect(1190f, 602 - ajusteAlto, 1390f, 900f - ajusteAlto, arbolTronco)

        // ----------------- Hojas del arbol 3 -------------------------
        arbolHojas.setColor(Color.rgb(128, 181, 131))
        c.drawOval(1111f, 539 - ajusteAlto, 1411f, 639 - ajusteAlto, arbolHojas)
        c.drawOval(1111f, 467 - ajusteAlto, 1411f, 567 - ajusteAlto, arbolHojas)
        c.drawOval(1111f, 395 - ajusteAlto, 1411f, 495 - ajusteAlto, arbolHojas)

        // -------------------------------------------------- bloque de la casa --------------------------------------------------

        val pared = Paint()
        val chimenea = Paint()
        val ventana = Paint()
        val puerta = Paint()
        val techo = Paint()
        val humo = Paint()

        pared.isAntiAlias = true;puerta.isAntiAlias = true;chimenea.isAntiAlias = true
        ventana.isAntiAlias = true;techo.isAntiAlias = true;humo.isAntiAlias = true

        puerta.setColor(Color.rgb(156, 101, 101));techo.setColor(Color.rgb(97, 58, 103))
        pared.setColor(Color.rgb(222, 91, 245));humo.setColor(Color.rgb(142, 132, 132))
        chimenea.setColor(Color.rgb(54, 28, 28)); ventana.setColor(Color.rgb(23, 157, 147))

        //Dibujo de la pared principal de la casa
        c.drawRect(645f, 427f - ajusteAlto, 1042f, 607 - ajusteAlto, pared)
        //Dibujo de la puerta
        c.drawRect(673f, 505 - ajusteAlto, 733f, 607 - ajusteAlto, puerta)
        //Ventana
        c.drawRect(791f, 505 - ajusteAlto, 989f, 540 - ajusteAlto, ventana)
        //Dibujo ed la chimenea
        c.drawRect(672f, 325 - ajusteAlto, 715f, 390 - ajusteAlto, chimenea)
        //Dibujo del techo
        c.drawRect(625f, 377 - ajusteAlto, 1060f, 461 - ajusteAlto, techo)
        drawTriangle(c, techo, 625f, 420 - ajusteAlto, 80)
        drawTriangle(c, techo, 1060f, 420 - ajusteAlto, 80)

        //dibujo del humo
        c.drawOval(685f, 288 - ajusteAlto, 721f, 314 - ajusteAlto, humo)
        c.drawOval(712f, 251 - ajusteAlto, 755f, 285 - ajusteAlto, humo)
        c.drawOval(740f, 209 - ajusteAlto, 817f, 251 - ajusteAlto, humo)

        //  ----------------------------------------------- Sección de la nevada --------------------------------------------

        val nieve = Paint()
        nieve.setColor(Color.WHITE)
        nevada.forEach {
            c.drawCircle(it.posX, it.posY, it.tamaño, nieve)
        }
        objNevada.start()
    }// final del onDraw

/*    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {objNevada.start()} // fin del Action event
            }// fin del when
        }
        return true
    } // fin del on touch event*/

    public fun drawTriangle(c: Canvas, p: Paint, x: Float, y: Float, ancho: Int) {
        val halfWidth = ancho / 2
        val triangulo = Path()

        triangulo.moveTo(x, y - halfWidth)
        triangulo.lineTo(x - halfWidth, y + halfWidth)
        triangulo.lineTo(x + halfWidth, y + halfWidth)
        triangulo.moveTo(x, y - halfWidth)
        triangulo.close()

        c.drawPath(triangulo, p)
    }

    // seccion de metodos fuera de la clase
    fun contadorTiempoNevada() = GlobalScope.launch {
        var thisContador = 0f
        while (laNevada.isAlive) {
            thisContador++
        }
        delay((Math.random() * 550).toLong())
        contador = thisContador
    }

    val laNevada = NevadaEfecto(this, contador)
} // fin de la clase Lienzo

class NevadaEfecto(este: LienzoNevado, banderaNevado: Float) : Thread() {
    private val aquel = este
    private var nevadaIntenso = banderaNevado
    var ejecutar = true
    var pausado = false
    override fun run() {
        super.run()
        while (ejecutar) {
            if (!pausado) {
                when (nevadaIntenso.toInt()) {
                    in 1..300 -> {
                        aquel.nevada.forEach {
                            it.LaNevadaEfecto()
                        }
                        if (true) {
                            (1..20).forEach { _ ->
                                val copo = ElEfecto()
                                aquel.efecto.add(copo)
                            }
                        }
                        aquel.nevada.addAll(aquel.efecto)
                        aquel.efecto.clear()
                        aquel.nevada.removeIf { a -> !a.estado }
                        aquel.actPrincipal.runOnUiThread() {
                            aquel.invalidate()
                        }
                        sleep(80)
                        nevadaIntenso = 0f
                    } // fin del primer caso

                    in 301..500 -> {
                        aquel.nevada.forEach {
                            it.LaNevadaEfecto()
                        }
                        if (true) {
                            (1..105).forEach { _ ->
                                val copo = ElEfecto()
                                aquel.efecto.add(copo)
                            }
                        }
                        aquel.nevada.addAll(aquel.efecto)
                        aquel.efecto.clear()
                        aquel.nevada.removeIf { a -> !a.estado }
                        aquel.actPrincipal.runOnUiThread() {
                            aquel.invalidate()
                        }
                        sleep(80)
                        nevadaIntenso = 0f
                    } // fin del segundo caso

                    else -> {
                        aquel.nevada.forEach {
                            it.LaNevadaEfecto()
                        }
                        if (true) {
                            (1..280).forEach { _ ->
                                val copo = ElEfecto()
                                aquel.efecto.add(copo)
                            }
                        }
                        aquel.nevada.addAll(aquel.efecto)
                        aquel.efecto.clear()
                        aquel.nevada.removeIf { a -> !a.estado }
                        aquel.actPrincipal.runOnUiThread() {
                            aquel.invalidate()
                        }
                        sleep(80)
                        nevadaIntenso = 0f

                    }// fin de ultimo caso
                }// fin del when}

            }
        } // fin del while para la ejecucion
        fun estaPausado(): Boolean {return pausado}
        fun enEjecucion(): Boolean {return ejecutar}
        fun pausar(){pausado = !pausado}
        fun terminar(){ejecutar= false}
    } // fin de la clase del hilo para manejar
}// fin de la clase del hilo