package com.drianodev.jumpercat.engine

import android.content.Context
import android.media.AudioManager
import android.media.SoundPool
import com.drianodev.jumpercat.R

class Som(context: Context?) {
    private val soundPool: SoundPool

    init {
        soundPool = SoundPool(3, AudioManager.STREAM_MUSIC, 0)
        PULO = soundPool.load(context, R.raw.pulo, 1)
        PONTOS = soundPool.load(context, R.raw.pontos, 1)
        COLISAO = soundPool.load(context, R.raw.colisao, 1)
    }

    fun tocaSom(som: Int) {
        soundPool.play(som, 1f, 1f, 1, 0, 1f)
    }

    companion object {
        var PULO: Int = 0
        var PONTOS: Int = 0
        var COLISAO: Int = 0
    }
}