package com.example.dishdashboard

import android.service.autofill.UserData

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserData::class], version = 1)
abstract class DishDashboard_Database : RoomDatabase() {
    abstract fun dishDashboard_Dao(): DishDashboard_Dao

    companion object {
        @Volatile private var INSTANCE: DishDashboard_Database? = null

        fun getDatabase(context: Context): DishDashboard_Database {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    DishDashboard_Database::class.java,
                    "userdata"
                ).build().also { INSTANCE = it }
            }
        }
    }
}