package com.example.dial_me


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var b0: Button
    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button
    private lateinit var b5: Button
    private lateinit var b6: Button
    private lateinit var b7: Button
    private lateinit var b8: Button
    private lateinit var b9: Button

    private lateinit var star: Button
    private lateinit var hash: Button
    private lateinit var call: Button
    private lateinit var save: Button
    private lateinit var clear: Button
    private lateinit var contact: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b0=findViewById(R.id.b0)
        b1=findViewById(R.id.b1)
        b2=findViewById(R.id.b2)
        b3=findViewById(R.id.b3)
        b4=findViewById(R.id.b4)
        b5=findViewById(R.id.b5)
        b6=findViewById(R.id.b6)
        b7=findViewById(R.id.b7)
        b8=findViewById(R.id.b8)
        b9=findViewById(R.id.b9)

        star=findViewById(R.id.star)
        hash =findViewById(R.id.hash)

        call=findViewById(R.id.call)
        save=findViewById(R.id.save)
        contact=findViewById(R.id.contact)
        clear=findViewById(R.id.clear)
        b0.setOnClickListener {
            pressbutton("0",true)
        }
        b1.setOnClickListener {
            pressbutton("1",true)
        }
        b2.setOnClickListener {
            pressbutton("2",true)
        }
        b3.setOnClickListener {
            pressbutton("3",true)
        }
        b4.setOnClickListener {
            pressbutton("4",true)
        }
        b5.setOnClickListener {
            pressbutton("5",true)
        }
        b6.setOnClickListener {
            pressbutton("06",true)
        }
        b7.setOnClickListener {
            pressbutton("7",true)
        }
        b8.setOnClickListener {
            pressbutton("8",true)
        }
        b9.setOnClickListener {
            pressbutton("9",true)
        }
        star.setOnClickListener {
            pressbutton("*",true)
        }
        hash.setOnClickListener {
            pressbutton("#",true)
        }
        save.setOnClickListener {
           val intent = Intent(ContactsContract.Intents.SHOW_OR_CREATE_CONTACT, Uri.parse("tel:"+contact.text))
            intent.putExtra(ContactsContract.Intents.EXTRA_FORCE_CREATE,true)
            startActivity(intent)
        }
        call.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:"+"${contact.text}"))
            startActivity(intent)
        }
        clear.setOnClickListener {
            contact.text=""
        }


    }

    private fun pressbutton(s: String, clear: Boolean) {
            if(!clear)
            {
                contact.text=""
            }
            else
            {
                contact.append(s)
            }
    }
}