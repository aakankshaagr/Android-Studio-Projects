package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.coroutines.EmptyCoroutineContext.plus

class MainActivity : AppCompatActivity() {
    lateinit var Exp: TextView
    lateinit var Result: TextView
    lateinit var Clear: TextView
    lateinit var One: TextView
    lateinit var Two: TextView
    lateinit var Three: TextView
    lateinit var Four: TextView
    lateinit var Five: TextView
    lateinit var Six: TextView
    lateinit var Seven: TextView
    lateinit var Eight: TextView
    lateinit var Nine: TextView
    lateinit var Zero: TextView
    lateinit var Divi: TextView
    lateinit var Mult: TextView
    lateinit var Sub: TextView
    lateinit var Add: TextView
    lateinit var Equal: TextView
    lateinit var Point: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Exp=findViewById(R.id.expression)
        Result=findViewById(R.id.result)
        Clear=findViewById(R.id.clear)
        One=findViewById(R.id.one)
        Two=findViewById(R.id.two)
        Three=findViewById(R.id.three)
        Four=findViewById(R.id.four)
        Five=findViewById(R.id.five)
        Six=findViewById(R.id.six)
        Seven=findViewById(R.id.seven)
        Eight=findViewById(R.id.eight)
        Nine=findViewById(R.id.nine)
        Zero=findViewById(R.id.zero)
        Divi=findViewById(R.id.div)
        Mult=findViewById(R.id.mul)
        Sub=findViewById(R.id.sub)
        Add=findViewById(R.id.add)
        Equal=findViewById(R.id.eq)
        Point=findViewById(R.id.dot)

        One.setOnClickListener {
            pressButton("1")
        }
        Two.setOnClickListener {
            pressButton("2")
        }
        Three.setOnClickListener {
            pressButton("3")
        }
        Four.setOnClickListener {
            pressButton("4")
        }
        Five.setOnClickListener {
            pressButton("5")
        }
        Six.setOnClickListener {
            pressButton("6")
        }
        Seven.setOnClickListener {
            pressButton("7")
        }
        Eight.setOnClickListener {
            pressButton("8")
        }
        Nine.setOnClickListener {
            pressButton("9")
        }
        Zero.setOnClickListener {
            pressButton("0")
        }
        Divi.setOnClickListener {
            pressButton("/")
        }
        Mult.setOnClickListener {
            pressButton("*")
        }
        Sub.setOnClickListener {
            pressButton("-")
        }
        Add.setOnClickListener {
            pressButton("+")
        }
        Clear.setOnClickListener {
            pressButton("clear")
        }
        Point.setOnClickListener {
            pressButton(".")
        }
        Clear.setOnClickListener {
            Result.text=" "
            Exp.text=" "
        }
        Equal.setOnClickListener {
            try {
                val text = Exp.text.toString()
                val expression: Expression = ExpressionBuilder(text).build()
                val expression_result = expression.evaluate()
                Result.text = expression_result.toString()
            }
            catch(e:Exception)
            {
                Result.text="Error"
            }
        }
    }
    fun pressButton(s:String)
    {
        Result.text = " "
        Exp.append(s)
    }
}