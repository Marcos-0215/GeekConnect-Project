package com.marcosandre.geekconnect2.ui.lists

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marcosandre.geekconnect2.viewmodel.ListsViewModel
import com.marcosandre.geekconnect2.ui.lists.components.GameRowItem

@Composable
fun WishlistList(viewModel: ListsViewModel) {

    LazyColumn(modifier = Modifier.padding(12.dp)) {
        items(viewModel.wishlist) { game ->
            GameRowItem(game)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
