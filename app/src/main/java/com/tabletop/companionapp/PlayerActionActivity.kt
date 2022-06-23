package com.tabletop.companionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.tabletop.companionapp.data.GlobalData
import com.tabletop.companionapp.data.Task
import com.tabletop.companionapp.databinding.ActivityPlayerActionBinding

class PlayerActionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayerActionBinding
    var playerIndex = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerActionBinding.inflate(layoutInflater)
        binding.tvNameAction.text = GlobalData.players[playerIndex].name
        setContentView(binding.root)
        showScore(playerIndex)
        countTask(playerIndex)

        binding.rvTask.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTask.setHasFixedSize(true)
        showRecyclerView(playerIndex)

        binding.btnUpdateWagon.setOnClickListener {
            if (GlobalData.players[playerIndex].level < 2) {
                GlobalData.players[playerIndex].level += 1
                showRecyclerView(playerIndex)
                Toast.makeText(this, "Wagon updated", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this, "Max level reached", Toast.LENGTH_SHORT).show()
        }

        binding.btnNextPlayer.setOnClickListener {
            if (playerIndex + 1 >= 4) {
                playerIndex = 0
            } else {
                playerIndex += 1
            }
            binding.tvNameAction.text = GlobalData.players[playerIndex].name
            showRecyclerView(playerIndex)
            showScore(playerIndex)
        }
    }

    fun showRecyclerView(player: Int) {
        binding.rvTask.adapter = TaskAdapter(GlobalData.players[player].tasks, playerIndex)
    }

    fun showScore(player: Int) {
        binding.textGreenCardPoint.text = GlobalData.players[player].point.greenPoint.toString()
        binding.textRedCardPoint.text = GlobalData.players[player].point.redPoint.toString()
        binding.textYellowCardPoint.text = GlobalData.players[player].point.yellowPoint.toString()
        binding.textPinkCardPoint.text = GlobalData.players[player].point.pinkPoint.toString()
        binding.textToscaCardPoint.text = GlobalData.players[player].point.toscaPoint.toString()
        binding.textOrangeCardPoint.text = GlobalData.players[player].point.orangePoint.toString()
        countTask(player)
    }

    private fun countScore(player: Int) {
        val total = GlobalData.players[player].point.greenPoint + GlobalData.players[player].point.redPoint +
                GlobalData.players[player].point.yellowPoint + GlobalData.players[player].point.pinkPoint +
                GlobalData.players[player].point.toscaPoint + GlobalData.players[player].point.orangePoint
        binding.textTotalPesanan.text = total.toString()
    }

    fun countTask(player: Int) {
        binding.textTotalPesanan.text = GlobalData.players[player].taskCompleted.toString()
    }
}