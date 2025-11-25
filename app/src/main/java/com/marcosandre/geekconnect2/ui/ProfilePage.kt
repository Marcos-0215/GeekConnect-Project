package com.marcosandre.geekconnect2.ui

import android.app.Activity
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
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

// ----------------------
// CORES PERSONALIZADAS DO GEEKCONNECT
// ----------------------
private val GCBackground = Color(0xFF0D0D0D)         // preto fosco
private val GCSurface = Color(0xFF1A1A1A)            // cinza escuro
private val GCSurfaceLight = Color(0xFF222222)       // cinza um pouco mais claro
private val GCPrimary = Color(0xFF6A5ACD)            // roxo/azul "geek"
private val GCTextPrimary = Color(0xFFFFFFFF)        // branco
private val GCTextSecondary = Color(0xFFB0B0B0)      // cinza claro
private val GCBorder = Color(0x33FFFFFF)             // branco 20%

@Composable
fun ProfilePage() {

    val activity = LocalActivity.current as Activity

    val userName = "Marcos André"
    val userEmail = "marcos@example.com"
    val userBio = "Apaixonado por games, música e tecnologia."

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
            .background(GCBackground)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // --------------------------
        // AVATAR
        // --------------------------
        Box(
            modifier = Modifier
                .size(110.dp)
                .clip(CircleShape)
                .background(GCPrimary.copy(alpha = 0.25f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Avatar",
                tint = GCPrimary,
                modifier = Modifier.size(60.dp)
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        // --------------------------
        // INFORMAÇÕES DO USUÁRIO
        // --------------------------
        Text(
            userName,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = GCTextPrimary
        )

        Text(
            userEmail,
            fontSize = 14.sp,
            color = GCTextSecondary
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            "\"$userBio\"",
            fontSize = 14.sp,
            color = GCTextSecondary
        )

        Spacer(modifier = Modifier.height(28.dp))

        // --------------------------
        // ESTATÍSTICAS
        // --------------------------
        SectionTitle("Suas estatísticas")

        Spacer(modifier = Modifier.height(12.dp))

        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            stats.forEach { (label, value) ->
                StatCard(label, value)
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // --------------------------
        // PREFERÊNCIAS
        // --------------------------
        SectionTitle("Preferências")

        Spacer(modifier = Modifier.height(12.dp))

        PreferenceItem("Gêneros favoritos", "RPG, Soulslike, Ação")
        PreferenceItem("Plataforma preferida", "PC")
        PreferenceItem("Último jogo jogado", "Hades II")
        PreferenceItem("Humor atual", "🔥 Pronto para grindar!")

        Spacer(modifier = Modifier.height(30.dp))

        // --------------------------
        // BOTÃO DE SAIR
        // --------------------------
        OutlinedButton(
            onClick = { activity.finish() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Red
            ),
            border = ButtonDefaults.outlinedButtonBorder.copy(
                brush = ButtonDefaults.outlinedButtonBorder.brush
            )
        ) {
            Text("Sair da conta")
        }
    }
}

// --------------------------------------------
// COMPONENTES DA TELA (com cores personalizadas)
// --------------------------------------------

@Composable
fun SectionTitle(text: String) {
    Text(
        text,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        color = GCPrimary
    )
}

@Composable
fun StatCard(label: String, value: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = GCSurfaceLight
        ),
        border = BorderStroke(1.dp, GCBorder)
    ) {
        Row(
            Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(label, fontSize = 15.sp, color = GCTextPrimary)
            Text(
                value.toString(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = GCPrimary
            )
        }
    }
}

@Composable
fun PreferenceItem(title: String, desc: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(GCSurfaceLight.copy(alpha = 0.8f))
            .padding(14.dp)
    ) {
        Text(title, fontSize = 13.sp, color = GCTextSecondary)
        Spacer(modifier = Modifier.height(3.dp))
        Text(desc, fontSize = 15.sp, fontWeight = FontWeight.Medium, color = GCTextPrimary)
    }

    Spacer(modifier = Modifier.height(10.dp))
}
