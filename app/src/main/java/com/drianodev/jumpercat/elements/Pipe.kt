package com.drianodev.jumpercat.elements

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import com.drianodev.jumpercat.R
import com.drianodev.jumpercat.graphics.Cores
import com.drianodev.jumpercat.graphics.Tela

class Pipe(private val tela: Tela, var posicao: Int, private val context: Context) {
    private val VERDE = Cores.corDoCano
    private val canoInferior: Bitmap
    private val canoSuperior: Bitmap
    private val passaro: Passaro? = null
    private val alturaDoCanoInferior: Int
    private val alturaDoCanoSuperior: Int

    init {
        alturaDoCanoInferior = tela.altura - TAMANHO_DO_CANO - valorAleatorio()
        alturaDoCanoSuperior = 0 + TAMANHO_DO_CANO + valorAleatorio()
        val bp = BitmapFactory.decodeResource(context.resources, R.drawable.cano)
        canoInferior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, alturaDoCanoInferior, false)
        canoSuperior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, alturaDoCanoSuperior, false)
    }

    private fun valorAleatorio(): Int {
        return (Math.random() * 150).toInt()
    }

    fun desenhaNo(canvas: Canvas) {
        desenhaCanoInferiorNo(canvas)
        desenhaCanoSuperiorNo(canvas)
    }

    private fun desenhaCanoSuperiorNo(canvas: Canvas) {
        // canvas.drawRect(posicao, 0,  posicao + LARGURA_DO_CANO,alturaDoCanoSuperior, VERDE);
        canvas.drawBitmap(canoSuperior, posicao.toFloat(), 0f, null)
    }

    private fun desenhaCanoInferiorNo(canvas: Canvas) {
        //canvas.drawRect(posicao, alturaDoCanoInferior,posicao + LARGURA_DO_CANO, tela.getAltura(), VERDE );
        canvas.drawBitmap(canoInferior, posicao.toFloat(), alturaDoCanoInferior.toFloat(), null)
    }

    fun move() {
        posicao -= 5
    }

    fun saiuDaTela(): Boolean {
        return posicao + LARGURA_DO_CANO < 0
    }

    fun temColisaoVerticalCom(passaro: Passaro): Boolean {
        return passaro.altura - Passaro.Companion.RAIO < alturaDoCanoSuperior ||
                passaro.altura + Passaro.Companion.RAIO > alturaDoCanoInferior
    }

    fun temColisaoHorizontalCom(passaro: Passaro?): Boolean {
        return posicao - Passaro.Companion.X < Passaro.Companion.RAIO
    }

    companion object {
        private const val TAMANHO_DO_CANO = 250
        private const val LARGURA_DO_CANO = 100
    }
}