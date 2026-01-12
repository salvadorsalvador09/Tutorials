package com.example.tutorials

sealed class Screen {
    data object ClickableScreen : Screen(){
        val route = "clickable_screen"
    }
    data object DraggableScreen: Screen(){
        val route = "draggable_screen"
    }
    data object RotationScreen : Screen(){
        val route = "rotatio_screen"
    }
}