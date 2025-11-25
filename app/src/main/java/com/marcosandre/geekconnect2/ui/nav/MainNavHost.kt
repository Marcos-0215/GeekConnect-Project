package com.marcosandre.geekconnect2.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marcosandre.geekconnect2.ui.HomePage
import com.marcosandre.geekconnect2.ui.ListsPage
import com.marcosandre.geekconnect2.ui.NotificationsPage
import com.marcosandre.geekconnect2.ui.ProfilePage


@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = Route.Home) {
        composable<Route.Home> { HomePage() }
        composable<Route.Lists> { ListsPage() }
        composable<Route.Notifications> { NotificationsPage() }
        composable<Route.Profile> { ProfilePage() }
    }
}