package com.example.todolist.ui.alertDialogs

import androidx.lifecycle.ViewModel
import com.example.todolist.database.ProjectsRepository
import com.example.todolist.entities.Project
import com.example.todolist.fromProjectsToProjectsEntity

class NewProjectDialogViewModel(val projectsRepository: ProjectsRepository) : ViewModel(){

    suspend fun addNewProject(project: Project){
        projectsRepository.addNewProject(fromProjectsToProjectsEntity(project))
    }

}