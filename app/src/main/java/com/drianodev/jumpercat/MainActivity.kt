package com.drianodev.jumpercat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.drianodev.jumpercat.engine.Game

class MainActivity : AppCompatActivity() {

    private lateinit var game: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container: FrameLayout = findViewById(R.id.container)

        game = Game(this)
        container.addView(game)
    }

    override fun onResume() {
        super.onResume()
        game.inicia()
        Thread(game).start()
    }

    override fun onPause() {
        super.onPause()
        game.cancela()
    }
}