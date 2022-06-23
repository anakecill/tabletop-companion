package com.tabletop.companionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tabletop.companionapp.data.GlobalData
import com.tabletop.companionapp.databinding.ActivityFinalScoreBinding
import com.tabletop.companionapp.databinding.ActivityInputNameBinding

class FinalScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinalScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val player1 = GlobalData.players[0]
        binding.textViewPlayer1Final.text = player1.name
        binding.textRedCardPointPlayer1.text = player1.point.redPoint.toString()
        binding.textYellowCardPointPlayer1.text = player1.point.yellowPoint.toString()
        binding.textToscaCardPointPlayer1.text = player1.point.toscaPoint.toString()
        binding.textOrangeCardPointPlayer1.text = player1.point.orangePoint.toString()
        binding.textPinkCardPointPlayer1.text = player1.point.pinkPoint.toString()
        binding.textGreenCardPointPlayer1.text = player1.point.greenPoint.toString()

        val player2 = GlobalData.players[1]
        binding.textViewPlayer2Final.text = player2.name
        binding.textRedCardPointPlayer2.text = player2.point.redPoint.toString()
        binding.textYellowCardPointPlayer2.text = player2.point.yellowPoint.toString()
        binding.textToscaCardPointPlayer2.text = player2.point.toscaPoint.toString()
        binding.textOrangeCardPointPlayer2.text = player2.point.orangePoint.toString()
        binding.textPinkCardPointPlayer2.text = player2.point.pinkPoint.toString()
        binding.textGreenCardPointPlayer2.text = player2.point.greenPoint.toString()

        val player3 = GlobalData.players[2]
        binding.textViewPlayer3Final.text = player3.name
        binding.textRedCardPointPlayer3.text = player3.point.redPoint.toString()
        binding.textYellowCardPointPlayer3.text = player3.point.yellowPoint.toString()
        binding.textToscaCardPointPlayer3.text = player3.point.toscaPoint.toString()
        binding.textOrangeCardPointPlayer3.text = player3.point.orangePoint.toString()
        binding.textPinkCardPointPlayer3.text = player3.point.pinkPoint.toString()
        binding.textGreenCardPointPlayer3.text = player3.point.greenPoint.toString()

        val player4 = GlobalData.players[3]
        binding.textViewPlayer4Final.text = player4.name
        binding.textRedCardPointPlayer4.text = player4.point.redPoint.toString()
        binding.textYellowCardPointPlayer4.text = player4.point.yellowPoint.toString()
        binding.textToscaCardPointPlayer4.text = player4.point.toscaPoint.toString()
        binding.textOrangeCardPointPlayer4.text = player4.point.orangePoint.toString()
        binding.textPinkCardPointPlayer4.text = player4.point.pinkPoint.toString()
        binding.textGreenCardPointPlayer4.text = player4.point.greenPoint.toString()

        binding.imageViewPlayer1Final.setImageResource(GlobalData.showImage(player1.character))
        binding.imageViewPlayer2Final.setImageResource(GlobalData.showImage(player2.character))
        binding.imageViewPlayer3Final.setImageResource(GlobalData.showImage(player3.character))
        binding.imageViewPlayer4Final.setImageResource(GlobalData.showImage(player4.character))

        binding.buttonPlayAgain.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}