package com.example.kotlin_portfolio.screens.wallet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.components.tabs.TabComponent
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

@Composable
fun WalletScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .background(color = LightColorScheme.outline)
                .fillMaxWidth()
                .padding(horizontal = 7.dp, vertical = 20.dp)
        ) {
            Text(
                text = "Wallet",
                style = TextStyle(
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    color = LightColorScheme.background
                ),
                modifier = Modifier.padding(start = 15.dp)
            )
        }
        Column(modifier = Modifier) {
            TabComponent(
                contentActive = {
                    ContentActive()
                    /*IconAndLabelButton(
                        buttonLabel = "ShareData",
                        buttonColor = LightColorScheme.primary,
                        onClick = {
                            viewModel.updateCodeInfo("1234567890ABCD")
                        })
                    Text(text= "Updated Info = $codeInfo")*/
                },
                contentClosed = {
                    ContentClosed()
                }
            )
        }
    }
}

@Composable
fun ContentActive() {
    //create if else to check if the user has tickets
    NoTicketsView()
    //TicketsView()
}

@Composable
fun ContentClosed() {
    FinishedEventsList(
        events = FinishedEventsItems)
}

@Preview(showBackground = true)
@Composable
fun PreviewWalletScreen() {
    val navController = rememberNavController()
    Kotlin_PortfolioTheme {
        WalletScreen(navController = navController)
    }
}
