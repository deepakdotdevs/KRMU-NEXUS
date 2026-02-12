package com.krmu.nexus.data.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class AuthRepository {

    private val auth = FirebaseAuth.getInstance()

    suspend fun loginUser(email: String, password: String): Result<String> {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            val uid = result.user?.uid ?: ""
            Result.success(uid)
        } catch (e: Exception) {
            Log.e("LOGIN_ERROR", "Firebase login failed: ${e.message}", e)
            Result.failure(e)
        }
    }

}

