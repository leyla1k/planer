package com.example.todolist.ui.alertDialogs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.ProjectsViewModel
import com.example.todolist.database.ProjectsRepository

class NewProjectDialogViewModelFactory (
    val projectsRepository: ProjectsRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T: ViewModel> create(modelClass:Class<T>): T {
        return NewProjectDialogViewModel(projectsRepository) as T
    }
}