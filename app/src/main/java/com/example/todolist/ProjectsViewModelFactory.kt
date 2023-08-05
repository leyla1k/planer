package com.example.todolist

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.database.ProjectsRepository


class ProjectsViewModelFactory(
val projectsRepository: ProjectsRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T: ViewModel> create(modelClass:Class<T>): T {
        return ProjectsViewModel(projectsRepository) as T
    }
}