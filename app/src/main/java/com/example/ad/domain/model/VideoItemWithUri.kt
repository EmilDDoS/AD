package com.example.ad.domain.model

data class VideoItemWithUri(
        val OrderNumber: Int = 0,
        val VideoId: Int = 0,
        val VideoIdentifier: String = "",
        val urn: String = ""
    )