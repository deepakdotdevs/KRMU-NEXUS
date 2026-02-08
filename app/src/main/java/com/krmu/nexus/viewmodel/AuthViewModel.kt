package com.krmu.nexus.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    private val _selectedRole = MutableLiveData<String>()
    val selectedRole: LiveData<String> = _selectedRole

    fun setRole(role: String) {
        _selectedRole.value = role
    }
}