package com.example.todolist

import com.example.todolist.entities.Project
import com.example.todolist.entities.ProjectEntity
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Date




fun fromProjectsToProjectsEntity(project: Project):ProjectEntity {




    val inputDate = project.date

   return ProjectEntity(
        id = project.id,
        name = project.name,
        date = inputDate?.time ,
        isCompleted = project.isCompleted
    )

}