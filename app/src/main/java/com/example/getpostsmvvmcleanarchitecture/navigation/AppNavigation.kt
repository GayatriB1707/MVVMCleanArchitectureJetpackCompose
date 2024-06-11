package com.example.flowexample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core.routes.AppRoutes
import com.example.features.presentation.PostScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.POST_SCREEN.routeName
    ) {
        composable(AppRoutes.POST_SCREEN.routeName) {
            PostScreen()
        }
    }
}
