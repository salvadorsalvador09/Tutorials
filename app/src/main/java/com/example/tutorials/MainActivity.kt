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
                        PlaceGrid(placeList = DataSource().loadPlaces(), modifier = Modifier.width(100.dp))
                    }
                )
            }

        }
    }
}

@Composable
fun PlaceCard(place: PlaceToVisit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation( defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White, //Card background color
            contentColor = Color.DarkGray  //Card content color,e.g.text
        )
    ) {
        Box {
            Image(
                painter = painterResource(place.imageResourceId),
                contentDescription = stringResource(place.nameResourceId),
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .align(Alignment.Center),
                contentScale = ContentScale.Crop
            )
            Row (
                Modifier
                    .padding(top = 12.dp)
                    .background(color= Color(14, 177, 210))
                    .width(120.dp)
            ) {
                Text(
                    text = stringResource(place.nameResourceId),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 12.dp, top = 6.dp, bottom = 6.dp, end = 12.dp)
                )
            }
            Row (
                Modifier
                    .padding(top = 42.dp)
                    .background(color= Color(79, 93, 117))
                    .width(120.dp)
            ) {
                Text(
                    text = stringResource(place.countryResourceId),
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(start = 12.dp, top = 6.dp, bottom = 6.dp, end =
                            12.dp)
                )
            }
            Image(
                painter = painterResource(R.drawable.heart),
                contentDescription = stringResource(R.string.favorite),
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .align(Alignment.BottomEnd)
                    .padding(10.dp),
                contentScale = ContentScale.Fit
            )
            Image(
                painter = painterResource(R.drawable.info),
                contentDescription = stringResource(R.string.info),
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .align(Alignment.TopEnd)
                    .padding(10.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}


@Composable
private fun PlaceGrid(placeList: List<PlaceToVisit>, modifier: Modifier = Modifier) {
    LazyHorizontalGrid(
        rows = GridCells.Adaptive(minSize = 100.dp)
    ) {
        items(placeList) {
            place -> PlaceCard(place = place)
        }
    }
}


@Preview(name = "Phone", device = "spec:width=411dp,height=891dp,dpi=420", showBackground = true)
@Preview(name = "Small", device = "spec:width=360dp,height=640dp,dpi=420", showBackground = true)
@Preview(name = "Tablet", device = "spec:width=1280dp,height=800dp,dpi=240", showBackground = true)
@Composable
fun PreviewDifferentScreen() {
    MaterialTheme {
        PlaceGrid(placeList = DataSource().loadPlaces(), modifier = Modifier.width(100.dp))
    }
}

@Preview(name = "Font 1.3x", fontScale = 1.3f, showBackground = true)
@Composable
fun PreviewFontScale() {
    TutorialsTheme {
        PlaceGrid(placeList = DataSource().loadPlaces(), modifier = Modifier.width(100.dp))
    }
}

@Preview
@Composable
fun Preview() {
    TutorialsTheme {
        PlaceGrid(placeList = DataSource().loadPlaces(), modifier = Modifier.width(320.dp))
    }
}

@Preview(
    name = "Dark",
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun PreviewDark() {
    TutorialsTheme {
        PlaceGrid(placeList = DataSource().loadPlaces())
    }
}



