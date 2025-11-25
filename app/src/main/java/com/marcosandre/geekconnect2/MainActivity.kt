package com.marcosandre.geekconnect2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.marcosandre.geekconnect2.ui.nav.BottomNavBar
import com.marcosandre.geekconnect2.ui.nav.BottomNavItem
import com.marcosandre.geekconnect2.ui.nav.MainNavHost
import com.marcosandre.geekconnect2.ui.nav.Route
import com.marcosandre.geekconnect2.ui.theme.GeekConnect2Theme
import com.marcosandre.geekconnect2.viewmodel.ListsViewModel


@Composable
fun getTopBarTitle(currentRoute: String?): String {

    return when (currentRoute) {

        // ROTAS TIPADAS (Kotlin Serialization)
        Route.Home::class.qualifiedName -> "GeekConnect"
        Route.Lists::class.qualifiedName -> "Listas"
        Route.Notifications::class.qualifiedName -> "Notificações"
        Route.Profile::class.qualifiedName -> "Perfil"

        // fallback
        else -> "GeekConnect"
    }
}

@OptIn(ExperimentalMaterial3Api::class)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val viewModel : ListsViewModel by viewModels()

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            val dynamicTitle = getTopBarTitle(currentRoute)

            GeekConnect2Theme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(dynamicTitle) },

                            actions = {

                                IconButton( onClick = { finish() } ) {
                                    Icon(
                                        imageVector =
                                            Icons.AutoMirrored.Filled.ExitToApp,
                                        contentDescription = "Localized description"
                                    )
                                }
                            }
                        )
                    },

                    bottomBar = {
                        val items = listOf(
                            BottomNavItem.HomeButton,
                            BottomNavItem.ListsButton,
                            BottomNavItem.NotificationsButton,
                            BottomNavItem.ProfileButton,

                            )

                        BottomNavBar(navController = navController, items)

                    },

                    floatingActionButton = {

                        FloatingActionButton(onClick = { }) {
                            Icon(Icons.Default.Add, contentDescription = "Adicionar")
                        }
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        MainNavHost(navController = navController,
                            viewModel = viewModel)
                    }
                }
            }
        }
    }
}