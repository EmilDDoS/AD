package com.example.ad.data.database

import com.example.ad.data.database.entity.VideoItemDbModel
import com.example.ad.data.model.VideoItem
import com.example.ad.domain.model.VideoInformationModel
import com.example.ad.domain.model.VideoItemWithUri
import java.util.*

const val HEAD_URI = "videos/"

class Mapper {
    fun mapVideoInformationToVideoItemDb(
        videoInformationModel: VideoInformationModel
    ): VideoItemDbModel{
        return VideoItemDbModel(
            idVideo = videoInformationModel.idVideo,
            videoName = videoInformationModel.videoName,
            startTime = videoInformationModel.startTime.time
        )
    }

    fun mapVideoItemDbToVideoInformationModel(
        videoItemDbModel: VideoItemDbModel
    ): VideoInformationModel{
        return VideoInformationModel(
            idVideo = videoItemDbModel.idVideo,
            videoName = videoItemDbModel.videoName,
            startTime = Date(videoItemDbModel.startTime)
        )
    }

    fun mapLocalVideoItemToVideoWithUri(videoItem: VideoItem): VideoItemWithUri{
            return VideoItemWithUri(
                videoItem.OrderNumber,
                videoItem.VideoId,
                videoItem.VideoIdentifier,
                HEAD_URI + videoItem.VideoIdentifier
            )
    }
}