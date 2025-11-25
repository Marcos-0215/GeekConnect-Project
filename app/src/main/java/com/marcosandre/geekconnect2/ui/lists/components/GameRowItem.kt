package com.marcosandre.geekconnect2.ui.lists.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.marcosandre.geekconnect2.model.Game

@Composable
fun GameRowItem(game: Game) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp)) {

            AsyncImage(
                model = game.coverUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(70.dp)
                    .aspectRatio(1f)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = game.title,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Rating estilizado
                val ratingText =
                    if (game.rating > 0) "⭐ ${game.rating}" else "Sem nota"

                Text(
                    text = ratingText,
                    fontSize = 14.sp
                )
            }
        }
    }
}
