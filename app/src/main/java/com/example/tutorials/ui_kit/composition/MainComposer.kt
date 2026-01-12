package com.example.tutorials.ui_kit.composition

import android.annotation.SuppressLint
import android.view.SubMenu
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text
import com.example.tutorials.Screen
import com.example.tutorials.ui_kit.components.ClickableExample
import com.example.tutorials.ui_kit.components.DraggableExample
import com.example.tutorials.ui_kit.components.RotationExample

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainComposer() {
    val navController = rememberNavController()
    Scaffold (
        topBar = {
            if (navController.currentBackStackEntry?.destination?.route != Screen.ClickableScreen.route) {
                ExpandableMenuList(navController)
            }
        },
        content = {
            NavHost(
                navController = navController,
                startDestination = Screen.ClickableScreen.route
            ) {
                composable(Screen.ClickableScreen.route){
                    ClickableExample()
                }
                composable (Screen.DraggableScreen.route){
                    DraggableExample()
                }
                composable (Screen.RotationScreen.route){
                    RotationExample()
                }
            }
        }
    )
}

@Composable
fun ExpandableMenuList(
    navController : NavController,
    isExpanded: Boolean = false
){
    val exandedState = remember { mutableStateOf(isExpanded) }
    val subMenu = listOf(
        Screen.ClickableScreen.route,
        Screen.DraggableScreen.route,
        Screen.RotationScreen.route
    )
    Column(
        modifier = Modifier
            .statusBarsPadding()
    ) {
        Button(
            onClick = { exandedState.value = !exandedState.value},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            if(exandedState.value) {
                Text(text = "Collapse Menu")
            } else {
                Text(text = "Menu")
            }

        }
        if(exandedState.value){
            LazyColumn(
                modifier = Modifier.fillMaxHeight()
            ) {
                 items(subMenu){ screen ->
                    Button(
                        onClick = { navController.navigate(screen)},
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text( text = screen.toString().replaceFirstChar { it.uppercase() })
                    }
                 }
            }
        }
    }
}