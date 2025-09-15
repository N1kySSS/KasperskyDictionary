package com.ortin.kasperskydictionary.presentation.component.bottomNavBar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ortin.kasperskydictionary.presentation.navigation.ScreenRoutes
import com.ortin.kasperskydictionary.presentation.utils.clickableWithoutIndication
import com.ortin.kasperskydictionary.ui.theme.Purple40

@Composable
fun CustomNavBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    
    val navBarItems = listOf(
        NavBarItem.MainScreen,
        NavBarItem.HistoryScreen,
        NavBarItem.FavouriteScreen
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .border(
                width = 1.dp,
                color = Color.LightGray
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        navBarItems.forEach {
            Column(
                modifier = Modifier.clickableWithoutIndication {
                    navController.navigate(it.route) {
                        popUpTo(ScreenRoutes.MAIN_SCREEN) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = ImageVector.vectorResource(it.icon),
                    contentDescription = "Icon",
                    tint = if (currentRoute == it.route) Purple40 else Color.Black
                )
                Text(
                    text = it.title,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        letterSpacing = 0.sp,
                        textAlign = TextAlign.Center,
                        color = if (currentRoute == it.route) Purple40 else Color.Black,
                    )
                )
            }
        }
    }
}
