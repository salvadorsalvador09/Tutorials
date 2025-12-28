package com.example.tutorials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorials.ui.theme.TutorialsTheme
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


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
                    SampleCard("Dragon Azul", "Tecnica Origami")
                }
            }

        }
    }
}


@Composable
fun SampleCard(title: String, subtitle: String) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = CutCornerShape(150.dp),
        modifier = Modifier
            .width(300.dp)
            .height(300.dp)
    ) {
        Box (
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(R.drawable.dragon),
                contentDescription =  title,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 25.dp)
                    .background(Color(114, 138, 178, 150))
            )
            Text(
                text = subtitle,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp, top = 5.dp)
            )

        }
        Text(text = subtitle)
    }
}


@Preview(name = "Phone", device = "spec:width=411dp,height=891dp,dpi=420", showBackground = true)
@Preview(name = "Small", device = "spec:width=360dp,height=640dp,dpi=420", showBackground = true)
@Preview(name = "Tablet", device = "spec:width=1280dp,height=800dp,dpi=240", showBackground = true)
@Composable
fun PreviewMunicipioScreen() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            SampleCard("Dragon Azul", "Tecnica Origami")
        }
    }
}

@Preview(name = "Font 1.3x", fontScale = 1.3f, showBackground = true)
@Composable
fun PreviewFontScale() {
    TutorialsTheme { SampleCard("Dragon Azul", "Tecnica Origami")}
}

@Preview(
    name = "Dark",
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun PreviewDark() {
    TutorialsTheme { SampleCard("Dragon Azul", "Tecnica Origami") }
}
@Preview
@Composable
fun Preview()
{
    SampleCard("Dragon Azul", "Tecnica Origami")
}



