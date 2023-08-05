package com.example.todolist.ui.projectRV

import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.entities.Project
import com.example.todolist.databinding.ItemProjectBinding

class ProjectsViewHolder(val binding: ItemProjectBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: Project) {
        with(/*this.*/binding) {
    textViewName.text = item.name
    textViewDate.text = item.date.toString()
        }
    }
}