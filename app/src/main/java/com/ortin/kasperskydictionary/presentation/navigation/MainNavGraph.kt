package com.ortin.kasperskydictionary.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ortin.kasperskydictionary.presentation.component.bottomNavBar.CustomNavBar
import com.ortin.kasperskydictionary.ui.theme.KasperskyDictionaryTheme

@Composable
fun MainNavGraph() {
    val navController = rememberNavController()

    KasperskyDictionaryTheme {
        Scaffold(
            bottomBar = {
                CustomNavBar(navController)
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = ScreenRoutes.MAIN_SCREEN_FLOW,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(innerPadding)
            ) {
                mainNavigation()
            }
        }
    }
}
