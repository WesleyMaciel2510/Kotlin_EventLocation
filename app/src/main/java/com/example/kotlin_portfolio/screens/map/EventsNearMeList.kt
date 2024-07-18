@file:Suppress("IMPLICIT_CAST_TO_ANY")

package com.example.kotlin_portfolio.screens.map

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_portfolio.R
import com.example.kotlin_portfolio.components.buttons.IconAndLabelButton
import com.example.kotlin_portfolio.services.openGoogleMaps
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme

// Types ===================================
data class EventsNearMeItem(
    val imageRes: Int,
    val title: String,
    val local: String,
    val eventDate: String,
    val geolocation: Geolocation,
    val distance: String?
)

data class Geolocation(
    val latitude: Double,
    val longitude: Double
)
// ==========================================

val EventsNearMeItems = listOf(
    EventsNearMeItem(
        R.drawable.banner1,
        "Teatro - Dramaturgia: Branca de Neve",
        "Instituto Inhotim - Brumadinho, MG",
        "27JUN",
        Geolocation(-19.934251, -44.198421),
        ' '.toString()
    ),
    EventsNearMeItem(
        R.drawable.banner2,
        "Theater",
        "Museu do Amanhã - Rio de Janeiro",
        "12JUL",
        Geolocation(-22.894597, -43.181252),
        ' '.toString()

    ),
    EventsNearMeItem(
        R.drawable.banner3,
        "StandUp Comedy",
        "XV de Novembro, 789 - Curitiba, PR",
        "07JUL-08JUL",
        Geolocation(-25.428954, -49.267137),
        ' '.toString()
    ),
    EventsNearMeItem(
        R.drawable.banner4,
        "BlockBusters House ",
        "Instituto Inhotim - Brumadinho, MG",
        "14JUL-15JUL",
        Geolocation(-19.74833, -47.931941),
        ' '.toString()
    ),
    EventsNearMeItem(
        R.drawable.banner5,
        "Theater Show",
        "SESI - Uberaba - Minas Gerais",
        "14JUL-15JUL",
        Geolocation(-19.738988, -47.931486),
        ' '.toString()
    ),
    EventsNearMeItem(
        R.drawable.banner6,
        "Music Concert",
        "Praça Rui Barbosa - Uberaba, MG",
        "20JUL",
        Geolocation(-19.741074, -47.930611),
        ' '.toString()
    ),
    EventsNearMeItem(
        R.drawable.banner7,
        "Art Exhibition",
        "Centro de Cultura - Uberaba, MG",
        "22JUL-25JUL",
        Geolocation(-19.747875, -47.933277),
        ' '.toString()
    ),
    EventsNearMeItem(
        R.drawable.banner8,
        "Food Festival",
        "Parque Fernando Costa - Uberaba, MG",
        "28JUL",
        Geolocation(-19.736630, -47.940590),
        ' '.toString()

    ),
    EventsNearMeItem(
        R.drawable.banner9,
        "Book Fair",
        "Biblioteca Municipal - Uberaba, MG",
        "30JUL-31JUL",
        Geolocation(-19.748429, -47.930241),
        ' '.toString()

    ),
    EventsNearMeItem(
        R.drawable.banner10,
        "Dance Show",
        "Teatro Vera Cruz - Uberaba, MG",
        "03AUG",
        Geolocation(-19.746536, -47.933634),
        ' '.toString()

    ),
    EventsNearMeItem(
        R.drawable.banner11,
        "Film Festival",
        "Cine Vera - Uberaba, MG",
        "05AUG-06AUG",
        Geolocation(-19.750563, -47.934072),
        ' '.toString()

    ),
    EventsNearMeItem(
        R.drawable.banner12,
        "Tech Conference",
        "UNIUBE - Uberaba, MG",
        "10AUG",
        Geolocation(-19.749644, -47.930612),
        ' '.toString()

    ),
    EventsNearMeItem(
        R.drawable.banner13,
        "Science Fair",
        "Colégio José Ferreira - Uberaba, MG",
        "12AUG",
        Geolocation(-19.751224, -47.929217),
        ' '.toString()

    ),
    EventsNearMeItem(
        R.drawable.banner14,
        "Historical Tour",
        "Museu de Arte Sacra - Uberaba, MG",
        "15AUG",
        Geolocation(-19.747773, -47.932498),
        ' '.toString()

    ),
    EventsNearMeItem(
        R.drawable.banner15,
        "Sports Meet",
        "Estádio Uberabão - Uberaba, MG",
        "18AUG",
        Geolocation(-19.735736, -47.943343),
        ' '.toString()
    )
)

// ==========================================

@Composable
fun EventsNearMeList(
    modifier: Modifier = Modifier,
    events: List<EventsNearMeItem>,
    context: Context?,
    latitude: Double?,
    longitude: Double?,
    address: String?
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Location Detected Card
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .height(100.dp)
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                ){
                    Text(
                        text = "Location Detected",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .padding(top = 8.dp, end = 16.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Location Icon",
                        modifier = Modifier
                            .padding(start = 10.dp, end = 5.dp)
                            .align(Alignment.CenterVertically)
                    )
                }

                Text(
                    text = "Address: $address",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    textAlign = TextAlign.Start,
                )
            }
        }
        IconAndLabelButton(buttonLabel = "OpenMaps",
            buttonColor = Color.Black,
            onClick = {
                if (context != null) {
                    openGoogleMaps(context, latitude.toString(), longitude.toString(),
                        address.toString()
                    )
                }
            })

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
                modifier = Modifier.padding(start = 20.dp, bottom = 4.dp)
            )
            Spacer(
                modifier = Modifier
                    .width(330.dp)
                    .height(1.dp)
                    .background(color = Color.LightGray)
                    .padding(end = 20.dp)
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
                .padding(top = 10.dp, start = 1.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "${item.title} - Distance: ${item.distance}",
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
        val context = LocalContext.current
        val latitude =  -19.74833
        val longitude = -47.931941
        val address = "Ricardo Alberto dos Santos, 72, Alfredo Freire 3 - Uberaba MG"
        EventsNearMeList(context = context , events = EventsNearMeItems, latitude = latitude ,
            longitude = longitude, address = address)
    }
}
