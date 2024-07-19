/*
package com.example.kotlin_portfolio.screens.map

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
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

@Composable
fun SelectCityManually(modifier: Modifier = Modifier, ) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .background(color = LightColorScheme.outline)
                .fillMaxWidth()
                .padding(horizontal = 7.dp, vertical = 20.dp)
        ) {
            Text(
                text = "Select Your City Manually",
                style = TextStyle(
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    color = LightColorScheme.background
                ),
                modifier = Modifier.padding(start = 15.dp)
            )
        }
        Column(
            modifier = Modifier
        ) {
            Text("SelectCityManuallyScreen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSelectCityManually() {
    Kotlin_PortfolioTheme {
        SelectCityManually()
    }
}*/
