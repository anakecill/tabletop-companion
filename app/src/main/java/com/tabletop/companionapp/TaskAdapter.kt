package com.tabletop.companionapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.tabletop.companionapp.data.GlobalData
import com.tabletop.companionapp.data.Task
import com.tabletop.companionapp.databinding.PesananItemBinding
import kotlin.random.Random

class TaskAdapter(val listTask: MutableList<Task>, val playerIndex: Int): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    class TaskViewHolder(val binding: PesananItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = PesananItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = listTask[position]
        with(holder) {
            binding.imgPesanan.setImageResource(task.image)
            binding.buttonClaim.setOnClickListener {
                addScore(task, playerIndex)
                GlobalData.players[playerIndex].taskCompleted += 1
                (itemView.context as PlayerActionActivity).showScore(playerIndex)
                Toast.makeText(itemView.context, "${task.name} claimed", Toast.LENGTH_SHORT).show()
                val tmpTask = GlobalData.allTasks[Random.nextInt(0,GlobalData.allTasks.size)]
                GlobalData.players[playerIndex].tasks[position] = tmpTask
                (itemView.context as PlayerActionActivity).showRecyclerView(playerIndex)
                if (GlobalData.players[playerIndex].taskCompleted >= 8) {
                    Toast.makeText(
                        itemView.context,
                        "${GlobalData.players[playerIndex].name} has completed 8 tasks",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            binding.buttonTrash.setOnClickListener {
                Toast.makeText(itemView.context, "${task.name} trashed", Toast.LENGTH_SHORT).show()
                val tmpTask = GlobalData.allTasks[Random.nextInt(0,GlobalData.allTasks.size)]
                GlobalData.players[playerIndex].tasks[position] = tmpTask
                (itemView.context as PlayerActionActivity).showRecyclerView(playerIndex)
            }
        }
    }

    override fun getItemCount(): Int {
        return if (GlobalData.players[playerIndex].level == 1) {
            3
        } else {
            5
        }
    }

    private fun addScore(task: Task, index: Int) {
        when (task.color) {
            "Red" -> GlobalData.players[index].point.redPoint += task.point
            "Green" -> GlobalData.players[index].point.greenPoint += task.point
            "Yellow" -> GlobalData.players[index].point.yellowPoint += task.point
            "Orange" -> GlobalData.players[index].point.orangePoint += task.point
            "Tosca" -> GlobalData.players[index].point.toscaPoint += task.point
            "Pink" -> GlobalData.players[index].point.pinkPoint += task.point
        }
    }
}