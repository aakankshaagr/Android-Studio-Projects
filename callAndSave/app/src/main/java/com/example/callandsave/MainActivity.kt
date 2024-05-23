package com.example.callandsave

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button
    private lateinit var zero: Button
    private lateinit var star: Button
    private lateinit var hash: Button
    private lateinit var clear: Button
    private lateinit var call: Button
    private lateinit var save: Button
    private lateinit var title: TextView
    private lateinit var contact: TextView
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            one = findViewById(R.id.onebutton)
            two = findViewById(R.id.twobutton)
            three = findViewById(R.id.threebutton)
            four = findViewById(R.id.fourbutton)
            five = findViewById(R.id.fivebutton)
            six = findViewById(R.id.sixbutton)
            seven = findViewById(R.id.sevenbutton)
            eight = findViewById(R.id.eightbutton)
            nine = findViewById(R.id.ninebutton)
            zero = findViewById(R.id.zerobutton)
            star = findViewById(R.id.starbutton)
            hash = findViewById(R.id.hashbutton)
            call = findViewById(R.id.callbutton)
            save = findViewById(R.id.savebutton)
            clear = findViewById(R.id.clearbutton)
            title = findViewById(R.id.textView)
            contact = findViewById(R.id.textView2)

            clear.setOnClickListener {
                contact.text=" "
            }
            one.setOnClickListener {
                pressButton("1")
            }
            two.setOnClickListener {
                pressButton("2")
            }
            three.setOnClickListener {
                pressButton("3")
            }
            four.setOnClickListener {
                pressButton("4")
            }
            five.setOnClickListener {
                pressButton("5")
            }
            six.setOnClickListener {
                pressButton("6")
            }
            seven.setOnClickListener {
                pressButton("7")
            }
            eight.setOnClickListener {
                pressButton("8")
            }
            nine.setOnClickListener {
                pressButton("9")
            }
            zero.setOnClickListener {
                pressButton("0")
            }
            star.setOnClickListener {
                pressButton("*")
            }
            hash.setOnClickListener {
                pressButton("#")
            }
            call.setOnClickListener {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "${contact.text}"))
                startActivity(intent)
            }
            save.setOnClickListener {
                val intent = Intent(
                    ContactsContract.Intents.SHOW_OR_CREATE_CONTACT , Uri.parse("tel:" + contact.text))
                startActivity(intent)
            }
    }

    private fun pressButton(s: String) {
        contact.append(s)
    }
}