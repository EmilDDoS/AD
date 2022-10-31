package com.example.ad.presentation

import android.content.res.AssetFileDescriptor
import android.media.AudioManager
import android.media.MediaPlayer
import android.view.SurfaceHolder
import java.io.IOException

class MySurfaceHolder(
    private val holder: SurfaceHolder,
    private val afd: AssetFileDescriptor,
    private val mediaPlayer: MediaPlayer
) : SurfaceHolder.Callback {

    override fun surfaceCreated(p0: SurfaceHolder) {
        mediaPlayer.setDisplay(holder)
        mediaPlayer.setOnPreparedListener { it.start() }
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        play(afd)
    }

    fun play(afd: AssetFileDescriptor) {
        try {
            mediaPlayer.reset()
            mediaPlayer.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
            mediaPlayer.prepare()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {
    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
    }
}
