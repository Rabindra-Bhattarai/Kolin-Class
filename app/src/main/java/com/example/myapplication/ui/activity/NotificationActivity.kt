package com.example.myapplication.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityNotificationBinding
import com.example.myapplication.ui.fragment.HomeFragment
import com.example.myapplication.ui.fragment.SearchFragment

class NotificationActivity : AppCompatActivity() {
    lateinit var binding: ActivityNotificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set listener for bottom navigation view
        binding.bottomsView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navHome -> replaceFragment(HomeFragment())
                R.id.navSearch -> replaceFragment(SearchFragment())
                else -> {}
            }
            true
        }

        // Adjust padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bottomsView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Move replaceFragment outside onCreate
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainFragment, fragment)
        fragmentTransaction.commit()
    }
}
