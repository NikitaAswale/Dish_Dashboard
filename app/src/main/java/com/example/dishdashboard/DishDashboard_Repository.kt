package com.example.dishdashboard

import android.service.autofill.UserData
import kotlinx.coroutines.flow.Flow

class DishDashboard_Repository(private val dishdashboarddao: DishDashboard_Dao) {

//    suspend fun getAllUserData() : Flow<List<UserData>> {
//        return dishdashboarddao.getAllUserData()
//    }

    suspend fun insert(user: User) {
        dishdashboarddao.insert(user)
    }

//    suspend fun deleteById(id: Int) {
//        dishdashboarddao.deleteById(id)
//    }
}