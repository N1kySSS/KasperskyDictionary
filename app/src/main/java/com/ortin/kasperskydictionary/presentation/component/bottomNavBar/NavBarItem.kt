package com.ortin.kasperskydictionary.presentation.component.bottomNavBar

import com.ortin.kasperskydictionary.R
import com.ortin.kasperskydictionary.presentation.navigation.ScreenRoutes

sealed class NavBarItem(
    val title: String,
    val route: String,
    val icon: Int
) {
    data object MainScreen: NavBarItem(
        title = "Перевод",
        route = ScreenRoutes.MAIN_SCREEN,
        icon = R.drawable.ic_translate
    )

    data object HistoryScreen: NavBarItem(
        title = "История",
        route = ScreenRoutes.HISTORY_SCREEN,
        icon = R.drawable.ic_history
    )

    data object FavouriteScreen: NavBarItem(
        title = "Избранное",
        route = ScreenRoutes.FAVOURITE_SCREEN,
        icon = R.drawable.ic_star
    )
}
