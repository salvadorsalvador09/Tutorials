package com.example.tutorials.ui_kit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalScrollExample() {
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ){
        Row(
            Modifier
                .fillMaxSize()
                .horizontalScroll(scrollState)
        ){
            repeat (10){
                Box(modifier = Modifier
                    .size(100.dp)
                    .background(randomColor())
                )
            }
        }
    }



}