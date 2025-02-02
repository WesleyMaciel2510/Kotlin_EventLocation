package com.example.kotlin_portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    var selectedIcon by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = LightColorScheme.outline),
        horizontalArrangement = Arrangement.Center
    ) {
        IconButtonWithLabel(
            icon = Icons.Default.Home,
            label = "Home",
            iconColor = if (selectedIcon == "Home") LightColorScheme.primary else LightColorScheme.secondary,
            onClick = { selectedIcon = "Home" }
        )
        IconButtonWithLabel(
            icon = Icons.Default.Place,
            label = "Map",
            iconColor = if (selectedIcon == "Map") LightColorScheme.primary else LightColorScheme.secondary,
            onClick = { selectedIcon = "Map" }
        )
        IconButtonWithLabel(
            icon = Icons.Default.Favorite,
            label = "Favorites",
            iconColor = if (selectedIcon == "Favorites") LightColorScheme.primary else LightColorScheme.secondary,
            onClick = { selectedIcon = "Favorites" }
        )
        IconButtonWithLabel(
            icon = Icons.Default.Person,
            label = "Profile",
            iconColor = if (selectedIcon == "Profile") LightColorScheme.primary else LightColorScheme.secondary,
            onClick = { selectedIcon = "Profile" }
        )
        IconButtonWithLabel(
            icon = Icons.Filled.AccountBox,
            label = "Wallet",
            iconColor = if (selectedIcon == "Wallet") LightColorScheme.primary else LightColorScheme.secondary,
            onClick = { selectedIcon = "Wallet" }
        )
    }
}

@Composable
fun IconButtonWithLabel(
    icon: ImageVector,
    label: String,
    iconColor: Color,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(12.dp)
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier.height(52.dp),
            content = {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = iconColor
                )
            }
        )
        Text(
            text = label,
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(vertical = 2.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomNavigationBar() {
    Kotlin_PortfolioTheme {
        BottomNavigationBar()
    }
}
