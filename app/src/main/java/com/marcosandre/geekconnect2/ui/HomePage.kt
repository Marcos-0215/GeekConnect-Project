package com.marcosandre.geekconnect2.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.marcosandre.geekconnect2.R

@Preview(showBackground = true)
@Composable
fun HomePage(modifier: Modifier = Modifier) {

    val geekPurple = Color(0xFF7C4DFF)

    // DADOS DE EXEMPLO (simulados em memória)
    val playingGames = listOf(
        GameCardData("Red Dead Redemption 2", R.drawable.placeholder_game, "80%"),
        GameCardData("Mass Effect Trilogy", R.drawable.placeholder_game, "30%"),
        GameCardData("The Long Dark", R.drawable.placeholder_game, "40%"),
        GameCardData("Half Life", R.drawable.placeholder_game, "50%")
    )

    val recommendedGames = listOf(
        GameCardData("Zelda: Breadth of the Wild", R.drawable.placeholder_game, "97"),
        GameCardData("The Last of Us 2", R.drawable.placeholder_game, "90"),
        GameCardData("Ghost of Tsushima", R.drawable.placeholder_game, "92")
    )

    val recentActivities = listOf(
        "Você zerou Frostpunk 🎉",
        "Adicionou Elden Ring à Wishlist",
        "Jogou Slay the Spire há 155dias"
    )

    // TELA PRINCIPAL
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp)
    ) {

        // SAUDAÇÃO
        Text(
            text = "Olá, geek! 👋",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(Modifier.height(24.dp))

        // CONTINUAR JOGANDO
        HomeSectionTitle("Continuar jogando")
        LazyRow {
            items(playingGames) { game ->
                PlayingGameCard(game)
            }
        }

        Spacer(Modifier.height(24.dp))

        // RECOMENDADOS
        HomeSectionTitle("Recomendados para você")
        LazyRow {
            items(recommendedGames) { game ->
                RecommendedGameCard(game)
            }
        }

        Spacer(Modifier.height(28.dp))

        // ATALHOS RÁPIDOS
        HomeSectionTitle("Atalhos rápidos")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            QuickActionButton("Favoritos")
            QuickActionButton("Listas")
            QuickActionButton("Notificações")
        }

        Spacer(Modifier.height(28.dp))

        // ÚLTIMAS ATIVIDADES
        HomeSectionTitle("Últimas atividades")
        recentActivities.forEach { activity ->
            Text(
                text = "• $activity",
                color = Color(0xFFCCCCCC),
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 6.dp)
            )
        }
    }
}

@Composable
fun HomeSectionTitle(text: String) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.White,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

data class GameCardData(
    val title: String,
    val imageRes: Int,
    val extra: String // progresso ou nota
)

@Composable
fun PlayingGameCard(data: GameCardData) {
    Card(
        modifier = Modifier
            .padding(end = 12.dp)
            .width(150.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E))
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = data.imageRes),
                contentDescription = data.title,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(8.dp))
            Text(text = data.title, color = Color.White, fontSize = 16.sp)
            Text(text = "Progresso: ${data.extra}", color = Color(0xFFBBBBBB), fontSize = 14.sp)
        }
    }
}

@Composable
fun RecommendedGameCard(data: GameCardData) {
    Card(
        modifier = Modifier
            .padding(end = 12.dp)
            .width(150.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E))
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = data.imageRes),
                contentDescription = data.title,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(8.dp))
            Text(text = data.title, color = Color.White, fontSize = 16.sp)
            Text(text = "Nota: ${data.extra}", color = Color(0xFFBBBBBB), fontSize = 14.sp)
        }
    }
}

@Composable
fun QuickActionButton(text: String) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C4DFF))
    ) {
        Text(text = text)
    }
}