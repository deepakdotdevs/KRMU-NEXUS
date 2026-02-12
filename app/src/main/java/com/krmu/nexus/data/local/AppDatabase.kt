package com.krmu.nexus.data.local.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import com.krmu.nexus.data.local.entity.UserEntity
import com.krmu.nexus.data.local.dao.UserDao

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
