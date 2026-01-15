package com.example.tutorials.ui_kit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.FractionalThreshold
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.material.swipeable

@OptIn(ExperimentalWearMaterialApi::class)
@Composable
fun SwipeableExample(){
    val width = 200.dp
    val baseAnchor = 50.dp
    val swipeableState = rememberSwipeableState(initialValue = "Facil")

    val sizePx = with(LocalDensity.current){baseAnchor.toPx()}

    val anchors =
        mapOf(
            0f to "facil",
            sizePx to "Normal",
            sizePx * 2 to "Dificil",
            sizePx * 3 to "Demente"
        )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .width(width)
                .swipeable(
                    swipeableState,
                    anchors = anchors,
                    orientation = Orientation.Horizontal,
                    thresholds = {_ , _ -> FractionalThreshold(0.5f)}
                )
                .background(Color.LightGray)
        ){
            Box(
                modifier = Modifier
                    .offset{ IntOffset(swipeableState.offset.value.toInt(), 0)}
                    .size(baseAnchor)
                    .background(Color.Cyan)
            )
        }
    }

}