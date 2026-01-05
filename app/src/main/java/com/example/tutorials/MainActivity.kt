package com.example.tutorials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.tutorials.ui.theme.TutorialsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TutorialsTheme {
                VistaImagenes()
            }
        }
    }
}

@Composable
fun VistaImagenes() {

    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
            )
        )
    }

//    Image(
//        painterResource(id = R.drawable.imagen_1),
//        contentDescription = “Imagen del producto”,
//    contentScale = ContentScale.Crop,
//    modifier = Modifier
//        .width(240.dp)
//        .height(240.dp)
//        //.background(Color.Yellow)
//        //.scale(1.2f)
//        //.rotate(360f)
//        .clip(CircleShape)
//        .border(
//            BorderStroke(14.dp, Color.Yellow),
//            CircleShape
//        )
//    )
    //El resultado será el siguiente
    val imageListURL = listOf(
        "https://media.kosherclick.mx//art/10001.png",
        "https://media.kosherclick.mx//art/10002.png",
        "https://media.kosherclick.mx//art/10003.png",
        "https://media.kosherclick.mx//art/10004.png",
        "https://media.kosherclick.mx//art/10005.png",
        "https://media.kosherclick.mx//art/10006.png",
    )
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageListURL[4])
            .build(),
        contentDescription = "Imagen del Producto",
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .aspectRatio(10f/9f)
            .border(
            BorderStroke(4.dp, rainbowColorsBrush),
                shape = CircleShape
        ),
        contentScale = ContentScale.None
    )
//Se pueden rotar y escalar solo con el modifier
    //Tambien se puede redondear con el modifier con el clip CircleShape
    //
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TutorialsTheme {
        VistaImagenes()
    }
}