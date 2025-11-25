package com.marcosandre.geekconnect2.ui

import android.app.Activity
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults.outlinedButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfilePage() {

    val activity = LocalActivity.current as Activity

    // Dados mockados do usuário
    val userName = "Marcos André"
    val userEmail = "marcos@example.com"
    val userBio = "Apreciador de games, trilhas sonoras e tecnologia!"

    // Estatísticas mock
    val stats = remember {
        listOf(
            "Jogando" to 5,
            "Zerados" to 8,
            "Favoritos" to 3,
            "Wishlist" to 6
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // ------------------------------
        // 1. AVATAR + INFORMAÇÕES
        // ------------------------------
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(60.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(userName, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text(userEmail, fontSize = 14.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            "\"$userBio\"",
            fontSize = 14.sp,
            color = Color.LightGray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // ------------------------------
        // 2. ESTATÍSTICAS
        // ------------------------------
        Text(
            "Suas estatísticas",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            stats.forEach { (label, value) ->
                StatCard(label, value)
            }
        }

        Spacer(modifier = Modifier.height(26.dp))

        // ------------------------------
        // 3. PREFERÊNCIAS GEEK
        // ------------------------------
        Text(
            "Preferências",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(12.dp))

        PreferenceItem("Gêneros favoritos", "RPG, Soulslike, Ação")
        PreferenceItem("Plataforma preferida", "PC")
        PreferenceItem("Último jogo jogado", "Hades II")
        PreferenceItem("Humor atual", "🔥 Pronto para grindar!")

        Spacer(modifier = Modifier.height(24.dp))

        // ------------------------------
        // 4. BOTÃO DE SAIR
        // ------------------------------
        OutlinedButton(
            onClick = { activity.finish() },
            modifier = Modifier.fillMaxWidth(),
            colors = outlinedButtonColors(
                contentColor = MaterialTheme.colorScheme.error
            )
        ) {
            Text("Sair da conta")
        }
    }
}

// --------------------------------------------------------------------------
// COMPONENTES SIMPLES (tudo no mesmo arquivo, como você pediu)
// --------------------------------------------------------------------------

@Composable
fun StatCard(label: String, value: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.25f)
        )
    ) {
        Row(
            Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(label, fontSize = 16.sp)
            Text(value.toString(), fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun PreferenceItem(title: String, desc: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.15f))
            .padding(12.dp)
    ) {
        Text(title, fontSize = 14.sp, color = Color.Gray)
        Text(desc, fontSize = 16.sp, fontWeight = FontWeight.Medium)
    }

    Spacer(modifier = Modifier.height(10.dp))
}
