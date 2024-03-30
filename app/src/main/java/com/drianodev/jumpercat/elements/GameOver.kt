package com.drianodev.jumpercat.elements

import android.graphics.Canvas
import android.graphics.Rect
import android.widget.Button
import com.drianodev.jumpercat.graphics.Cores
import com.drianodev.jumpercat.graphics.Tela

class GameOver(private val tela: Tela) {
    private val reiniciarButton: Button? = null
    fun desenhaNo(canvas: Canvas) {
        val gameOver = "Game Over"
        val centroHorizontal = centralizaTexto(gameOver)
        canvas.drawText(gameOver, centroHorizontal.toFloat(), (tela.altura / 2).toFloat(), VERMELHO)
    }

    private fun centralizaTexto(texto: String): Int {
        val limiteDoTexto = Rect()
        VERMELHO.getTextBounds(texto, 0, texto.length, limiteDoTexto)
        return tela.largura / 2 - (limiteDoTexto.right - limiteDoTexto.left) / 2
    }

    companion object {
        private val VERMELHO = Cores.corDoGameOver
    }
}