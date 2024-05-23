package com.example.counter

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    private lateinit var startButton: Button
    private lateinit var stopButton: Button
    private lateinit var resetButton: Button
    private lateinit var countView: TextView
    var counter:Int = 0
    private val timer =MyCounter(1000000, 1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.button1)
        stopButton=findViewById(R.id.button2)
        resetButton=findViewById(R.id.button3)
       countView=findViewById(R.id.countText)
        startButton.setOnClickListener{
            timer.start()
            startButton.isEnabled=false
            stopButton.isEnabled=true
        }
        stopButton.setOnClickListener {
            timer.cancel()
            stopButton.isEnabled=false
            startButton.isEnabled=true
        }
        resetButton.setOnClickListener{
            counter=0
            countView.text=counter.toString()
        }
    }
    inner class MyCounter(millisInFuture: Long,countDownInterval: Long):CountDownTimer(millisInFuture,countDownInterval) {
        override fun onTick(p0: Long) {
            counter++
            countView.text=counter.toString()
        }

        override fun onFinish() {

        }
    }
}


