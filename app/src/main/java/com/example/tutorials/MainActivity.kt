package com.example.tutorials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Row {
            Box {
                Image(
                    painter = painterResource(place.imageResourceId),
                    contentDescription = stringResource(place.nameResourceId),
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.Top
                ) {
                    Box {
                        Image(
                            painter = painterResource(place.imageResourceId),
                            contentDescription = stringResource(place.nameResourceId),
                            modifier = Modifier
                                .width(200.dp)
                                .height(200.dp),
                            contentScale = ContentScale.Crop
                        )
                        Row(
                            modifier = Modifier
                                .padding(top = 12.dp)
                                .background(Color(240, 191, 31)),
                        ) {
                            Text(
                                text = stringResource(place.weatherResourceId),
                                fontSize = 15.sp,
                                modifier = Modifier.padding(
                                    start = 10.dp,
                                    top = 6.dp,
                                    bottom = 6.dp,
                                    end = 12.dp
                                )
                            )
                        }
                        Image(
                            painter = painterResource(R.drawable.heart),
                            contentDescription = stringResource(R.string.info),
                            modifier = Modifier
                                .width(50.dp)
                                .height(50.dp)
                                .align(Alignment.BottomEnd)
                                .padding(10.dp),
                            contentScale = ContentScale.Fit
                        )
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)          // <-- CLAVE: deja espacio al icono de la derecha
                            .padding(start = 8.dp)
                    ) {
                        Text(
                            text = stringResource(place.nameResourceId),
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp)
                        )
                        Text(
                            text = stringResource(place.countryResourceId),
                            fontSize = 26.sp,
                            modifier = Modifier.padding(10.dp)
                        )
                        Text(
                            text = stringResource(place.languageResourceId),
                            fontSize = 36.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(10.dp)
                        )
                    }

                    Image(
                        painter = painterResource(R.drawable.info),
                        contentDescription = stringResource(R.string.info),
                        modifier = Modifier
                            .padding(8.dp)
                            .size(20.dp)          // más limpio que width+height
                            .align(Alignment.Top), // opcional
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
    }
}

@Composable
private fun PlaceList(placeList: List<PlaceToVisit>, modifier: Modifier = Modifier)
{
    LazyColumn {
        items(placeList){
            place -> PlaceCard(place = place)
        }
    }
}


@Preview(name = "Phone", device = "spec:width=411dp,height=891dp,dpi=420", showBackground = true)
@Preview(name = "Small", device = "spec:width=360dp,height=640dp,dpi=420", showBackground = true)
@Preview(name = "Tablet", device = "spec:width=1280dp,height=800dp,dpi=240", showBackground = true)
@Composable
fun PreviewMunicipioScreen() {
    MaterialTheme {
        PlaceList(placeList = DataSource().loadPlaces())
    }
}

@Preview(name = "Font 1.3x", fontScale = 1.3f, showBackground = true)
@Composable
fun PreviewFontScale() {
    TutorialsTheme {
        PlaceList(placeList = DataSource().loadPlaces())
    }
}

@Preview
@Composable
fun Preview() {
    TutorialsTheme {
        PlaceList(placeList = DataSource().loadPlaces())
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



