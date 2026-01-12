package com.example.tutorials

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EqualizerView(viewModel : AudioEqualizerViewModel)
{
    val xAxisLabels = listOf("60Hz", "230Hz", "910Hz", "3kHz", "14kHz")
    val maxLength = xAxisLabels.maxByOrNull { it.length }?.length ?:0
    val audioEffects by viewModel.audioEffects.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer{
                rotationZ = 270f
            },
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (index in xAxisLabels.indices)
        {
            Row (
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(220.dp)
            ){
                Box{
                    val paddedLabel = xAxisLabels[index].padStart(maxLength, ' ')
                    Text(
                        text = paddedLabel,
                        modifier = Modifier
                            .wrapContentWidth()
                            .align (Alignment.CenterStart)
                            .rotate(90f),
                        color = Color.White,
                        fontSize = 8.sp,
                        textAlign = TextAlign.Start
                    )
                    Slider(
                        modifier = Modifier
                            .offset(x = 20.dp),
                        value = audioEffects!!.gainValue[index].times(1000f).toFloat()
                            .coerceIn(-3000f, 3000f),
                        valueRange = -3000f..3000f,
                        onValueChange = {
                            viewModel.onBandLevelChanged(index, it.toInt())
                        },
                        colors = SliderDefaults.colors(
                            thumbColor =  Color.Black,
                            activeTrackColor = Color.Black,
                            inactiveTrackColor = Color.White
                        ),
                        thumb = {
                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .border(
                                        1.dp,
                                        Color.White,
                                        CircleShape
                                    )
                                    .clip(CircleShape)
                                    .background(Color.Black, CircleShape)
                            )
                        }
                    )
                }
            }
        }
    }
}