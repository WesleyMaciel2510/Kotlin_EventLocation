package com.example.kotlin_portfolio.screens.map

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kotlin_portfolio.components.buttons.IconAndLabelButton
import com.example.kotlin_portfolio.services.openGoogleMaps
import com.example.kotlin_portfolio.ui.theme.LightColorScheme
import com.example.kotlin_portfolio.utils.AllEventsItem
import com.example.kotlin_portfolio.utils.serializeEvent

@Composable
fun EventsNearMe(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    context: Context?,
    latitude: Double?,
    longitude: Double?,
    address: String?,
) {
    var itemPressed by remember { mutableStateOf<Int?>(null) }
    var locationPressed by remember { mutableStateOf("") }

    // Filter Near Events ==============================================================
    // Initialize filteredEvents as an empty list
    var filteredEvents: List<AllEventsItem> = emptyList()

    // Filter the nearest events before showing on the screen
    if (latitude != null && longitude != null) {
        filteredEvents = findNearestEvents(latitude, longitude)
        Log.d("Location", "### filteredEvents = $filteredEvents")

    } else {
        // User needs to enable GPS,
        // Display all events and create a message to the user to enable GPS
        Log.d("Location", "Location Not Found, \nUnable to Filter Near Events ")
    }
    // Determine which list to pass to EventsNearMe
    Log.d("Item", "@ filteredEvents = $filteredEvents")

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
        IconAndLabelButton(buttonLabel = "Open Google Maps",
            buttonColor = LightColorScheme.secondary,
            onClick = {
                if (context != null) {
                    openGoogleMaps(context, latitude.toString(), longitude.toString(),
                        locationPressed
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
                filteredEvents.forEachIndexed { index, event ->
                    EventNearMeItemView(
                        item = event,
                        isSelected = itemPressed == index,
                        onClick = {
                            val eventJson = serializeEvent(event)

                            Log.d("Item", "@ GO TO EVENT DETAILS")
                            Log.d("Item", "@ ITEM PRESSED = $event")
                            Log.d("Item", "@ EVENT JSON = $eventJson")

                            navController.navigate("eventItem/$eventJson" )
                        },

                        onLongPress = {
                            itemPressed = index
                            locationPressed = event.local
                            Log.d("Item", "@ ITEM PRESSED = $event")
                            Log.d("Item", "@ LOCATION OF EVENT PRESSED = ${event.local}")
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun EventNearMeItemView(item: AllEventsItem,isSelected: Boolean, onClick: () -> Unit, onLongPress: () -> Unit) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .padding(vertical = 20.dp, horizontal = 20.dp)
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { onClick() },
                    onLongPress = { onLongPress() }
                )
            }
    ) {
        val image: Painter = painterResource(id = item.imageRes)
        Image(
            painter = image,
            contentDescription = item.title,
            modifier = Modifier
                .width(300.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(
                    width = 5.dp,
                    color = if (isSelected) LightColorScheme.secondary else Color.Transparent,
                    shape = RoundedCornerShape(10.dp)
                )
        )
        Column(
            modifier = Modifier
                .padding(top = 10.dp, start = 1.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "${item.title} \nDistance: ${item.distance}",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                ),
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .widthIn(max = 300.dp)
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

/*@Preview(showBackground = true)
@Composable
fun PreviewEventsNearMe() {
    Kotlin_PortfolioTheme {
        val navController = rememberNavController()

        val context = LocalContext.current
        val latitude =  -19.74833
        val longitude = -47.931941
        val address = "Ricardo Alberto dos Santos, 72, Alfredo Freire 3 - Uberaba MG"
        EventsNearMeList(context = context , events = EventsNearMeItems, latitude = latitude ,
            longitude = longitude, address = address, navController = navController)
    }
}*/
