package com.krmu.nexus.utils
// It's the app's memory of login
import android.content.Context
class SessionManager(context: Context) {
    private val prefs = context.getSharedPreferences("krmu_session", Context.MODE_PRIVATE)
    fun saveLogin(role: String) {
        prefs.edit().putBoolean("isLoggedIn", true)
            .putString("role", role)
            .apply()
    }
    fun isLoggedIn(): Boolean = prefs.getBoolean("isLoggedIn", false)
    fun getRole(): String? = prefs.getString("role", null)
    fun logout() {
        prefs.edit().clear().apply()
    }
}