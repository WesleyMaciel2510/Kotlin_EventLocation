package com.example.kotlin_portfolio.screens.map

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme

@Composable
fun EventsNearMeList(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        //
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEventsNearMeList() {
    Kotlin_PortfolioTheme {
        EventsNearMeList()
    }
}