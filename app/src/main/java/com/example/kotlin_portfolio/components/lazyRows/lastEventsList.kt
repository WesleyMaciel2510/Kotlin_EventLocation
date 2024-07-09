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

data class LastEventItem(
    val imageRes: Int,
    val title: String,
    val local: String,
    val eventDate: String
)

val LastEventItems = listOf(
    LastEventItem(
        R.drawable.banner1,
        "BlockBusters House",
        "Instituto Inhotim - Brumadinho, MG",
        "2024-07-10"
    ),
    LastEventItem(
        R.drawable.banner2,
        "Theater",
        "Museu do Amanhã - Rio de Janeiro",
        "12JUL"
    ),
    LastEventItem(
        R.drawable.banner3,
        "StandUp Comedy",
        "Rua XV de Novembro, 789 - Curitiba, PR",
        "07JUL-08JUL"
    ),
    LastEventItem(
        R.drawable.banner4,
        "Online Events",
        "press to see the website",
        "14JUL-15JUL"
    ),
    LastEventItem(
        R.drawable.banner5,
        "Theater Show",
        "SESI - Uberaba - Minas Gerais",
        "14JUL-15JUL"
    ),
)

@Composable
fun LastEventLazyRow(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = LightColorScheme.background)
            .padding(15.dp)
    ) {
        Text(
            text = "Most Visited Events in the Last 24h !",
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
            items(LastEventItems) { item ->
                LastEventItemView(item)
            }
        }
    }
}

@Composable
fun LastEventItemView(item: LastEventItem) {
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
fun PreviewLastEventLazyRow() {
    LastEventLazyRow()
}
