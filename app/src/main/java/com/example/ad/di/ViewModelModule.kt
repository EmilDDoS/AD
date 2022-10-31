package com.example.ad.di

import androidx.lifecycle.ViewModel
import com.example.ad.domain.usecase.AddVideoInformationDbUseCase
import com.example.ad.domain.usecase.GetLocalVideosUseCase
import com.example.ad.presentation.VideoViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {
    @IntoMap
    @ClassKey(VideoViewModel::class)
    @Provides
    fun getViewModel(
        getLocalVideosUseCase: GetLocalVideosUseCase,
        addVideoInformationDbUseCase: AddVideoInformationDbUseCase
    ): ViewModel = VideoViewModel(getLocalVideosUseCase,addVideoInformationDbUseCase)
}