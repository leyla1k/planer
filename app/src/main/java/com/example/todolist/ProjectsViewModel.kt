package com.example.todolist

import androidx.lifecycle.ViewModel
import com.example.todolist.database.ProjectsRepository
import com.example.todolist.entities.Project
import com.example.todolist.entities.ProjectEntity

class ProjectsViewModel(val projectsRepository: ProjectsRepository) : ViewModel() {

    suspend fun addNewProject(project: Project){
        projectsRepository.addNewProject(fromProjectsToProjectsEntity(project))
    }

    suspend fun deleteNewProject(project: Project){
        projectsRepository.deleteNewProject(fromProjectsToProjectsEntity(project))
    }
}