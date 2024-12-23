package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityButtonBinding

//class ButtonActivity : AppCompatActivity() {
//
//    lateinit var binding: ActivityButtonBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//
//        binding= ActivityButtonBinding.inflate(layoutInflater)//binding
//        setContentView(binding.root)//binding changed
//
//
//        if (binding.editUsername.text.isEmpty()){
//            binding.editUsername.error="field cant be empty"
//        }else if (binding.editPassword.text.isEmpty()){
//            binding.editPassword.error="password cant be empty"
//
//        }else{
//            val intent=Intent(this@ButtonActivity, DestinationActivity::class.java)
//            val username :String=binding.editUsername.text.toString()
//            val password :String=binding.editPassword.text.toString()
//
//                                    //key       value
//            intent.putExtra("username",username)
//            intent.putExtra("password",password)
//            startActivity(intent)
//
//        }
//
//
//
//        binding.btnLogin.setOnClickListener {
//            val intent= Intent(this@ButtonActivity, RecycleActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
//}



class ButtonActivity : AppCompatActivity() {
    lateinit var binding : ActivityButtonBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)



        sharedPreferences=getSharedPreferences("userData", Context.MODE_PRIVATE)




        binding.btnLogin.setOnClickListener {


            val username: String = binding.editUsername.text.toString()
            val password: String = binding.editPassword.text.toString()

            if(username.isEmpty()){
                binding.editUsername.error = "username can't be empty"
            }else if(password.isEmpty()){
                binding.editPassword.error = "password can't be empty"
            }else{
                if (binding.editCheckBox.isChecked){
                    val editor=sharedPreferences.edit()
                    editor .putString("username", username  )
                    editor.putString("password", password)

                    editor.apply()
                }
                val intent = Intent(this@ButtonActivity,
                    DestinationActivity::class.java)


                //key      //value
                intent.putExtra("username",username)
                intent.putExtra("password",password)
                startActivity(intent)
            }

        }


        binding.btnLogin.setOnClickListener {
           val intent = Intent(this@ButtonActivity,
               RecycleActivity::class.java)
            startActivity(intent)
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}