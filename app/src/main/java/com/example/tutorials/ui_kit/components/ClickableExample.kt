package com.example.tutorials.ui_kit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import kotlin.random.Random




@Composable
fun ClickableExample(){
    var background by remember {
        mutableStateOf(Color.Blue)
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Box(
            Modifier
                .background(background, CircleShape)
                .size(150.dp)
                .clickable{
                    background = randomColor()
                })
    }
}

fun randomColor() = Color(color = Random.nextLong(0xFFFFFFFF))

