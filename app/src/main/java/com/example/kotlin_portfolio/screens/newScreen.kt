package com.example.kotlin_portfolio.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme

@Composable
fun NewScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        // Your component content goes here
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewComponent() {
    Kotlin_PortfolioTheme {
        NewScreen()
    }
}
