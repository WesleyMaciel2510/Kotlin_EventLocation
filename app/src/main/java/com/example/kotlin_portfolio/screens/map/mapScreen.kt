package com.example.kotlin_portfolio.screens.map

import android.Manifest
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
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
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

@Composable
fun MapScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val image: Painter = painterResource(id = R.drawable.mapscreen_header)
    // Request Location
    var locationPermission: Boolean by remember { mutableStateOf(false) }
    Log.d("permission", "locationPermission = ${locationPermission}!")

    // Register for permission result
    val locationPermissionRequest = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        when {
            permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true -> {
                // Precise location access granted.
                Log.d("permission", "Precise location access granted!")
                locationPermission = true
            }
            permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true -> {
                // Approximate location access granted.
                Log.d("permission", "Approximate location access granted!")
                locationPermission = true
            }
            else -> {
                // No location access granted.
                Log.d("permission", "Location access NOT granted!")
                locationPermission = false
            }
        }
    }

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
        EventsNearMeList(events = EventsNearMeItems)
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
