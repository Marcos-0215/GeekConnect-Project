package com.marcosandre.geekconnect2.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.marcosandre.geekconnect2.model.Game

class ListsViewModel : ViewModel() {

    val playingList = mutableStateListOf<Game>()
    val completedList = mutableStateListOf<Game>()
    val wishlist = mutableStateListOf<Game>()
    val favorites = mutableStateListOf<Game>()

    init {
        // Simulação até conectar com API
        playingList.add(
            Game(
                id = 1,
                title = "Elden Ring",
                rating = 9.5,
                status = "playing",
                coverUrl = "https://images.igdb.com/igdb/image/upload/t_cover_big/co4jni.png"
            )
        )

        playingList.add(
            Game(
                id = 2,
                title = "Hades II",
                rating = 9.2,
                status = "playing",
                coverUrl = "https://images.igdb.com/igdb/image/upload/t_cover_big/co8x0b.png"
            )
        )

        completedList.add(
            Game(
                id = 3,
                title = "The Witcher 3",
                rating = 9.7,
                status = "completed",
                coverUrl = "https://images.igdb.com/igdb/image/upload/t_cover_big/co1r06.png"
            )
        )

        wishlist.add(
            Game(
                id = 4,
                title = "Hollow Knight: Silksong",
                rating = 0.0,
                status = "wishlist",
                coverUrl = "https://images.igdb.com/igdb/image/upload/t_cover_big/co6g52.png"
            )
        )

        favorites.add(
            Game(
                id = 1,
                title = "Elden Ring",
                rating = 9.5,
                status = "favorite",
                coverUrl = "https://images.igdb.com/igdb/image/upload/t_cover_big/co4jni.png"
            )
        )
    }
}
