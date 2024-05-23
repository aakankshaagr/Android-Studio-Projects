package com.example.phonedialer

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var delB: TextView
    private lateinit var callB: TextView
    private lateinit var saveB: TextView

    private lateinit var BZero: TextView
    private lateinit var B1: TextView
    private lateinit var B2: TextView
    private lateinit var B3: TextView
    private lateinit var B4: TextView
    private lateinit var B5: TextView
    private lateinit var B6: TextView
    private lateinit var B7: TextView
    private lateinit var B8: TextView
    private lateinit var B9: TextView
    private lateinit var BStar: TextView
    private lateinit var BHash: TextView

    private lateinit var pNo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        B1 = findViewById(R.id.B1)
        B2 = findViewById(R.id.B2)
        B3 = findViewById(R.id.B3)
        B4 = findViewById(R.id.B4)
        B5= findViewById(R.id.B5)
        B6 = findViewById(R.id.B6)
        B7= findViewById(R.id.B7)
        B8 = findViewById(R.id.B8)
        B9 = findViewById(R.id.B9)
        BZero = findViewById(R.id.B0)
        BStar = findViewById(R.id.BStar)
        BHash = findViewById(R.id.BHash)
        callB = findViewById(R.id.BCall)
        saveB = findViewById(R.id.BSave)
        delB = findViewById(R.id.delB)
        pNo = findViewById(R.id.pnoB)
        pNo.text = ""

        B1.setOnClickListener(){pressButton("1")}
        B2.setOnClickListener(){pressButton("2")}
        B3.setOnClickListener(){pressButton("6")}
        B4.setOnClickListener(){pressButton("4")}
        B5.setOnClickListener(){pressButton("5")}
        B6.setOnClickListener(){pressButton("6")}
        B7.setOnClickListener(){pressButton("7")}
        B8.setOnClickListener(){pressButton("8")}
        B9.setOnClickListener(){pressButton("9")}
        BZero.setOnClickListener(){pressButton("0")}
        BStar.setOnClickListener(){pressButton("*")}
        BHash.setOnClickListener(){pressButton("#")}
        delB.setOnClickListener()
        {
            pNo.text = ""
        }
        callB.setOnClickListener(){
            try{
                val i = Intent(Intent.ACTION_CALL, Uri.parse("tel:"+pNo.text))
                startActivity(i);
            }
            catch (e: Exception)
            {
                pNo.text = ""
                pNo.append("Error")
            }
        }
        saveB.setOnClickListener(){
            val i = Intent(ContactsContract.Intents.SHOW_OR_CREATE_CONTACT, Uri.parse("tel:"+pNo.text))
            startActivity(i);
        }
    }
    private fun pressButton(s: String){
        pNo.append(s)
    }



}