package com.example.tutorials.ui_kit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ScrollableExample(){
    val boxSize = 300f
    var scrollDeltaSum by remember {
        mutableStateOf(boxSize)
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Alpha= ${scrollDeltaSum / boxSize}" )
            Box (
                modifier = Modifier
                    .size(boxSize.dp)
                    .scrollable(
                        orientation = Orientation.Vertical,
                         state = rememberScrollableState { delta ->
                             scrollDeltaSum = (scrollDeltaSum - delta/2).coerceIn(0f, boxSize)
                             delta
                         }
                    )
                    .alpha(scrollDeltaSum /boxSize)
                    .background(Color.Magenta)
            )
        }
    }

}