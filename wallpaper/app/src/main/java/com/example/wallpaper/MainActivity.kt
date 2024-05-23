@file:Suppress("DEPRECATION")

package com.example.wallpaper

import android.app.WallpaperManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button


class MainActivity : AppCompatActivity() {
    private var wplist= arrayOf(R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5)
    private lateinit var change_wallpaper : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        change_wallpaper=findViewById(R.id.button)
        change_wallpaper.setOnClickListener { changeWallpaper() }

    }
    private fun changeWallpaper(){
        Handler().postDelayed({
            for (i in wplist){
                val manager=WallpaperManager.getInstance(baseContext)
                manager.setResource(i)
                Thread.sleep(3000)
            }},5000)
    }
}
