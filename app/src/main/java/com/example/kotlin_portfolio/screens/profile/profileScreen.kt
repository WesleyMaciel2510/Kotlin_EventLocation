package com.example.kotlin_portfolio.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
fun ProfileScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                // Left: Circular Image
                Box(
                    modifier = Modifier
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
                    Text(
                        text = "Wesley Maciel",
                        style = TextStyle(
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = LightColorScheme.outline,
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "wesleymaciel2500@gmail.com",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }
            Column(
                modifier = Modifier.padding(vertical = 30.dp)
            ) {
                IconAndLabelButton(
                    buttonLabel = "Edit Your Profile",
                    buttonColor = LightColorScheme.primary,
                    onClick = { /*TODO*/ })
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "My Account",
                    style = TextStyle(
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold,
                        color = LightColorScheme.outline,
                    ),
                    modifier = Modifier.padding(bottom = 30.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Icon(Icons.Default.Lock, contentDescription = "Lock Icon")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Change Password")
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
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Icon(Icons.Default.Notifications, contentDescription = "Notifications Icon")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Notifications")
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
                    modifier = Modifier.padding(vertical = 20.dp)
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

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    val navController = rememberNavController()
    Kotlin_PortfolioTheme {
        ProfileScreen(navController = navController)
    }
}
