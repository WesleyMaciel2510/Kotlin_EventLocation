package com.example.kotlin_portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.routes.AppNavigation
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

@Composable
fun App(startDestination: String = "home") {
    val navController = rememberNavController()
    Scaffold(
        // add here what is fixed
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = LightColorScheme.background)
                .padding(bottom = 10.dp)
        ) {
            AppNavigation(navController = navController, modifier = Modifier.weight(1f))
        }
    }
}