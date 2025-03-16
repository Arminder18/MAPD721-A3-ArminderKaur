package com.amrinder.assignment3demo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

//class AnimationApp {
//}

@Composable
fun AnimationApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController = navController)
        }
        composable("screen1") {
            AnimatedContentScreen(navController = navController)
        }
        composable("screen2") {
            ValueBasedAnimationScreen(navController = navController)
        }
        composable("screen3") {
            ValueBasedAnimationScreen2(navController = navController)
        }
        composable("screen4") {
            GestureBasedAnimationScreen(navController = navController)
        }
    }
}