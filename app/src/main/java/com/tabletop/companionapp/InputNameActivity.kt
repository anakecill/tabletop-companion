package com.tabletop.companionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tabletop.companionapp.databinding.ActivityInputNameBinding

class InputNameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputNameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSubmit.setOnClickListener { submitPlayers() }
    }

    private fun submitPlayers() {
        if (binding.editTextNamePlayer1.text.isEmpty()) {
            binding.editTextNamePlayer1.error = "Please enter Player 1 name"
        } else if (binding.editTextNamePlayer2.text.isEmpty()) {
            binding.editTextNamePlayer2.error = "Please enter Player 2 name"
        } else if (binding.editTextNamePlayer3.text.isEmpty()) {
            binding.editTextNamePlayer3.error = "Please enter Player 3 name"
        } else if (binding.editTextNamePlayer4.text.isEmpty()) {
            binding.editTextNamePlayer4.error = "Please enter Player 4 name"
        } else {
            val player1 = binding.editTextNamePlayer1.text.toString()
            val player2 = binding.editTextNamePlayer2.text.toString()
            val player3 = binding.editTextNamePlayer3.text.toString()
            val player4 = binding.editTextNamePlayer4.text.toString()


        }
    }
}