package com.drianodev.jumpercat.elements

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import com.drianodev.jumpercat.R
import com.drianodev.jumpercat.engine.Som
import com.drianodev.jumpercat.graphics.Tela

class Passaro(private val tela: Tela, context: Context) {
    private val passaro: Bitmap
    private val som: Som
    var altura = 0

    init {
        altura = 100
        val bp = BitmapFactory.decodeResource(context.resources, R.drawable.passaro)
        passaro = Bitmap.createScaledBitmap(bp, RAIO * 2, RAIO * 2, false)
        som = Som(context)
    }

    fun desenhaNo(canvas: Canvas) {
        //canvas.drawCircle(X, getAltura(), RAIO, vermelho);
        canvas.drawBitmap(passaro, (X - RAIO).toFloat(), (altura - RAIO).toFloat(), null)
    }

    fun cai() {
        val checouNoChao = altura + RAIO > tela.altura
        if (!checouNoChao) {
            altura = altura + 5
        }
    }

    fun pula() {
        if (altura > RAIO) {
            altura = altura - 150
            som.tocaSom(Som.PULO)
        }
    }

    companion object {
        const val X = 100
        const val RAIO = 80
    }
}