package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.ButtonActivity
import com.example.myapplication.DestinationActivity

class SplashActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
//remember me. in the splach screen if user already logged in then it will take us to dashbaord and if not it will take us to login file
        sharedPreferences =
            getSharedPreferences("userData",
                Context.MODE_PRIVATE)

        val username : String = sharedPreferences
            .getString("username","").toString()

        val password : String = sharedPreferences
            .getString("password","").toString()
//to here

        Handler(Looper.getMainLooper()).postDelayed({
            if(username.isEmpty()){
                val intent = Intent(this@SplashActivity,
                    ButtonActivity::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this@SplashActivity,
                    DestinationActivity::class.java)
                startActivity(intent)
            }

        },2000)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}