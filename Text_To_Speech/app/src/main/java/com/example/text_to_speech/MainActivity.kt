package com.example.text_to_speech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var text1: EditText
    private lateinit var convertButton: Button
    private lateinit var textToSpeech: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text1= findViewById(R.id.userText)
        convertButton = findViewById(R.id.button)
        textToSpeech = TextToSpeech(this, this)
        convertButton.setOnClickListener {
            convertToSpeech();
        }
    }
    override fun onInit(status : Int){
        if(status == TextToSpeech.SUCCESS){
            val res = textToSpeech.setLanguage(Locale.US)
        }
        else
        {
            Log.e("TS","Initialisation Failure")
        }
    }
    private fun convertToSpeech(){
        val text = text1.text.toString()
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null)
    }

    override fun onDestroy() {
        if(textToSpeech!= null)
        {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
        super.onDestroy()
    }
}