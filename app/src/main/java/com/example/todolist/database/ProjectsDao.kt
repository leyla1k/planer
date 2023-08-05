package com.example.todolist.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todolist.entities.ProjectEntity

@Dao
interface ProjectsDao {

  /*  @Query("SELECT * FROM projects_database")
    suspend fun getAll(): List<ProjectEntity?>?

    @Query("SELECT * FROM projects_database WHERE id = :id")
    suspend fun getById(id: Long): ProjectEntity?*/

    @Insert
    suspend fun insertNewProject(projectEntity: ProjectEntity)
    @Update
    suspend fun updateNewProject(projectEntity: ProjectEntity)


    @Delete
    suspend fun deleteNewProject(projectEntity: ProjectEntity)
}