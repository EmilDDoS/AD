package com.example.ad.di

import com.example.ad.data.RepositoryImpl
import com.example.ad.data.database.Mapper
import com.example.ad.data.database.db.AppDataBase
import com.example.ad.data.localData.LocalVideo
import com.example.ad.domain.Repository
import com.example.ad.domain.usecase.AddVideoInformationDbUseCase
import com.example.ad.domain.usecase.GetLocalVideosUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule() {

    @Provides
    fun provideGetLocalVideosUseCase(
        repository: Repository
    ): GetLocalVideosUseCase = GetLocalVideosUseCase(repository)

    @Provides
    fun provideAddVideoInformationUseCase(
        repository: Repository
    ): AddVideoInformationDbUseCase = AddVideoInformationDbUseCase(repository)

    @Provides
    fun provideRepository(
        localVideo: LocalVideo,
        appDataBase: AppDataBase,
        mapper: Mapper
    ): Repository = RepositoryImpl(localVideo, appDataBase, mapper)

}