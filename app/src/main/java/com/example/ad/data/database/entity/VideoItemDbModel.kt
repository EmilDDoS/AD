package com.example.ad.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reports")
data class VideoItemDbModel(
    @PrimaryKey(autoGenerate = true)
    val autoIncrement: Int = 0,
    val idVideo: Int,
    val videoName: String,
    val startTime: Long
)