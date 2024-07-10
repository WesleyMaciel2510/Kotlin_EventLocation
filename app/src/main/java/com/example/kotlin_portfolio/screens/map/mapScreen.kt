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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
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
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

@Composable
fun MapScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val image: Painter = painterResource(id = R.drawable.mapscreen_header)
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
// REQUEST LOCATION ===============================================
    val context = LocalContext.current

    // Register for permission result
    val locationPermissionRequest = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        when {
            permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true -> {
                // Precise location access granted.
                Log.d("permission", "Precise location access granted!")
            }
            permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true -> {
                // Approximate location access granted.
                Log.d("permission", "Approximate location access granted!")
                // Handle your logic here
            }
            else -> {
                // No location access granted.
                Log.d("permission", "Location access NOT granted!")
                // Handle your logic here
            }
        }
    }
// ================================================================
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = LightColorScheme.background)
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
                .padding(top = screenHeight / 2)
                .background(color = LightColorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Explore Events\n      near you",
                style = TextStyle(
                    fontSize = 30.sp,
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
                modifier = Modifier.padding(horizontal = 40.dp)
            )
            Column(
                modifier = Modifier
                    .padding(top = 30.dp),
            ){
                IconAndLabelButton(
                    iconName = Icons.Default.Place,
                    buttonLabel = "Find Events Near Me",
                    buttonColor = LightColorScheme.primary,
                    onClick = {
                        Log.d("permission", "RequestLocationlButton Clicked!")
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
            ){
                IconAndLabelButton(
                    buttonLabel = "Choose your city manually",
                    buttonColor = LightColorScheme.secondary,
                    onClick = { /* Handle button click */ }
                )
            }
        }
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
