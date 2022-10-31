package com.example.ad.data.localData

import android.content.Context
import com.example.ad.data.model.VideoItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream

private const val NAME_MEDIA_LIST = "medialist.json"

class LocalVideo(private val context: Context) {
    fun getVideos(): List<VideoItem> {
        val jsonFileString: String = getJsonFromAssets(context)
        val listUserType = object : TypeToken<List<VideoItem>>() {}.type
        val str = Gson().fromJson<List<VideoItem>>(jsonFileString, listUserType)
        return str
    }
}

private fun getJsonFromAssets(context: Context): String {
    val stream: InputStream = context.assets.open(NAME_MEDIA_LIST)
    val size: Int = stream.available()
    val buffer = ByteArray(size)
    try {
        stream.read(buffer)
        stream.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return String(buffer)
}
