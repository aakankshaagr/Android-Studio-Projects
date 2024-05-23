package com.example.login_signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.room.Room
import com.example.login_signup.Data.AppDatabase


class SignupActivity : AppCompatActivity() {
    private lateinit var user:EditText
    private lateinit var password:EditText
    private lateinit var btn:Button
    private lateinit var link: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        user=findViewById(R.id.signup_user)
        password=findViewById(R.id.signup_password)
        btn=findViewById(R.id.signup_btn)
        link=findViewById(R.id.login_link)
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "Users"
        ).build()
        val userDao = db.userDAO()
        btn.setOnClickListener {
val tempUser=userDao.insertUser(user,password)
        }
    }
}