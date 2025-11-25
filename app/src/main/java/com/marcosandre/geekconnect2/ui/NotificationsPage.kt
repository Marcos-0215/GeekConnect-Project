package com.marcosandre.geekconnect2.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marcosandre.geekconnect2.model.NotificationItem

@Composable
fun NotificationsPage() {

    var notifications by remember {
        mutableStateOf(
            listOf(
                NotificationItem(
                    message = "Você marcou Elden Ring como favorito.",
                    date = "2h atrás",
                    icon = android.R.drawable.star_big_on
                ),
                NotificationItem(
                    message = "The Witcher 3 foi concluído com sucesso!",
                    date = "1 dia atrás",
                    icon = android.R.drawable.ic_menu_info_details
                ),
                NotificationItem(
                    message = "Você adicionou Hollow Knight: Silksong na sua Wishlist.",
                    date = "3 dias atrás",
                    icon = android.R.drawable.ic_input_add
                )
            )
        )
    }

    // Se a lista estiver vazia: Placeholder bonito
    if (notifications.isEmpty()) {
        EmptyNotificationsPlaceholder()
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {

        // 🔘 Botão "Marcar tudo como lido"
        Button(
            onClick = { notifications = emptyList() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        ) {
            Text("Marcar tudo como lido")
        }

        LazyColumn {
            items(notifications) { item ->
                NotificationRow(item)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun NotificationRow(item: NotificationItem) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {

            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.message,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = item.date,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun EmptyNotificationsPlaceholder() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Nenhuma notificação por aqui...",
            fontSize = 18.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Continue explorando o GeekConnect!",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNotificationsPage() {
    NotificationsPage()
}