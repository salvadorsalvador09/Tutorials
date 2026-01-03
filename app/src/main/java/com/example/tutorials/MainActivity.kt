package com.example.tutorials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.tutorials.ui.theme.TutorialsTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.annotations.Async


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TutorialsTheme {
                Surface(
                    content = {
                        StraggeredGrid()
                    }
                )
            }

        }
    }
}

@Composable
fun ScheduleCard(number: Int, name: String, time: String, modifier: Modifier = Modifier)
{
    OutlinedCard (
        modifier= Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        border = BorderStroke(1.dp, color = Color.Gray),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.DarkGray
        )
    ){
        Row (
            modifier = Modifier.padding(10.dp)
        ){
            Text(text = number.toString(),
                fontSize =  100.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(
                        top = 0.dp,
                        start = 8.dp,
                        end = 8.dp,
                        bottom = 0.dp
                    )
                )
            Column (
                modifier = Modifier.weight(1f)
            ){
                Text(
                    text = name,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(
                            top = 16.dp,
                            start = 8.dp,
                            end = 8.dp,
                            bottom = 4.dp
                        )
                )
                Text(
                    text = time ,
                     fontSize =  40.sp,
                    modifier = Modifier
                        .padding(
                            top = 4.dp,
                            start =  8.dp,
                            end = 8.dp,
                            bottom = 16.dp
                        )
                )
                Canvas(
                    modifier = Modifier
                        .size(16.dp),
                    onDraw = {
                        drawCircle(color = Color(0x29, 0x6e, 0xB4))
                    }
                )
            }
        }
    }
}


private const val strings = "Capilla del Rosario"

@Composable
fun ScheduleList(){
    val busStops = arrayOf(
        stringResource(R.string.capilla_del_rosario),
        stringResource(R.string.catedral_de_puebla),
        stringResource(R.string.callej_n_de_los_sapos),
        stringResource(R.string.mercado_el_pari_n),
        stringResource(R.string.barrio_del_artista),
        stringResource(R.string.fuertes_de_loreto),
        stringResource(R.string.convento_secreto_de_sana_m_nica),
        stringResource(R.string.casa_del_alfe_ique),
        stringResource(R.string.casa_de_los_mu_ecos),
        stringResource(R.string.museo_nacional_de_los_ferrocarriles_mexicanos),
    )
    val schedules = arrayOf(
        stringResource(R.string._9_00_am),
        stringResource(R.string._9_15_am),
        stringResource(R.string._9_30_am),
        stringResource(R.string._9_45_am),

        stringResource(R.string._10_00_am),
        stringResource(R.string._10_15_am),
        stringResource(R.string._10_30_am),
        stringResource(R.string._10_45_am),

        stringResource(R.string._11_00_am),
        stringResource(R.string._11_15_am),
        stringResource(R.string._11_30_am),
        stringResource(R.string._11_45_am),

        stringResource(R.string._12_00_pm),
        stringResource(R.string._12_15_pm),
        stringResource(R.string._12_30_pm),
        stringResource(R.string._12_45_pm),

        stringResource(R.string._1_00_pm),
        stringResource(R.string._1_15_pm),
        stringResource(R.string._1_30_pm),
        stringResource(R.string._1_45_pm),

        stringResource(R.string._2_00_pm),
        stringResource(R.string._2_15_pm),
        stringResource(R.string._2_30_pm),
        stringResource(R.string._2_45_pm),

        stringResource(R.string._3_00_pm),
        stringResource(R.string._3_15_pm),
        stringResource(R.string._3_30_pm),
        stringResource(R.string._3_45_pm),

        stringResource(R.string._4_00_pm),
        stringResource(R.string._4_15_pm),
        stringResource(R.string._4_30_pm),
        stringResource(R.string._4_45_pm),

        stringResource(R.string._5_00_pm),
        stringResource(R.string._5_15_pm),
        stringResource(R.string._5_30_pm),
        stringResource(R.string._5_45_pm),

        stringResource(R.string._6_00_pm),
        stringResource(R.string._6_15_pm),
        stringResource(R.string._6_30_pm),
        stringResource(R.string._6_45_pm),

        stringResource(R.string._7_00_pm)
    )

    LazyColumn {
        items(schedules.size) { index ->
            ScheduleCard(index + 1, busStops[index%busStops.size],
                schedules[index])
        }
    }

}



@Composable
private fun StraggeredGrid()
{

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(3),
        verticalItemSpacing = 4.dp
    ) {

    }
}




@Preview(showBackground =  true)
@Composable
fun SchedulePreview() {
    TutorialsTheme {
        ScheduleList()
    }
}




