package com.tabletop.companionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tabletop.companionapp.data.GlobalData
import com.tabletop.companionapp.data.Player
import com.tabletop.companionapp.databinding.ActivityInputNameBinding
import kotlin.random.Random

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

            val character1 = randomNumber(null)
            val character2 = randomNumber(listOf(character1))
            val character3 = randomNumber(listOf(character1, character2))
            val character4 = randomNumber(listOf(character1, character2, character3))

            val task1 = mutableListOf(
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)],
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)],
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)],
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)],
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)]
            )

            val task2 = mutableListOf(
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)],
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)],
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)],
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)],
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)]
            )

            val task3 = mutableListOf(
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)],
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)],
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)],
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)],
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)]
            )

            val task4 = mutableListOf(
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)],
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)],
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)],
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)],
                GlobalData.allTasks[Random.nextInt(0, GlobalData.allTasks.size)]
            )

            GlobalData.players.add(Player(player1, GlobalData.characters[character1], task1))
            GlobalData.players.add(Player(player2, GlobalData.characters[character2], task2))
            GlobalData.players.add(Player(player3, GlobalData.characters[character3], task3))
            GlobalData.players.add(Player(player4, GlobalData.characters[character4], task4))

            startActivity(Intent(this, PlayerActionActivity::class.java))
        }
    }

    private fun randomNumber(selectedNumbers: List<Int>?): Int {
        var number = Random.nextInt(0, 6)
        if (selectedNumbers != null)  {
            var tempNumber = Random.nextInt(0, 6)
            var isSame: Boolean = false
            for (num in selectedNumbers) {
                if (tempNumber == num) {
                    isSame = true
                    break
                }
            }
            if (isSame) {
                tempNumber = randomNumber(selectedNumbers)
            }
            number = tempNumber
        }
        return number
    }
}