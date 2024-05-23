package com.example.login_signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    private lateinit var user: EditText
    private lateinit var password:EditText
    private lateinit var btn: Button
    private lateinit var link:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        user=findViewById(R.id.login_user)
        password=findViewById(R.id.login_password)
        btn=findViewById(R.id.login_btn)
        link=findViewById(R.id.signup_link)
    }
}

