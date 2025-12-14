package com.example.tutorials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.FloatRange
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorials.ui.theme.TutorialsTheme
import kotlinx.coroutines.launch
import java.lang.ProcessBuilder.Redirect.to

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
                    TestOvelappingCrayRow()
                }

            }
        }
    }
}


@Composable
fun OverlappingCrazyRow(
    modifier: Modifier = Modifier,
    @FloatRange(from = 0.1, to = 1.0) overlapFactor: Float = 0.5f,
    @FloatRange(from = 0.0, to = 0.5) moveDownFactor: Float = 0f,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content

    ) { measurables, constrains ->
        val placeables = measurables.map { measurables ->
            measurables.measure(constrains)
        }
        val heightMax = placeables.maxOf { it.height }
        val moveDown = (heightMax * moveDownFactor).toInt()
        val heigh = heightMax + moveDown
        val width = (placeables.subList(1, placeables.size)
            .sumOf { it.width } * overlapFactor + placeables[0].width).toInt()
        layout(width, heigh) {
            var xPos = 0
            for ((index, placeable) in placeables.withIndex()) {
                if (index % 2 == 0) {
                    placeable.placeRelative(xPos, 0, 0f)
                } else {
                    placeable.placeRelative(xPos, moveDown, 0f)
                }
                xPos += (placeable.width * overlapFactor).toInt()
            }
        }
    }
}

@Composable
fun TestOvelappingCrayRow() {
    OverlappingCrazyRow(overlapFactor = 0.7f, moveDownFactor = 0.2f) {

        Box(
            modifier = Modifier
                .size(60.dp)
                .border(width = 3.dp, color = Color.White, shape = CircleShape)
                .clip(CircleShape)
                .background(Color.Blue)
        )
        Box(
            modifier = Modifier
                .size(60.dp)
                .border(width = 3.dp, color = Color.White, shape = CircleShape)
                .clip(CircleShape)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .size(60.dp)
                .border(width = 3.dp, color = Color.White, shape = CircleShape)
                .clip(CircleShape)
                .background(Color.Cyan)
        )
        Box(
            modifier = Modifier
                .size(60.dp)
                .border(width = 3.dp, color = Color.White, shape = CircleShape)
                .clip(CircleShape)
                .background(Color.Magenta)
        )
        Box(
            modifier = Modifier
                .size(60.dp)
                .border(width = 3.dp, color = Color.White, shape = CircleShape)
                .clip(CircleShape)
                .background(Color.Green)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TutorialsTheme {
        TestOvelappingCrayRow()
    }
}
