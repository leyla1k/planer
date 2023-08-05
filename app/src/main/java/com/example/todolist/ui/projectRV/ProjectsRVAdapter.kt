package com.example.todolist.projectRV

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.todolist.databinding.ItemProjectBinding
import com.example.todolist.entities.Project
import java.util.Collections


class ProjectsRVAdapter() : ListAdapter<Project, ProjectsViewHolder>(ProjectsDiffCallback()),
    ProjectsItemTouchHelperAdapter {

    var onProjectClickListener: ((Project) -> Unit)? = null
    lateinit var projects: MutableList<Project>
    lateinit var itemProjectBinding: ItemProjectBinding
    fun submit(projects: MutableList<Project>) {
        this.projects = projects
        submitList(projects)
    }

    override fun onItemDismiss(position: Int) {
        projects.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(projects, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(projects, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsViewHolder {
        itemProjectBinding = ItemProjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProjectsViewHolder(itemProjectBinding)
    }


    override fun onBindViewHolder(holder: ProjectsViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item)
        with(holder.binding) {
            containerProject.setOnClickListener() {
                onProjectClickListener?.invoke(item)
            }
        }

    }

}