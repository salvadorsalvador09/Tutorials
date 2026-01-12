package com.example.tutorials

import android.net.Uri
import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.media3.common.MediaItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.hls.HlsMediaSource
import androidx.media3.ui.PlayerView


@OptIn(UnstableApi::class)
@Composable
fun VideoPlayerView(viewModel : AudioEqualizerViewModel) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val exoPlayer = remember { ExoPlayerManager.getExoPlayer(context) }
    LaunchedEffect(key1 = Unit) {
        val dataSourceFactor = DefaultHttpDataSource.Factory()
        var uri = Uri.Builder().encodedPath(M3U8_URL).build()
        val mediaItem = MediaItem.Builder().setUri(uri).build()

        val internetVideoSource =
            HlsMediaSource.Factory(dataSourceFactor).createMediaSource(mediaItem)

        exoPlayer.setMediaSource(internetVideoSource)
        exoPlayer.prepare()
        viewModel.onStart(exoPlayer.audioSessionId)
    }

    Box(modifier = Modifier.fillMaxSize())
    {
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.4f)
                .padding(top = 16.dp)
                .background(Color.Black),
            factory = {
                PlayerView(context).apply {
                    player = exoPlayer
                    exoPlayer.repeatMode = Player.REPEAT_MODE_ONE
                    exoPlayer.playWhenReady = false
                    setFullscreenButtonClickListener{ isFullScreen ->

                    }
                }
            }
        )
    }



    DisposableEffect(key1 = lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                exoPlayer.playWhenReady = false
            } else if (event == Lifecycle.Event.ON_PAUSE) {
                exoPlayer.playWhenReady = false
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    DisposableEffect(key1 = Unit) {
        onDispose {
            ExoPlayerManager.releaseExoPlayer()
        }
    }
}
