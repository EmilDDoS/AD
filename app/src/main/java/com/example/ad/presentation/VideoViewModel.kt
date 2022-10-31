package com.example.ad.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ad.domain.model.VideoInformationModel
import com.example.ad.domain.model.VideoItemWithUri
import com.example.ad.domain.usecase.AddVideoInformationDbUseCase
import com.example.ad.domain.usecase.GetLocalVideosUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class VideoViewModel(
    private val getLocalVideosUseCase: GetLocalVideosUseCase,
    private val addVideoInformationDbUseCase: AddVideoInformationDbUseCase
) : ViewModel() {
    private val _localVideosStateFlow = MutableSharedFlow<List<VideoItemWithUri>>()
    val localVideosStateFlow = _localVideosStateFlow.asSharedFlow()

    suspend fun getLocalVideos(){
        val videos = getLocalVideosUseCase.getLocalVideos()
        _localVideosStateFlow.emit(videos)
    }

    fun addVideoInformation(videoInformationModel: VideoInformationModel){
        viewModelScope.launch {
            addVideoInformationDbUseCase.addVideoInformation(videoInformationModel)
        }
    }
}