package com.krmu.nexus.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey val uid: String,
    val email: String,
    val role: String
)
