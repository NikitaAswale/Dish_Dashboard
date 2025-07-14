package com.example.dishdashboard

import android.service.autofill.UserData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DishDashboard_Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user : User)

//    @Query("SELECT * FROM user ORDER BY id ASC")
//    fun getAllUserData(): Flow<List<User>>
//
//    @Query("DELETE FROM user WHERE id = :id")
//    suspend fun deleteById(id: Int)
}