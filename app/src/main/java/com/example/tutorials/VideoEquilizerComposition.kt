package com.example.tutorials

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue

//Casos de uso, en internet en el local


val M3U8_URL = "https://test-streams.mux.dev/x36xhzz/x36xhzz.m3u8"

@Composable
fun VideoEqualizerComposition(
    innerPagding : PaddingValues,
    viewModel: AudioEqualizerViewModel,
    activity: MainActivity
)
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
                    VideoPlayerView(
                        viewModel,
                        activity
                    )
                }
            }
            item {
                val visibleEqualizer by viewModel.visibleEqualizer.collectAsState()
                AnimatedVisibility (
                    visible = visibleEqualizer,
                    enter = fadeIn() + slideInVertically{fullHeight -> fullHeight /2},
                    exit = fadeOut() + slideOutVertically{fullHeight -> fullHeight/3}
                ) {
                    EqualizerView(viewModel = viewModel)
                }
            }
        }
    }
}


