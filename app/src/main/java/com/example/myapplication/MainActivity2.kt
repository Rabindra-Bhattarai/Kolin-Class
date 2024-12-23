package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    lateinit var Mango:RadioButton
    lateinit var Apple: RadioButton
    lateinit var Orange: RadioButton
    lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        Mango =findViewById(R.id.btnMango)
        Apple =findViewById(R.id.btnApple)
        Orange=findViewById(R.id.btnOrange)
        image=findViewById(R.id.imageViewRadio)
        Mango.setOnClickListener{
            image.setImageResource(R.drawable.mango)
        }

        Apple.setOnClickListener{
            image.setImageResource(R.drawable.apple)
        }

        Orange.setOnClickListener{
            image.setImageResource(R.drawable.orange)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cityID)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}