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
            binding.buttonClaim.setOnClickListener {
                GlobalData.players[playerIndex].point.redPoint += 1
                (itemView.context as PlayerActionActivity).showScore(playerIndex)
                Toast.makeText(itemView.context, "${task.name} claimed", Toast.LENGTH_SHORT).show()
            }
            binding.buttonTrash.setOnClickListener {
                Toast.makeText(itemView.context, "${task.name} trashed", Toast.LENGTH_SHORT).show()
                val tmpTask = GlobalData.allTasks[Random.nextInt(0,GlobalData.allTasks.size)]
                GlobalData.players[playerIndex].tasks[position] = tmpTask
                (itemView.context as PlayerActionActivity).showRecyclerView(playerIndex)
            }
        }
    }

    override fun getItemCount(): Int = listTask.size
}