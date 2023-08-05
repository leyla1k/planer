package com.example.todolist.database

import android.app.Application

class App:Application() {
    private val projectsDatabase by lazy{ProjectsDB.getDatabase(this)}
     val projectsRepository by lazy{ProjectsRepository(projectsDatabase.getDao())}
}