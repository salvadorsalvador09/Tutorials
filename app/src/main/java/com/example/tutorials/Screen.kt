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
    data object HorizontalScrollScreen : Screen() {
        val route = "horizontal_scroll_screen"
    }
    data object VerticalScrollScreen : Screen() {
        val route = "vertical_scroll_screen"
    }
    data object ScrollableScreen : Screen() {
        val route = "scrollable_screen"
    }
    data object NestedScrollScreen : Screen() {
        val route = "nested_scroll_screen"
    }

}