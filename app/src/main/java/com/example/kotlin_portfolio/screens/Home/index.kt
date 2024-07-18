package com.example.kotlin_portfolio.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.components.ColumnEvents
import com.example.kotlin_portfolio.components.headers.SearchHeaderBar
import com.example.kotlin_portfolio.components.lazyRows.EventTypeLazyRow
import com.example.kotlin_portfolio.components.lazyRows.HightLighLazyRow
import com.example.kotlin_portfolio.components.lazyRows.LastEventLazyRow
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme
import com.example.kotlin_portfolio.ui.theme.LightColorScheme
import com.example.kotlin_portfolio.utils.generateRandomRangeWithInterval

@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier) {
var searchText by remember { mutableStateOf(TextFieldValue("")) }

    val (start, end) = generateRandomRangeWithInterval(1, 30, 5,10)

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
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
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(color = LightColorScheme.background)
        ) {
            EventTypeLazyRow()
            LastEventLazyRow()
            HightLighLazyRow()
            ColumnEvents(
                title = "Upcoming Events",
                start = start,
                end = end
            )
        }
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

