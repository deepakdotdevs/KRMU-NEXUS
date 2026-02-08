package com.krmu.nexus.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.krmu.nexus.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    // there we add tables
}