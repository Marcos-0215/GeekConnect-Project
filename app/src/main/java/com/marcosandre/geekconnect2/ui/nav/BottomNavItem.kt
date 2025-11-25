package com.marcosandre.geekconnect2.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Home : Route
    @Serializable
    data object Lists : Route
    @Serializable
    data object Notifications : Route
    @Serializable
    data object Profile : Route
}
sealed class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val route: Route)
{
    data object HomeButton :
        BottomNavItem("Home", Icons.Default.Home, Route.Home)
    data object ListsButton :
        BottomNavItem("Listas", Icons.Default.List, Route.Lists)
    data object NotificationsButton  :
        BottomNavItem("Notificações", Icons.Default.Notifications, Route.Notifications)
    data object ProfileButton :
        BottomNavItem("Perfil", Icons.Default.Person, Route.Profile)
}