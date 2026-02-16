package com.krmu.nexus.data.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import com.google.firebase.firestore.FirebaseFirestore

class AuthRepository {

    private val auth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()

    suspend fun loginUser(email: String, password: String): Result<Pair<String, String>> {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            val uid = result.user?.uid ?: ""

            val document = firestore.collection("users")
                .document(uid)
                .get()
                .await()

            val role = document.getString("role") ?: "student"

            Result.success(Pair(uid, role))

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

