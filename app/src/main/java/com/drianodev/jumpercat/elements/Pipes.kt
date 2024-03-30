package com.drianodev.jumpercat.elements

import android.content.Context
import android.graphics.Canvas
import com.drianodev.jumpercat.graphics.Tela

class Pipes(
    private val tela: Tela,
    private val pontuacao: Pontuacao,
    private val context: Context
) {
    private val canos: MutableList<Pipe> = ArrayList()

    init {
        var posicaoInicial = POSICAO_INICIAL
        for (i in 0 until QUANTIDADE_DE_CANOS) {
            posicaoInicial += DISTANCIA_ENTRE_CANOS
            canos.add(Pipe(tela, posicaoInicial, context))
        }
    }

    fun desenhaNo(canvas: Canvas) {
        for (cano in canos) cano.desenhaNo(canvas)
    }

    fun move() {
        val iterator = canos.listIterator()
        while (iterator.hasNext()) {
            val cano = iterator.next()
            cano.move()
            if (cano.saiuDaTela()) {
                pontuacao.aumenta()
                iterator.remove()
                val outroCano = Pipe(
                    tela, maximo + DISTANCIA_ENTRE_CANOS, context
                )
                iterator.add(outroCano)
            }
        }
    }

    val maximo: Int
        get() {
            var maximo = 0
            for (cano in canos) {
                maximo = Math.max(cano.posicao, maximo)
            }
            return maximo
        }

    fun temColisaoCom(passaro: Passaro): Boolean {
        for (cano in canos) {
            if (cano.temColisaoHorizontalCom(passaro) && cano.temColisaoVerticalCom(passaro)) {
                return true
            }
        }
        return false
    }

    companion object {
        private const val QUANTIDADE_DE_CANOS = 5
        private const val POSICAO_INICIAL = 400
        private const val DISTANCIA_ENTRE_CANOS = 250
    }
}