package com.marcosandre.geekconnect2.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marcosandre.geekconnect2.model.NotificationItem


private val GCBackground = Color(0xFF0D0D0D)
private val GCSurface = Color(0xFF1A1A1A)
private val GCSurfaceLight = Color(0xFF222222)
private val GCPrimary = Color(0xFF6A5ACD)
private val GCTextPrimary = Color(0xFFFFFFFF)
private val GCTextSecondary = Color(0xFFB0B0B0)
private val GCBorder = Color(0x33FFFFFF)

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
                    message = "Você adicionou Hollow Knight: Silksong à Wishlist.",
                    date = "3 dias atrás",
                    icon = android.R.drawable.ic_input_add
                )
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GCBackground)
            .padding(16.dp)
    ) {

        // BOTÃO “MARCAR TUDO COMO LIDO”

        OutlinedButton(
            onClick = { notifications = emptyList() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = GCPrimary
            )
        ) {
            Text("Marcar tudo como lido")
        }

        Spacer(modifier = Modifier.height(14.dp))

        if (notifications.isEmpty()) {
            EmptyNotificationsPlaceholder()
            return
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(notifications) { item ->
                NotificationRow(item)
            }
        }
    }
}

@Composable
fun NotificationRow(item: NotificationItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = GCSurfaceLight),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, GCBorder)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = null,
                tint = GCPrimary,
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.message,
                    fontSize = 16.sp,
                    color = GCTextPrimary
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = item.date,
                    fontSize = 12.sp,
                    color = GCTextSecondary
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
            .background(GCBackground)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = null,
            tint = GCTextSecondary,
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Nenhuma notificação por aqui...",
            fontSize = 18.sp,
            color = GCTextPrimary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Continue explorando o GeekConnect!",
            fontSize = 14.sp,
            color = GCTextSecondary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNotificationsPage() {
    NotificationsPage()
}
