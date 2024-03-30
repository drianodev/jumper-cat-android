package com.drianodev.jumpercat.engine

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.view.MotionEvent
import android.view.SurfaceView
import android.view.View
import android.view.View.OnTouchListener
import com.drianodev.jumpercat.R
import com.drianodev.jumpercat.elements.GameOver
import com.drianodev.jumpercat.elements.Passaro
import com.drianodev.jumpercat.elements.Pipes
import com.drianodev.jumpercat.elements.Pontuacao
import com.drianodev.jumpercat.graphics.Tela

class Game(private val context: Context) : SurfaceView(context), Runnable, OnTouchListener {
    private var isRunning = true
    private val holder = getHolder()
    private val tela: Tela
    private var background: Bitmap? = null
    private var canos: Pipes? = null
    private var canvas: Canvas? = null
    private var passaro: Passaro? = null
    private var pontuacao: Pontuacao? = null
    private var som: Som? = null

    init {
        tela = Tela(context)
        inicializaElementos()
        setOnTouchListener(this)
    }

    private fun inicializaElementos() {
        passaro = Passaro(tela, context)
        pontuacao = Pontuacao()
        canos = Pipes(tela, pontuacao!!, context)
        val back = BitmapFactory.decodeResource(resources, R.drawable.background)
        background = Bitmap.createScaledBitmap(back, back.width, tela.altura, false)
        //this.setBackgroundResource(R.drawable.background);
        som = Som(context)
    }

    override fun run() {
        while (isRunning) {
            if (!holder.surface.isValid) {
                continue
            }
            val canvas = holder.lockCanvas()
            canvas?.drawBitmap(background!!, 0f, 0f, null)
            passaro!!.desenhaNo(canvas)
            passaro!!.cai()
            canos!!.desenhaNo(canvas)
            canos!!.move()
            pontuacao!!.desenhaNo(canvas)
            if (VerificadorDeColisao(passaro, canos).temColisao()) {
                som!!.tocaSom(Som.Companion.COLISAO)
                GameOver(tela).desenhaNo(canvas)
                isRunning = false
            }
            holder.unlockCanvasAndPost(canvas)
        }
    }

    fun inicia() {
        isRunning = true
    }

    fun cancela() {
        isRunning = false
    }

    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
        passaro!!.pula()
        return false
    }
}