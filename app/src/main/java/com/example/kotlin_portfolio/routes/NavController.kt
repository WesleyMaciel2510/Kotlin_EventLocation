package com.example.kotlin_portfolio.routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlin_portfolio.screens.home.HomeScreen
import com.example.kotlin_portfolio.screens.map.MapScreen

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("map") {
            MapScreen(navController = navController)
        }
    }
}
