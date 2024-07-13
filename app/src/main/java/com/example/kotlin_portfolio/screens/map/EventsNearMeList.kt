package com.example.kotlin_portfolio.screens.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_portfolio.R
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme

data class EventsNearMeItem(
    val imageRes: Int,
    val title: String,
    val local: String,
    val eventDate: String
)

val EventsNearMeItems = listOf(
    EventsNearMeItem(
        R.drawable.banner1,
        "BlockBusters House",
        "Instituto Inhotim - Brumadinho, MG",
        "2024-07-10"
    ),
    EventsNearMeItem(
        R.drawable.banner2,
        "Theater",
        "Museu do Amanhã - Rio de Janeiro",
        "12JUL"
    ),
    EventsNearMeItem(
        R.drawable.banner3,
        "StandUp Comedy",
        "Rua XV de Novembro, 789 - Curitiba, PR",
        "07JUL-08JUL"
    ),
    EventsNearMeItem(
        R.drawable.banner4,
        "Online Events",
        "press to see the website",
        "14JUL-15JUL"
    ),
    EventsNearMeItem(
        R.drawable.banner5,
        "Theater Show",
        "SESI - Uberaba - Minas Gerais",
        "14JUL-15JUL"
    ),
)

@Composable
fun EventsNearMeList(
    modifier: Modifier = Modifier,
    events: List<EventsNearMeItem>
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Location Detected Card
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            Column(
                modifier = Modifier.padding(12.dp)
                    .height(70.dp)
            ) {
                Text(
                    text = "Location Detected",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 1.dp),
                    textAlign = TextAlign.Start,
                )
                Text(
                    text = "Elevated",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 4.dp),
                    textAlign = TextAlign.Start,
                )
            }
        }

        // Events Near You Section
        Column(
            modifier = Modifier.padding(start = 20.dp, top = 30.dp)
        ) {
            Text(
                text = "Events Near You",
                style = TextStyle(
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                ),
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = Color.LightGray)
            )

            Column {
                events.forEach { event ->
                    EventNearMeItemView(item = event)
                }
            }
        }
    }
}

@Composable
fun EventNearMeItemView(item: EventsNearMeItem) {
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
                modifier = Modifier.padding(bottom = 8.dp)
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
fun PreviewEventsNearMeList() {
    Kotlin_PortfolioTheme {
        EventsNearMeList(events = EventsNearMeItems)
    }
}
