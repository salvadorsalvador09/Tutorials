package com.example.tutorials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tutorials.ui.theme.TutorialsTheme
import androidx.compose.material3.CardDefaults
import com.example.tutorials.data.DataSource
import com.example.tutorials.model.Pet
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TutorialsTheme {
                val pets = remember { DataSource().loadPets() }
                PetList(
                    pets = pets,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            WindowInsets.systemBars
                                .asPaddingValues())
                )
            }
        }
    }
}


@Composable
fun PetList(
    pets: List<Pet>,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()

    LazyColumn(
        modifier = modifier
                .fillMaxSize(),
        state = listState,
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 8.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(pets, key = { it.id }) { pet -> PetCard(pet) }
    }
}

@Composable
fun PetCard(pet: Pet, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(1.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = pet.foto),
                contentDescription = "Foto de ${pet.nombre}",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.width(12.dp))
            Column {
                Text(pet.nombre, style = MaterialTheme.typography.titleMedium)
                val subtitulo = remember(pet.especie, pet.genero, pet.edad) {
                    "${pet.especie} • ${pet.genero} • ${pet.edad} años"
                }
                Text(subtitulo)
                Text("Carácter: ${pet.caracter}")
                Text("Esterilizado: ${if (pet.esterilizado) "Sí" else "No"}")
            }
        }
    }
}


