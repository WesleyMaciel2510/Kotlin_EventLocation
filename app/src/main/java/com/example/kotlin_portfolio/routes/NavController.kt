package com.example.kotlin_portfolio.routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlin_portfolio.screens.camera.CameraScreen
import com.example.kotlin_portfolio.screens.eventItem.EventItemScreen
import com.example.kotlin_portfolio.screens.home.HomeScreen
import com.example.kotlin_portfolio.screens.map.MapScreen
import com.example.kotlin_portfolio.screens.profile.ProfileScreen
import com.example.kotlin_portfolio.screens.wallet.WalletScreen

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "camera") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("map") {
            MapScreen(navController = navController, modifier = Modifier)
        }
        composable("eventItem/{eventInfo}") {
            val eventInfo = it.arguments?.getString("eventInfo") ?: "No Data Available"
            EventItemScreen(navController = navController, dataJson = eventInfo)
        }
        composable("profile/{codeInfo}") { backStackEntry ->
            val codeInfo = backStackEntry.arguments?.getString("codeInfo") ?: ""
            ProfileScreen(navController = navController, codeInfo = codeInfo)
        }
        composable("profile") {
            ProfileScreen(navController = navController, codeInfo = "")
        }
        composable("wallet") {
            WalletScreen(navController = navController)
        }
        composable("camera") {
            CameraScreen(navController = navController)
        }
    }
}
