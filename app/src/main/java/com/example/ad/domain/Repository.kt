package com.example.ad.domain

import com.example.ad.domain.model.VideoInformationModel
import com.example.ad.domain.model.VideoItemWithUri

interface Repository {
    fun getLocalVideos(): List<VideoItemWithUri>
    suspend fun addVideoInformation(videoInformationModel: VideoInformationModel)
}