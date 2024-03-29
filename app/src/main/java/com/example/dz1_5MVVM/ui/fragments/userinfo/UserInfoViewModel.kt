package com.example.dz1_5MVVM.ui.fragments.userinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dz1_5MVVM.data.models.UserModel
import com.example.dz1_5MVVM.data.repositories.UserRepository

class UserInfoViewModel : ViewModel() {

    private val _userLiveData = MutableLiveData<UserModel>()
    val userLiveData: LiveData<UserModel> = _userLiveData
    private val repository = UserRepository()

    fun getUserInfo() {
        _userLiveData.value = repository.getUserInfo()
    }
}