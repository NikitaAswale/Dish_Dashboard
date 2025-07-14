package com.example.dishdashboard

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userdata" )
data class User(
    @PrimaryKey(autoGenerate = true)
    val id :Int = 0,
    val username : String,
    val password : String
)
