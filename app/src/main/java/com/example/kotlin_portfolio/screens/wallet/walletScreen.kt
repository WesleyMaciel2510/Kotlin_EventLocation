package com.example.kotlin_portfolio.screens.wallet

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme

@Composable
fun WalletScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    Box(modifier = modifier) {
        // Your component content goes here
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWalletScreen() {
    val navController = rememberNavController()
    Kotlin_PortfolioTheme {
        WalletScreen(navController = navController)
    }
}
