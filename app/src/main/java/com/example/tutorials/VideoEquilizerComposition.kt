package com.example.tutorials

import android.media.audiofx.Equalizer
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.viewModelFactory

//Casos de uso, en internet en el local


val M3U8_URL = "https://test-streams.mux.dev/x36xhzz/x36xhzz.m3u8"

@Composable
fun VideoEqualizerComposition(innerPagding : PaddingValues, viewModel: AudioEqualizerViewModel)
{
    Scaffold(
        containerColor = Color(50, 145, 150, alpha = 150)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(top = it.calculateTopPadding())
        ) {
            item {
                Box(
                    modifier = Modifier.fillMaxSize()
                ){
                    VideoPlayerView(viewModel)
                }
            }
            item {
                EqualizerView(viewModel = viewModel)
            }
        }
    }
}


