package com.example.kotlin_portfolio.screens.profile

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kotlin_portfolio.R
import com.example.kotlin_portfolio.components.buttons.IconAndLabelButton
import com.example.kotlin_portfolio.ui.theme.LightColorScheme
import com.example.kotlin_portfolio.views.CodeInfoViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: CodeInfoViewModel? = null) {

    val currentCodeInfo by (viewModel?.codeInfo ?: mutableStateOf(""))

    //Camera Permission
    val cameraPermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)

    Box(modifier = modifier) {
        Column(
            modifier = Modifier
        ) {
            Column(
                modifier = modifier
            ) {
                Row(
                    modifier = Modifier
                        .background(color = LightColorScheme.outline)
                        .fillMaxWidth()
                        .padding(horizontal = 7.dp, vertical = 20.dp)
                ) {
                    Text(
                        text = "Profile",
                        style = TextStyle(
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = LightColorScheme.background
                        ),
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                // Left: Circular Image
                Box(
                    modifier = Modifier
                        .padding(start = 25.dp, top = 20.dp)
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .border(1.dp, Color(0xFF494A52), CircleShape)
                        .background(Color(0xFF2F77bd), shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    val image =
                        painterResource(id = R.drawable.user1)
                    Image(
                        painter = image,
                        contentDescription = "Profile Picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(65.dp)
                            .clip(CircleShape)
                            .align(Alignment.Center)
                            .offset(x = (-2).dp)
                    )
                }

                // Right: Column with Texts
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(text = "Wesley Maciel", style = TextStyle(
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = LightColorScheme.outline,
                        ), modifier = Modifier.padding(bottom = 4.dp))
                    Text(
                        text = "wesleymaciel2500@gmail.com",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )
                }
            }
            Column(
                modifier = Modifier.padding(top = 30.dp)
            ) {
                IconAndLabelButton(
                    buttonLabel = "Edit Your Profile",
                    buttonColor = LightColorScheme.primary,
                    onClick = { /*TODO*/ })
                IconAndLabelButton(
                    buttonLabel = "Read QRCode",
                    buttonColor = LightColorScheme.primary,
                    onClick = {
                        if (cameraPermissionState.status.isGranted) {
                            Log.d("camera", "Permission GRANTED: Go to camera screen")
                            navController.navigate("camera")
                        } else if (cameraPermissionState.status.shouldShowRationale) {
                            // Permission has been denied previously, but can be explained
                            // Optionally, show a rationale for needing the permission
                            Log.d("camera", "Permission rationale should be shown")

                        } else {
                            // Permission has not been granted yet, request it
                            cameraPermissionState.launchPermissionRequest()
                        }
                    }

                )
                Text(
                    text = currentCodeInfo.ifEmpty { "No code information available" },
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = LightColorScheme.outline,
                    ),
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                )
            }
            Column(
                modifier = Modifier
                    //.fillMaxSize()
                    .padding(horizontal = 15.dp)
            ) {
                Text(
                    text = "My Account",
                    style = TextStyle(
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold,
                        color = LightColorScheme.outline,
                    ),
                    modifier = Modifier.padding(bottom = 30.dp, start = 16.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp)
                ) {
                    Icon(Icons.Default.Lock, contentDescription = "Lock Icon")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Change Password",
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(Icons.Default.PlayArrow, contentDescription = "Arrow Icon")
                }

                // Gray Dash Separator
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp)
                        .height(1.dp)
                        .background(color = Color.LightGray)
                )

                // Second Row: Notifications
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp)
                ) {
                    Icon(Icons.Default.Notifications, contentDescription = "Notifications Icon")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Notifications",
                        color = Color.Black
                        )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(Icons.Default.PlayArrow, contentDescription = "Arrow Icon")
                }

                // Gray Dash Separator
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp)
                        .height(1.dp)
                        .background(color = Color.LightGray)
                )

                // Logout Button below Notifications
                Column(
                    modifier = Modifier.padding(vertical = 10.dp)
                ) {
                    IconAndLabelButton(
                        buttonLabel = "Logout Your Account",
                        buttonColor = Color(0xFFd13d32),
                        onClick = { /*TODO*/ })
                }
            }
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    val navController = rememberNavController()
    Kotlin_PortfolioTheme {
        ProfileScreen(navController = navController)
    }
}*/
