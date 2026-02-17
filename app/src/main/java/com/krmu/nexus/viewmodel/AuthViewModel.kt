package com.krmu.nexus.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.krmu.nexus.data.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val repository = AuthRepository()
    val userData = MutableLiveData<Pair<String, String>>()


    // 🔹 Role Selection
    private val _role = MutableLiveData<String>()
    val role: LiveData<String> = _role

    fun setRole(selectedRole: String) {
        _role.value = selectedRole
    }

    // 🔹 Login State
    val loading = MutableLiveData<Boolean>()
    val loginSuccess = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    fun login(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            errorMessage.value = "All fields are required"
            return
        }

        viewModelScope.launch {
            loading.value = true

            val result = repository.loginUser(email, password)

            loading.value = false

            result.onSuccess { pair ->
                userData.value = pair
            }.onFailure {
                errorMessage.value = it.message ?: "Login failed"
            }
        }
    }
}
