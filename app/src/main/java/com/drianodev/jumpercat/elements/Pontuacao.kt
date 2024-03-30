package com.drianodev.jumpercat.elements

import android.graphics.Canvas
import com.drianodev.jumpercat.graphics.Cores

class Pontuacao {
    private var pontos = 0
    fun aumenta() {
        pontos++
    }

    fun desenhaNo(canvas: Canvas) {
        canvas.drawText(pontos.toString(), 100f, 100f, BRANCO)
    }

    companion object {
        private val BRANCO = Cores.corDaPontuacao
    }
}