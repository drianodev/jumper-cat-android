package com.drianodev.jumpercat.graphics

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

class Tela(context: Context) {
    private val metrics: DisplayMetrics

    init {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        metrics = DisplayMetrics()
        display.getMetrics(metrics)
    }

    val altura: Int
        get() = metrics.heightPixels
    val largura: Int
        get() = metrics.widthPixels
}