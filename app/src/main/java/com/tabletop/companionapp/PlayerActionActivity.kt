package com.tabletop.companionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        setContentView(binding.root)
        showScore(playerIndex)

        binding.rvTask.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTask.setHasFixedSize(true)
        showRecyclerView(playerIndex)
    }

    private fun showRecyclerView(player: Int) {
        binding.rvTask.adapter = TaskAdapter(GlobalData.players[player].tasks, playerIndex)
    }

    public fun showScore(player: Int) {
        binding.textGreenCardPoint.text = GlobalData.players[player].point.greenPoint.toString()
        binding.textRedCardPoint.text = GlobalData.players[player].point.redPoint.toString()
        binding.textYellowCardPoint.text = GlobalData.players[player].point.yellowPoint.toString()
        binding.textPinkCardPoint.text = GlobalData.players[player].point.pinkPoint.toString()
        binding.textToscaCardPoint.text = GlobalData.players[player].point.toscaPoint.toString()
        binding.textOrangeCardPoint.text = GlobalData.players[player].point.orangePoint.toString()
    }
}