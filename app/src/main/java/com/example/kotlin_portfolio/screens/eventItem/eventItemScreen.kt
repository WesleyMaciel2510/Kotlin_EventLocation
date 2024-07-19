package com.example.kotlin_portfolio.screens.eventItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

@Composable
fun EventItemScreen(modifier: Modifier = Modifier, navController: NavHostController, eventInfo: String) {
    //val event = deserializeEvent(eventInfo)
    //val imageResId = event.imageRes

    Column(modifier = modifier) {
        Column(modifier = modifier
            .verticalScroll(rememberScrollState())
        ) {
            Image(
                //painter = painterResource(id = imageResId),
                painterResource(id = R.drawable.banner1),
                contentDescription = "description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                )
            Text(
                text = "Highlight Events",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = LightColorScheme.outline,
                ),
                modifier = Modifier
                    .padding(top = 20.dp, start = 22.dp)
                    .align(Alignment.Start)
            )
            Spacer(
                modifier = Modifier
                    .width(330.dp)
                    .height(3.dp)
                    .background(color = Color.Gray)
                    .padding(start = 20.dp, end = 20.dp)
            )
        }
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
