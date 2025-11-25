package com.marcosandre.geekconnect2.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.marcosandre.geekconnect2.model.Game

@Composable
fun ListsPage() {

    // -------------------------------
    // 1) MOCK LOCAL DAS LISTAS
    // -------------------------------
    val playingList = remember {
        mutableStateListOf(
            Game(
                id = 1,
                title = "Elden Ring",
                rating = 9.5,
                status = "playing",
                coverUrl = "https://images.igdb.com/igdb/image/upload/t_cover_big/co4jni.png"
            ),
            Game(
                id = 2,
                title = "Hades II",
                rating = 9.2,
                status = "playing",
                coverUrl = "https://images.igdb.com/igdb/image/upload/t_cover_big/co8x0b.png"
            )
        )
    }

    val completedList = remember {
        mutableStateListOf(
            Game(
                id = 3,
                title = "The Witcher 3",
                rating = 9.7,
                status = "completed",
                coverUrl = "https://images.igdb.com/igdb/image/upload/t_cover_big/co1r06.png"
            )
        )
    }

    val wishlist = remember {
        mutableStateListOf(
            Game(
                id = 4,
                title = "Hollow Knight: Silksong",
                rating = 0.0,
                status = "wishlist",
                coverUrl = "https://images.igdb.com/igdb/image/upload/t_cover_big/co6g52.png"
            )
        )
    }

    val favorites = remember {
        mutableStateListOf(
            Game(
                id = 1,
                title = "Elden Ring",
                rating = 9.5,
                status = "favorite",
                coverUrl = "https://images.igdb.com/igdb/image/upload/t_cover_big/co4jni.png"
            )
        )
    }

    // -------------------------------
    // 2) TABS
    // -------------------------------
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Jogando", "Zerados", "Wishlist", "Favoritos")

    Column(Modifier.fillMaxSize()) {

        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }

        // -------------------------------
        // 3) CONTEÚDO DA TELA
        // -------------------------------
        when (selectedTab) {
            0 -> GamesList(playingList)
            1 -> GamesList(completedList)
            2 -> GamesList(wishlist)
            3 -> GamesList(favorites)
        }
    }
}

@Composable
fun GamesList(games: List<Game>) {
    LazyColumn(modifier = Modifier.padding(12.dp)) {
        items(games) { game ->
            GameRowItem(game = game)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun GameRowItem(game: Game) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(modifier = Modifier.padding(12.dp)) {

            AsyncImage(
                model = game.coverUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .aspectRatio(1f)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(Modifier.weight(1f)) {
                Text(game.title, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = if (game.rating > 0) "⭐ ${game.rating}" else "Sem avaliação",
                    fontSize = 14.sp
                )
            }
        }
    }
}
