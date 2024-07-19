package com.example.kotlin_portfolio.screens.eventItem

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme

@Composable
fun EventItemScreen(modifier: Modifier = Modifier, navController: NavHostController, eventInfo: String) {
    Column(modifier = modifier) {
        Text("EventItemScreen")
        Text("valor de eventInfo recebido = $eventInfo")

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEventItemScreen() {
    val navController = rememberNavController()
    Kotlin_PortfolioTheme {
        EventItemScreen(navController = navController, eventInfo = "")
    }

}
