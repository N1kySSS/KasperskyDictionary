package com.ortin.kasperskydictionary.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ortin.kasperskydictionary.presentation.screen.FavouriteScreen
import com.ortin.kasperskydictionary.presentation.screen.HistoryScreen
import com.ortin.kasperskydictionary.presentation.screen.TranslateScreen

fun NavGraphBuilder.mainNavigation() {
    navigation(
        startDestination = ScreenRoutes.MAIN_SCREEN,
        route = ScreenRoutes.MAIN_SCREEN_FLOW
    ) {
        composable(ScreenRoutes.MAIN_SCREEN) {
            TranslateScreen()
        }
        composable(ScreenRoutes.HISTORY_SCREEN) {
            HistoryScreen()
        }
        composable(ScreenRoutes.FAVOURITE_SCREEN) {
            FavouriteScreen()
        }
    }
}
