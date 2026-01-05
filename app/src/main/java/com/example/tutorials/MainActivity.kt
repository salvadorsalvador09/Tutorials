package com.example.tutorials

import android.R.attr.name
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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

            }
        }
    }
}



@Composable
fun VistaImagenes() {
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
            .data(imageListURL[0])
            .build(),
        contentDescription = "Imagen del Producto",
        modifier = Modifier
            .width(120.dp)
            .height(120.dp)
    )

}
//Revisar la documentacion del coil

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TutorialsTheme {
        VistaImagenes()
    }
}