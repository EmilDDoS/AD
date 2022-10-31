package com.example.ad.domain.usecase

import com.example.ad.domain.Repository

class GetLocalVideosUseCase(private val repository: Repository) {
    fun getLocalVideos() = repository.getLocalVideos()
}