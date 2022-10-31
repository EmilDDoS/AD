package com.example.ad.data.database.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ad.data.database.entity.VideoItemDbModel

@Dao
interface VideosDao {

    @Query("SELECT * FROM reports")
    suspend fun getListVideosInformation(): List<VideoItemDbModel>

    @Insert
    suspend fun addVideoInformation(videoItemDbModel: VideoItemDbModel)
}