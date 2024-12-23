package com.example.myapplication

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class UserInteractionActivity : AppCompatActivity() {
    lateinit var btnToast:Button
    lateinit var btnAlert:Button
    lateinit var btnSnack:Button
    lateinit var main:ConstraintLayout





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_interaction)

        btnToast=findViewById(R.id.toastButton)
        btnAlert=findViewById(R.id.alertButton)
        btnSnack=findViewById(R.id.snackButton)
        main=findViewById(R.id.cityID)

        btnToast.setOnClickListener{
            Toast.makeText(this@UserInteractionActivity,
            "Invalid Login",
            Toast.LENGTH_LONG
            ).show()
        }

        btnSnack.setOnClickListener{
            Snackbar.make(main,
                "No Internet Connection"
            ,Snackbar.LENGTH_LONG).setAction("Retry", {
            //logic-what happens when users click on retry
            }).show()

        }
        btnAlert.setOnClickListener{
            val alert = AlertDialog.Builder(this@UserInteractionActivity)
            alert.setTitle("Confirm")
                .setMessage("Are you sure?")
                .setIcon(R.drawable.apple)
                .setPositiveButton("Yes",DialogInterface.OnClickListener
                { dialogInterface, i ->
                    // when user click on yes - logic
                })
                .setNegativeButton("No",
                    DialogInterface.OnClickListener { dialogInterface, i ->
                        dialogInterface.dismiss()
                    })
            alert.create().show()
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cityID)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}