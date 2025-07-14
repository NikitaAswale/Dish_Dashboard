package com.example.dishdashboard

import android.app.Application

class DishDashboard_Application : Application() {
    // Lazy initialization of database
    val database by lazy {
        DishDashboard_Database.getDatabase(this)
    }
}