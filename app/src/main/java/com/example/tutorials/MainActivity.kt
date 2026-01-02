package com.example.tutorials

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Card

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tutorials.ui.theme.TutorialsTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorials.data.DataSource
import com.example.tutorials.model.PlaceToVisit


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TutorialsTheme {
                Surface(
                    content = {
                    }
                )
            }

        }
    }
}

@Composable
fun ImageItem(id: Int, description: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation( defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White, //Card background color
            contentColor = Color.DarkGray  //Card content color,e.g.text
        )
    ) {
        Box{
            Image(
                painter =  painterResource(id),
                contentDescription = description,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
    }
}




@Composable
private fun StraggeredGrid()
{
    val images= intArrayOf(R.drawable.butterfly, R.drawable.cat, R.drawable.crane,
        R.drawable.dog, R.drawable.elephant, R.drawable.fish, R.drawable.fox,
        R.drawable.fox, R.drawable.frog, R.drawable.horse, R.drawable.owl,
        R.drawable.owl, R.drawable.rabbit, R.drawable.whale, R.drawable.butterfly,
        R.drawable.fox, R.drawable.frog, R.drawable.horse
        )
    val description = arrayOf(
        stringResource(R.string.butterfly), stringResource(R.string.cat),
        stringResource(R.string.butterfly), stringResource(R.string.cat),
        stringResource(R.string.butterfly), stringResource(R.string.cat),
        stringResource(R.string.butterfly), stringResource(R.string.cat),
        stringResource(R.string.butterfly), stringResource(R.string.cat),
        stringResource(R.string.butterfly), stringResource(R.string.cat),
        stringResource(R.string.butterfly), stringResource(R.string.cat),
        stringResource(R.string.butterfly), stringResource(R.string.cat),
    )
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(3),
        verticalItemSpacing = 4.dp
    ) {
        items(images.size){
            index-> ImageItem(images[index], description[index])
        }
    }
}




@Preview
@Composable
fun StageredgridPreviewPreview() {
    TutorialsTheme {
        StraggeredGrid()
    }
}




