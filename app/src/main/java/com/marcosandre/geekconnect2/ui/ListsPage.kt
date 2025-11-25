package com.marcosandre.geekconnect2.ui


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.marcosandre.geekconnect2.viewmodel.ListsViewModel

import com.marcosandre.geekconnect2.ui.lists.PlayingList
import com.marcosandre.geekconnect2.ui.lists.CompletedList
import com.marcosandre.geekconnect2.ui.lists.WishlistList
import com.marcosandre.geekconnect2.ui.lists.FavoritesList



@Composable
fun ListsPage(modifier: Modifier = Modifier, viewModel: ListsViewModel) {

    var selectedTab by remember { mutableStateOf(0) }

    val tabs = listOf("Jogando", "Zerados", "Wishlist", "Favoritos")

    TabRow(selectedTabIndex = selectedTab) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = selectedTab == index,
                onClick = { selectedTab = index },
                text = { Text(title) }
            )
        }
    }

    when (selectedTab) {
        0 -> PlayingList(viewModel)
        1 -> CompletedList(viewModel)
        2 -> WishlistList(viewModel)
        3 -> FavoritesList(viewModel)
    }
}