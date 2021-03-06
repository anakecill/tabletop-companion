package com.tabletop.companionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tabletop.companionapp.data.GlobalData
import com.tabletop.companionapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonStart.setOnClickListener {
            startActivity(Intent(this ,InputNameActivity::class.java))
        }

        GlobalData.players.clear()
        binding.buttonExit.setOnClickListener { finish() }
    }

    override fun onResume() {
        super.onResume()
        GlobalData.players.clear()
    }
}