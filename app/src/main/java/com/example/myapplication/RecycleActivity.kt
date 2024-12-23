package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Grid
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a35b.adapter.FruitsAdapters

class RecycleActivity : AppCompatActivity() {

    lateinit var recci: RecyclerView
    var imageList=ArrayList<Int>()
    var fruitsTitle=ArrayList<String>()
    var fruitDesc=ArrayList<String>()
    lateinit var adapter: FruitsAdapters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle)


        recci=findViewById(R.id.review)
        imageList.add(R.drawable.orange)
        imageList.add(R.drawable.apple)
        imageList.add(R.drawable.mango)

        fruitsTitle.add("orange")
        fruitsTitle.add("apple")
        fruitsTitle.add("mango")

        fruitDesc.add("This is orange")
        fruitDesc.add("This is apple")
        fruitDesc.add("This is mango")


        adapter=FruitsAdapters(
            this@RecycleActivity,
            imageList, fruitsTitle,fruitDesc
        )

        recci.adapter= adapter
        //recci.layoutManager= LinearLayoutManager(this@RecycleActivity, LinearLayoutManager.HORIZONTAL, false)
        recci.layoutManager= GridLayoutManager(this@RecycleActivity,2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recyclerView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}