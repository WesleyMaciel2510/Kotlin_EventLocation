package com.example.kotlin_portfolio.screens.wallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_portfolio.R

data class FinishedEventsItem(
    val imageRes: Int,
    val title: String,
    val local: String,
    val eventDate: String
)

val FinishedEventsItems = listOf(
    FinishedEventsItem(
        R.drawable.banner11,
        "Art Exhibition",
        "Museum of Modern Art - São Paulo, SP",
        "20JUN"
    ),
    FinishedEventsItem(
        R.drawable.banner12,
        "Music Concert",
        "Allianz Parque - São Paulo, SP",
        "15APR"
    ),
    FinishedEventsItem(
        R.drawable.banner13,
        "Comedy Show",
        "Teatro Riachuelo - Natal, RN",
        "02JUL-03JUL"
    ),
    FinishedEventsItem(
        R.drawable.banner14,
        "Tech Conference",
        "Centro de Convenções - Recife, PE",
        "10JUL-11JUL"
    ),
    FinishedEventsItem(
        R.drawable.banner15,
        "Food Festival",
        "Parque da Cidade - Brasília, DF",
        "08JUL-10JUL"
    ),
)

@Composable
fun FinishedEventsList(
    modifier: Modifier = Modifier,
    events: List<FinishedEventsItem>,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier.padding(start = 20.dp, top = 30.dp)
        ) {
            Text(
                text = "Finished Events",
                style = TextStyle(
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .align(Alignment.CenterHorizontally),
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
            )

            Column {
                events.forEach { event ->
                    FinishedEventsItemView(item = event)
                }
            }
        }
    }
}

@Composable
fun FinishedEventsItemView(item: FinishedEventsItem) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .padding(vertical = 8.dp, horizontal = 20.dp)
            .fillMaxWidth()
    ) {
        val image: Painter = painterResource(id = item.imageRes)
        Image(
            painter = image,
            contentDescription = item.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(15.dp))
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
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = item.local,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    ),
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Date: ${item.eventDate}",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFC96908),
                ),
                modifier = Modifier
            )
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun PreviewFinishedEventsList() {
    FinishedEventsList(
        events = FinishedEventsItems,
        latitude = null,
        longitude = null
    )
}*/
