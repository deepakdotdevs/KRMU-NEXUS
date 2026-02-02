package com.krmu.nexus.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [], version = 1)
abstract class AppDatabase : RoomDatabase() {
    // there we add tables
}