package com.example.dishdashboard

import android.app.Application
import android.service.autofill.UserData
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DishDashboard_ViewModel(application : Application) : AndroidViewModel(application) {

    private val database =(application as DishDashboard_Application).database

    //Repository instance
    val repository by lazy {
        DishDashboard_Repository(database.dishDashboard_Dao())
    }
    private val _userdata: MutableStateFlow<List<UserData>> = MutableStateFlow(emptyList())
    val userdata : StateFlow<List<UserData>> = _userdata

//    init {
//        getAllUserData()
//    }
//
//    private fun getAllUserData() {
//        viewModelScope.launch {
//            repository.getAllUserData().collect {
//                _userdata.value = it
//            }
//        }
//    }

    fun addUserData(username: String, password: String) {
        viewModelScope.launch {
            if (username.isNotEmpty()) {
                repository.insert(
                    User(
                        username = username,
                        password = password
                    )
                )
            }
        }
    }


//    fun deleteNote(id: Int) {
//        viewModelScope.launch {
//            repository.deleteById(id)
//        }
//    }
}