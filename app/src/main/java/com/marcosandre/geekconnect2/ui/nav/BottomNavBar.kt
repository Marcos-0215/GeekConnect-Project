package com.marcosandre.geekconnect2.ui.nav

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(navController: NavHostController, items : List<BottomNavItem>) {
    val geekPurple = Color(0xFF7C4DFF)
    NavigationBar(
        containerColor = Color(0xFF1A1A1A),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination
        items.forEach { item ->
            NavigationBarItem (
                icon = { Icon(imageVector = item.icon, contentDescription= item.title)},

                label = { Text(text = item.title, fontSize = 12.sp) },

                alwaysShowLabel = true,

                selected = currentRoute == item.route,

                onClick = {
                    navController.navigate(item.route) {
// Volta pilha de navegação até HomePage (startDest).
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) {
                                saveState = true
                            }
                            restoreState = true
                        }

                        launchSingleTop = true

                    }
                },

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = geekPurple,
                    selectedTextColor = geekPurple,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color(0xFF262626)
                )
            )
        }
    }
}