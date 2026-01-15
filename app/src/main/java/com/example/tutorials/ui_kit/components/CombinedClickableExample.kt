package com.example.tutorials.ui_kit.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CombinedClickableExample() {
    var text by remember {
        mutableStateOf("Ninguno")
    }

    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "Evento: $text",
            Modifier
                .combinedClickable(
                    onDoubleClick = {
                        text="Double Tab"
                    },
                    onLongClick = {
                        text = "Long press"
                    },
                    onClick = {
                        text = "tap"
                    }
                ),
            fontSize = 24.sp

        )

    }
}