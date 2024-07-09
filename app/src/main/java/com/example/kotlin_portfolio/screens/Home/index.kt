package com.example.kotlin_portfolio.screens.home

import SearchHeaderBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = LightColorScheme.background)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(color = LightColorScheme.background)
        ) {
            SearchHeaderBar(
                searchText = searchText,
                onSearchTextChanged = { newText -> searchText = newText },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Text(
            text = "Welcome to HomeScreen!",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    Kotlin_PortfolioTheme {
        HomeScreen(navController = navController)
    }
}

