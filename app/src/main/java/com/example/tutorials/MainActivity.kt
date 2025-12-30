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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                    content = {
                        PlaceList(placeList = DataSource().loadPlaces())
                    }
                )
            }

        }
    }
}
@Composable
fun PlaceCard(place: PlaceToVisit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.DarkGray
        )
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = stringResource(place.nameResourceId),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 10.dp, top = 5.dp)
                    )
                    Text(
                        text = stringResource(place.countryResourceId),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 10.dp, bottom = 5.dp)
                    )
                }

                Text(
                    text = stringResource(place.languageResourceId),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
            }
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(place.imageResourceId),
                    contentDescription = stringResource(place.nameResourceId),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.Crop
                )

                Row(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(bottom = 12.dp)
                        .background(color = Color(0xFFF0BF1F)) // mismo color
                ) {
                    Text(
                        text = stringResource(place.weatherResourceId),
                        fontSize = 15.sp,
                        modifier = Modifier.padding(
                            start = 12.dp,
                            top = 6.dp,
                            bottom = 6.dp,
                            end = 12.dp
                        )
                    )
                }

                Image(
                    painter = painterResource(R.drawable.heart),
                    contentDescription = stringResource(R.string.favorite),
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(10.dp)
                        .size(50.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Text(
                text = stringResource(place.descriptionResourceId),
                fontSize = 12.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}



@Composable
private fun PlaceList(placeList: List<PlaceToVisit>, modifier: Modifier = Modifier) {
    LazyRow {
        items(placeList) { place ->
            PlaceCard(place, Modifier.width(320.dp))
        }
    }
}


@Preview(name = "Phone", device = "spec:width=411dp,height=891dp,dpi=420", showBackground = true)
@Preview(name = "Small", device = "spec:width=360dp,height=640dp,dpi=420", showBackground = true)
@Preview(name = "Tablet", device = "spec:width=1280dp,height=800dp,dpi=240", showBackground = true)
@Composable
fun PreviewMunicipioScreen() {
    MaterialTheme {
        PlaceList(placeList = DataSource().loadPlaces(), modifier = Modifier.width(320.dp))
    }
}

@Preview(name = "Font 1.3x", fontScale = 1.3f, showBackground = true)
@Composable
fun PreviewFontScale() {
    TutorialsTheme {
        PlaceList(placeList = DataSource().loadPlaces(), modifier = Modifier.width(320.dp))
    }
}

@Preview
@Composable
fun Preview() {
    TutorialsTheme {
        PlaceList(placeList = DataSource().loadPlaces(), modifier = Modifier.width(320.dp))
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
        PlaceList(placeList = DataSource().loadPlaces())
    }
}



