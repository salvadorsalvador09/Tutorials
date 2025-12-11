package com.example.tutorials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorials.ui.theme.TutorialsTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TutorialsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HorizontalExample()
                }

            }
        }
    }
}

@Composable
fun HorizontalExample(modifier: Modifier = Modifier) {
    val colorList = listOf(Color.Red, Color.Green, Color.Blue, Color.Cyan, Color.Magenta)
    val pageState = rememberPagerState {
        colorList.size
    }
    val coroutineScope = rememberCoroutineScope()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        HorizontalPager(state = pageState) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(colorList[it]),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Page: $it",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "Previous Page",
                modifier = Modifier
                    .size(75.dp)
                    .clickable{
                        coroutineScope.launch {
                            pageState.animateScrollToPage(pageState.currentPage -1)
                        }
                    }

            )
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = "Previous Page",
                modifier = Modifier
                    .size(75.dp)
                    .clickable{
                        coroutineScope.launch {
                            pageState.animateScrollToPage(pageState.currentPage +1)
                        }
                    }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TutorialsTheme {
        HorizontalExample()
    }
}