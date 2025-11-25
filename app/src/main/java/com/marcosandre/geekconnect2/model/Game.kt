package com.marcosandre.geekconnect2.model

data class Game(
    val id: Int,
    val title: String,
    val rating: Double,
    val status: String,
    val coverUrl: String
)
