package com.example.ad.presentation

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.ad.databinding.FragmentVideoBinding
import com.example.ad.di.ViewModelFactory
import com.example.ad.domain.model.VideoInformationModel
import com.example.ad.domain.model.VideoItemWithUri
import java.util.*

private const val DEFAULT_VIDEO_NUMBER = 0

class VideoFragment : Fragment() {

    lateinit var binding: FragmentVideoBinding
    private lateinit var holder: SurfaceHolder
    private val viewModel: VideoViewModel by viewModels { ViewModelFactory() }
    private val mediaPlayer = MediaPlayer()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        holder = binding.surfaceView.holder
        lifecycleScope.launchWhenStarted {
            viewModel.localVideosStateFlow.collect {
                loopAllVideos(it)
            }
        }
        lifecycleScope.launchWhenResumed { viewModel.getLocalVideos() }
    }

    private fun loopAllVideos(list: List<VideoItemWithUri>) {
        var i = DEFAULT_VIDEO_NUMBER

        addInformationInDb(list[i])
        val afd = requireContext().assets.openFd(list[i++].urn)
        val mySurfaceHolder = MySurfaceHolder(holder, afd, mediaPlayer)
        holder.addCallback(mySurfaceHolder)

        mediaPlayer.setOnCompletionListener {
            mySurfaceHolder.play(requireContext().assets.openFd(list[i].urn))
            addInformationInDb(list[i])
            if (i == list.size - 1) i = DEFAULT_VIDEO_NUMBER else i++
        }

    }

    private fun addInformationInDb(item: VideoItemWithUri){
        val videoInformation = VideoInformationModel(
            item.VideoId,
            item.VideoIdentifier,
            Date()
        )
        viewModel.addVideoInformation(videoInformation)
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer.release()
    }
}