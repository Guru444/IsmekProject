package com.oyun.ismekproject.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oyun.ismekproject.model.UserInfo

//Veritabanını oluşturduk

@Database(entities = [UserInfo::class], version = 3)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDAO() : UserDao
}