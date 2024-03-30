package com.drianodev.jumpercat.graphics

import android.graphics.Paint
import android.graphics.Typeface

object Cores {
    val corDoPassaro: Paint
        get() {
            val vermelho = Paint()
            vermelho.color = -0x10000
            return vermelho
        }
    val corDoCano: Paint
        get() {
            val verde = Paint()
            verde.color = -0xff0100
            return verde
        }
    val corDaPontuacao: Paint
        get() {
            val branco = Paint()
            branco.color = -0x1
            branco.textSize = 80f
            branco.typeface = Typeface.DEFAULT_BOLD
            branco.setShadowLayer(3f, 5f, 5f, -0x1000000)
            return branco
        }
    val corDoGameOver: Paint
        get() {
            val vermelho = Paint()
            vermelho.color = -0x10000
            vermelho.textSize = 50f
            vermelho.typeface = Typeface.DEFAULT_BOLD
            vermelho.setShadowLayer(2f, 3f, 3f, -0x1000000)
            return vermelho
        }
}