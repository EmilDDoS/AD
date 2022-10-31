package com.example.ad.domain.usecase

import com.example.ad.domain.Repository
import com.example.ad.domain.model.VideoInformationModel

class AddVideoInformationDbUseCase(private val repository: Repository) {
    suspend fun addVideoInformation(videoInformationModel: VideoInformationModel){
        repository.addVideoInformation(videoInformationModel)
    }
}