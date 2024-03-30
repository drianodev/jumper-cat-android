package com.drianodev.jumpercat.engine

import com.drianodev.jumpercat.elements.Passaro
import com.drianodev.jumpercat.elements.Pipes

class VerificadorDeColisao(private val passaro: Passaro?, private val canos: Pipes?) {
    fun temColisao(): Boolean {
        return canos!!.temColisaoCom(passaro!!)
    }
}