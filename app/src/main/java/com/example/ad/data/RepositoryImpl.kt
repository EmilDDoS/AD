package com.example.ad.data

import com.example.ad.data.database.Mapper
import com.example.ad.data.database.db.AppDataBase
import com.example.ad.data.localData.LocalVideo
import com.example.ad.domain.Repository
import com.example.ad.domain.model.VideoInformationModel
import com.example.ad.domain.model.VideoItemWithUri

class RepositoryImpl(
    private val localVideo: LocalVideo,
    private val appDataBase: AppDataBase,
    private val mapper: Mapper
) : Repository {

    override fun getLocalVideos(): List<VideoItemWithUri> {
        return localVideo.getVideos().map {
            mapper.mapLocalVideoItemToVideoWithUri(it)
        }
    }

    override suspend fun addVideoInformation(videoInformationModel: VideoInformationModel) {
        val information = mapper.mapVideoInformationToVideoItemDb(videoInformationModel)
        appDataBase.videosDao().addVideoInformation(information)
    }
}