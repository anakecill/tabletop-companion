package com.tabletop.companionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tabletop.companionapp.data.GlobalData
import com.tabletop.companionapp.databinding.ActivityRandomCharacterBinding

class RandomCharacterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRandomCharacterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewNamePlayer1.text = GlobalData.players[0].name
        binding.textViewNamePlayer2.text = GlobalData.players[1].name
        binding.textViewNamePlayer3.text = GlobalData.players[2].name
        binding.textViewNamePlayer4.text = GlobalData.players[3].name

        binding.buttonLetsPlay.setOnClickListener {
            startActivity(Intent(this, PlayerActionActivity::class.java))
        }
    }
}