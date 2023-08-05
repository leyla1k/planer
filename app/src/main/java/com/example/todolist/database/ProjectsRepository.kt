package com.example.todolist.database

import com.example.todolist.entities.ProjectEntity

class ProjectsRepository(val dao:ProjectsDao) {

    suspend fun addNewProject(projectEntity:ProjectEntity){
        dao.insertNewProject(projectEntity)
    }
    suspend fun deleteNewProject(projectEntity:ProjectEntity){
        dao.deleteNewProject(projectEntity)
    }
}