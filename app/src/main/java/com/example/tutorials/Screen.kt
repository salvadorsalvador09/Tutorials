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
    data object CombinedClickableScreen : Screen(){
        val route = "combined_screen"
    }
    data object DraggableFullScreen : Screen(){
        val route = "draggable_full_screen"
    }
    data object TransformationScreen : Screen() {
        val route = "transformation_screen"
    }
}