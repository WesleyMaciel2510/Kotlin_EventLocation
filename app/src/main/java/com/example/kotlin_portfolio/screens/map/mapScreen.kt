package com.example.kotlin_portfolio.screens.map

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.R
import com.example.kotlin_portfolio.components.buttons.IconAndLabelButton
import com.example.kotlin_portfolio.services.getAddressFromLocation
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme
import com.example.kotlin_portfolio.ui.theme.LightColorScheme
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("MissingPermission")
@Composable
fun MapScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val image: Painter = painterResource(id = R.drawable.mapscreen_header)
    // Request Location
    var locationPermission by remember { mutableStateOf(false) }
    var address by remember { mutableStateOf("") }

    // get latlong
    val context = LocalContext.current
    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }
    var latitude by remember { mutableStateOf<Double?>(null) }
    var longitude by remember { mutableStateOf<Double?>(null) }

    fun getLastKnownLocation(fusedLocationClient: FusedLocationProviderClient) {
        Log.d("getLastKnownLocation", "@@@ getLastKnownLocation CALLED!")
        Log.d("getLastKnownLocation", "@@@ fusedLocationClient = $fusedLocationClient")

        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            Log.d("permission", "location = $location")

            location?.let {
                latitude = it.latitude
                longitude = it.longitude
                Log.d("address", "latitude = $latitude , longitude = $longitude")
            }
            fun fetchAddress(context: Context, latitude: Double, longitude: Double) {
                CoroutineScope(Dispatchers.Main).launch {
                    val result = getAddressFromLocation(context, latitude, longitude)
                    address = result ?: "No address found, check your GPS."
                    Log.d("address", "ADDRESS FOUND = $address")
                }
            }
            if (latitude != null && longitude != null) {
                fetchAddress(context, latitude!!, longitude!!)
            }
            }.addOnFailureListener { e ->
        Log.d("permission", "Failed to get location: ${e.message}")
    }
    }

    // Register for permission result
    val locationPermissionRequest = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        when {
            permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true -> {
                // Precise location access granted.
                Log.d("permission", "Precise location access granted!")
                locationPermission = true
                getLastKnownLocation(fusedLocationClient)

            }
            permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true -> {
                // Approximate location access granted.
                Log.d("permission", "Approximate location access granted!")
                locationPermission = true
                getLastKnownLocation(fusedLocationClient)
            }
            else -> {
                // No location access granted.
                Log.d("permission", "Location access NOT granted!")
                locationPermission = false
            }
        }
    }

    LaunchedEffect(true) {
        Log.d("permission", "@@@ locationPermission = $locationPermission")
        if (locationPermission) {
            getLastKnownLocation(fusedLocationClient)
        }
    }

    // Filter Near Events ==============================================================
    // Initialize filteredEvents as an empty list
    var filteredEvents: List<EventsNearMeItem> = emptyList()

    // Filter the nearest events before showing on the screen
    if (latitude != null && longitude != null) {
        filteredEvents = findNearestEvents(latitude, longitude)
        Log.d("Location", "############### FILTROOOOOUUU ########")
        Log.d("Location", "### filteredEvents = $filteredEvents")

    } else {
        // User needs to enable GPS,
        // Display all events and create a message to the user to enable GPS
        Log.d("Location", "Location Not Found, \nUnable to Filter Near Events ")
    }
    // Determine which list to pass to EventsNearMeList
    val eventsToShow = filteredEvents.ifEmpty { EventsNearMeItems }

    //======================================================

    if (!locationPermission) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(color = LightColorScheme.background)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = LightColorScheme.background)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Image(
                    painter = image,
                    contentDescription = "Header",
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = LightColorScheme.background),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Explore events near you",
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = LightColorScheme.tertiary,
                        ),
                        modifier = Modifier.padding(vertical = 20.dp)
                    )
                    Text(
                        //text = "lat = $latitude - long = $longitude ",
                        text = "Easily find events around you.\nUsing the map requires your location permission.",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Normal,
                            color = LightColorScheme.tertiary,
                        ),
                        modifier = Modifier
                            .padding(horizontal = 30.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(top = 10.dp),
                    ) {
                        IconAndLabelButton(
                            iconName = Icons.Default.Place,
                            buttonLabel = "Find Events Near Me",
                            buttonColor = LightColorScheme.primary,
                            onClick = {
                                Log.d("permission", "RequestLocationButton Clicked!")
                                locationPermissionRequest.launch(
                                    arrayOf(
                                        Manifest.permission.ACCESS_FINE_LOCATION,
                                        Manifest.permission.ACCESS_COARSE_LOCATION
                                    )
                                )
                            }
                        )
                    }
                    Column(
                        modifier = Modifier
                    ) {
                        IconAndLabelButton(
                            buttonLabel = "Choose your city manually",
                            buttonColor = LightColorScheme.secondary,
                            onClick = {
                                Log.d("permission", "cityButton Clicked!")
                            }
                        )
                    }
                }
            }
        }
    } else {
        /*Text("latitude = $latitude,\n" +
                "            longitude = $longitude")*/
        EventsNearMeList(
            events = eventsToShow,
            context = context,
            latitude = latitude,
            longitude = longitude,
            address = address
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewComponent() {
    val navController = rememberNavController()
    Kotlin_PortfolioTheme {
        MapScreen(navController = navController)
    }
}
