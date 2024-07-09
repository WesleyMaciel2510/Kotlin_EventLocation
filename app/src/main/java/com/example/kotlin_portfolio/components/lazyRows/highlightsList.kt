package com.example.kotlin_portfolio.components.lazyRows

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_portfolio.R
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

data class HightLighItem(
    val imageRes: Int,
    val title: String,
    val local: String,
    val eventDate: String
)

val HightLightItems = listOf(
    HightLighItem(
        R.drawable.banner5,
        "BlockBusters House",
        "Instituto Inhotim - Brumadinho, MG",
        "2024-07-10"
    ),
    HightLighItem(
        R.drawable.banner6,
        "Theater",
        "Museu do Amanhã - Rio de Janeiro",
        "12JUL"
    ),
    HightLighItem(
        R.drawable.banner7,
        "StandUp Comedy",
        "Rua XV de Novembro, 789 - Curitiba, PR",
        "07JUL-08JUL"
    ),
    HightLighItem(
        R.drawable.banner8,
        "Online Events",
        "press to see the website",
        "14JUL-15JUL"
    ),
    HightLighItem(
        R.drawable.banner9,
        "Theater Show",
        "SESI - Uberaba - Minas Gerais",
        "14JUL-15JUL"
    ),
    HightLighItem(
        R.drawable.banner10,
        "Theater Show",
        "SESI - Uberaba - Minas Gerais",
        "21JUL-13JUL"
    ),
)

@Composable
fun HightLighLazyRow(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = LightColorScheme.background)
            .padding(15.dp)
    ) {
        Text(
            text = "Highlight Events",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = LightColorScheme.outline,
            ),
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 5.dp)
                .align(Alignment.Start)
        )
        LazyRow(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(HightLightItems) { item ->
                HightLighItemView(item)
            }
        }
    }
}

@Composable
fun HightLighItemView(item: HightLighItem) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .padding(end = 10.dp)
    ) {
        val image: Painter = painterResource(id = item.imageRes)
        Image(
            painter = image,
            contentDescription = item.title,
            modifier = Modifier
                .width(300.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = item.title,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                ),
                modifier = Modifier.
                padding(bottom = 8.dp)

            )
            Text(
                text = item.local,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                ),
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Date: ${item.eventDate}",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFC96908),
                ),
                modifier = Modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHightLighLazyRow() {
    HightLighLazyRow()
}
