package com.example.tutorials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorials.ui.theme.TutorialsTheme
import kotlin.collections.forEachIndexed
import kotlin.collections.lastIndex
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.ui.unit.Dp

object Dimens {
    val screenPadding = 16.dp
    val sectionVertical = 12.dp
    val cardPadding = 12.dp

    val gapXs = 6.dp
    val gapSm = 8.dp
    val gapMd = 12.dp
    val gapLg = 16.dp

    val radiusMd = 14.dp
    val radiusLg = 16.dp
    val radiusPill = 999.dp

    val iconSm = 16.dp
    val photoCardW = 260.dp
    val photoCardH = 160.dp
    val bottomBarPadding = 12.dp
    val bottomSpacer = 80.dp
}

data class PhotoItem(val title: String, val drawableRes: Int)
data class CategoryItem(val name: String, val iconRes: Int)
data class InfoItem(val label: String, val value: String)

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
                    MunicipioScreen()
                }
            }

        }
    }
}

fun Modifier.sectionPadding(): Modifier =
    this.padding(horizontal = Dimens.screenPadding, vertical = Dimens.sectionVertical)

enum class BottomSection {
    NONE, MORE_INFO, HOTELS, RESTAURANTS
}

@Composable
fun MunicipioScreen() {
    val municipio = "Pátzcuaro, Michoacán"
    val ubicacion = "Centro-norte del estado"
    val habitantes = "Aprox. 90,000"
    val clima = "Templado, lluvias en verano"
    val tradiciones = "Noche de Muertos, artesanías"
    val gastronomia = "Corundas, atole, charales"
    val comoLlegar = "Autobús desde Morelia; moverse en taxi/colectivos"

    val photos = listOf(
        PhotoItem("Lago de Pátzcuaro", R.drawable.lago_paztcuaro),
        PhotoItem("Isla de Janitzio", R.drawable.isla_janitzio),
        PhotoItem("Basílica", R.drawable.basilica),
        PhotoItem("Plaza Vasco", R.drawable.plazavasco),
    )

    val categories = listOf(
        CategoryItem("Lago", R.drawable.ic_tag),
        CategoryItem("Pueblo Mágico", R.drawable.ic_tag),
        CategoryItem("Artesanías", R.drawable.ic_tag),
        CategoryItem("Tradiciones", R.drawable.ic_tag),
        CategoryItem("Gastronomía", R.drawable.ic_tag),
    )

    val info = listOf(
        InfoItem("Municipio", municipio),
        InfoItem("Ubicación", ubicacion),
        InfoItem("Habitantes", habitantes),
        InfoItem("Clima", clima),
        InfoItem("Tradiciones", tradiciones),
        InfoItem("Gastronomía", gastronomia),
        InfoItem("Cómo llegar", comoLlegar),
    )

    var activeSection by rememberSaveable { mutableStateOf(BottomSection.NONE) }

    Scaffold(
        bottomBar = {
            BottomActions(
                onMore = {
                    activeSection =
                        if (activeSection == BottomSection.MORE_INFO) BottomSection.NONE else BottomSection.MORE_INFO
                },
                onHotels = {
                    activeSection =
                        if (activeSection == BottomSection.HOTELS) BottomSection.NONE else BottomSection.HOTELS
                },
                onRestaurants = {
                    activeSection =
                        if (activeSection == BottomSection.RESTAURANTS) BottomSection.NONE else BottomSection.RESTAURANTS
                }
            )

        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .windowInsetsPadding(WindowInsets.safeDrawing)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Turismo municipal",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.sectionPadding()
            )

            PhotoCarousel(
                photos = photos,
                modifier = Modifier.fillMaxWidth()
            )

            CategoryChips(
                categories = categories,
                modifier = Modifier.fillMaxWidth()
            )

            MunicipioInfo(
                info = info,
                modifier = Modifier.fillMaxWidth()
            )

            DynamicSection(
                section = activeSection,
                onClose = { activeSection = BottomSection.NONE }
            )
            Spacer(Modifier.height(Dimens.bottomSpacer))
        }
    }
}

@Composable
fun PhotoCarousel(photos: List<PhotoItem>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.sectionPadding()) {
        AppSectionTitle("Sitios Turisticos")
        Spacer(Modifier.height(Dimens.gapSm))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(Dimens.gapMd),
            contentPadding = PaddingValues(horizontal = Dimens.gapXs)
        )
        {
            items(photos) { item -> PhotoCard(item) }
        }
    }
}

@Composable
fun PhotoCard(item: PhotoItem) {
    Card(
        modifier = Modifier.size(width = Dimens.photoCardW, height = Dimens.photoCardH),
        shape = RoundedCornerShape(Dimens.radiusLg)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(item.drawableRes),
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(Dimens.radiusLg))
            )

            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .background(Color.Black.copy(alpha = 0.45f))
                    .padding(Dimens.gapMd)
            ) {
                Text(
                    text = item.title,
                    color = Color.White,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun CategoryChips(categories: List<CategoryItem>, modifier: Modifier = Modifier) {
    AppSection("Categorías") {
        LazyRow(horizontalArrangement = Arrangement.spacedBy(Dimens.gapSm)) {
            items(categories) { item ->
                CategoryChip(item)
            }
        }
    }
}

@Composable
fun AppSectionTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        modifier = modifier
    )
}

@Composable
fun CategoryChip(item: CategoryItem) {
    Surface(
        modifier = Modifier.clip(RoundedCornerShape(Dimens.radiusPill)),
        shape = RoundedCornerShape(Dimens.radiusPill),
        tonalElevation = 2.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = Dimens.gapMd, vertical = Dimens.gapSm)
        ) {
            Image(
                painter = painterResource(item.iconRes),
                contentDescription = item.name,
                modifier = Modifier.size(Dimens.iconSm)
            )
            Spacer(Modifier.width(Dimens.gapSm))
            Text(item.name, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun MunicipioInfo(info: List<InfoItem>, modifier: Modifier = Modifier) {
    AppSection("Información general", modifier) {
        AppCard {
            info.forEachIndexed { idx, item ->
                InfoRow(item)
                if (idx != info.lastIndex) {
                    Spacer(Modifier.height(Dimens.gapMd))
                }
            }
        }
    }
}

@Composable
fun InfoRow(item: InfoItem) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
        Text(
            text = "${item.label}: ",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.width(110.dp)
        )
        Text(
            text = item.value,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    radius: Dp = Dimens.radiusLg,
    padding: Dp = Dimens.gapLg,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(radius)
    ) {
        Column(modifier = Modifier.padding(padding), content = content)
    }
}

@Composable
fun BottomActions(
    onMore: () -> Unit,
    onHotels: () -> Unit,
    onRestaurants: () -> Unit
) {
    Surface(tonalElevation = 3.dp) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsPadding(WindowInsets.navigationBars)
                .padding(Dimens.bottomBarPadding),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = onMore) { Text("Más info") }
            Button(onClick = onHotels) { Text("Hoteles") }
            Button(onClick = onRestaurants) { Text("Restaurantes") }
        }
    }
}

@Composable
fun DynamicSection(section: BottomSection, onClose: () -> Unit) {
    if (section == BottomSection.NONE) return
    AppCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.screenPadding)
    ) {
        HeaderWithClose(
            title = when (section) {
                BottomSection.MORE_INFO -> "Más información"
                BottomSection.HOTELS -> "Hoteles"
                BottomSection.RESTAURANTS -> "Restaurantes"
                else -> ""
            },
            onClose = onClose
        )

        Spacer(Modifier.height(Dimens.gapSm))

        when (section) {
            BottomSection.MORE_INFO -> MoreInfoSection()
            BottomSection.HOTELS -> HotelsSection()
            BottomSection.RESTAURANTS -> RestaurantsSection()
            else -> {}
        }
    }
}


@Composable
fun MoreInfoSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(Dimens.gapSm)
    ) {
        InfoRow(InfoItem("Municipio", "Pátzcuaro, Michoacán."))
        InfoRow(InfoItem("Clima", "Templado, lluvias en verano."))
        InfoRow(InfoItem("Cómo moverse", "Taxi, combis, caminar en el centro."))
    }
}

@Composable
fun HotelsSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(Dimens.gapSm)
    )
    {
        MoreInfoCard("Hotel Centro", "Cerca de la plaza principal", "Desde $900 MXN")
        MoreInfoCard("Posada del Lago", "Vista al lago", "Desde $1,200 MXN")
        MoreInfoCard("Hostal Artesanal", "Económico y céntrico", "Desde $500 MXN")

    }
}

@Composable
fun RestaurantsSection() {
    Column(verticalArrangement = Arrangement.spacedBy(Dimens.gapSm)) {
        MoreInfoCard("Cocina Tradicional", "Corundas y atole", "★ 4.6")
        MoreInfoCard("Mariscos del Lago", "Charales y pescados", "★ 4.4")
        MoreInfoCard("Antojitos Doña Lupita", "Económico", "★ 4.5")
    }
}

@Composable
fun MoreInfoCard(name: String, desc: String, price: String) {
    AppCard(
        radius = Dimens.radiusMd,
        padding = Dimens.cardPadding
    ) {
        Text(name, style = MaterialTheme.typography.titleSmall)
        Text(desc, style = MaterialTheme.typography.bodySmall)
        Spacer(Modifier.height(Dimens.gapXs))
        Text(price, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun HeaderWithClose(title: String, onClose: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.weight(1f)
        )
        TextButton(onClick = onClose) { Text("Cerrar") }
    }
}


@Composable
fun AppSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(modifier = modifier.sectionPadding()) {
        Text(title, style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(Dimens.gapSm))
        content()
    }
}

@Preview(name = "Phone", device = "spec:width=411dp,height=891dp,dpi=420", showBackground = true)
@Preview(name = "Small", device = "spec:width=360dp,height=640dp,dpi=420", showBackground = true)
@Preview(name = "Tablet", device = "spec:width=1280dp,height=800dp,dpi=240", showBackground = true)
@Composable
fun PreviewMunicipioScreen() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MunicipioScreen()
        }
    }
}

@Preview(name = "Font 1.3x", fontScale = 1.3f, showBackground = true)
@Composable
fun PreviewFontScale() {
    TutorialsTheme { MunicipioScreen() }
}

@Preview(name = "Dark", uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewDark() {
    TutorialsTheme { MunicipioScreen() }
}



