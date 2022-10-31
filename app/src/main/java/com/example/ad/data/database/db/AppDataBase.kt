package com.example.ad.data.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ad.data.database.entity.VideoItemDbModel

@Database(entities = [VideoItemDbModel::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase(){
    abstract fun videosDao(): VideosDao
}