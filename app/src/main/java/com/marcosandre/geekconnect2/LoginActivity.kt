package com.marcosandre.geekconnect2

import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marcosandre.geekconnect2.ui.theme.GeekConnect2Theme


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GeekConnect2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginPage(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPage(modifier: Modifier = Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val activity = LocalActivity.current as Activity
    val geekPurple = Color(0xFF7C4DFF)

    Column(
        modifier = modifier
            .padding(24.dp)
            .fillMaxSize()
            .background(Color(0xFF121212)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "GeekConnect",
            fontSize = 32.sp,
            color = Color.White
        )

        Text(
            text = "Seu diário geek em um só lugar",
            fontSize = 16.sp,
            color = Color(0xFFBBBBBB)
        )

        Spacer(modifier = modifier.size(32.dp))

        OutlinedTextField(
            value = email,
            label = { Text(text = "Digite seu e-mail", color = Color(0xFFCCCCCC)) },
            textStyle = LocalTextStyle.current.copy(color = Color.White),
            modifier = modifier.fillMaxWidth(fraction = 0.9f),
            onValueChange = { email = it }
        )

        Spacer(modifier = modifier.size(12.dp))

        OutlinedTextField(
            value = password,
            label = { Text(text = "Digite sua senha", color = Color(0xFFCCCCCC)) },
            modifier = modifier.fillMaxWidth(fraction = 0.9f),
            textStyle = LocalTextStyle.current.copy(color = Color.White),
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = modifier.size(20.dp))

        Row(modifier = modifier) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = geekPurple
                ),
                onClick = {
                Toast.makeText(activity, "Login OK!", Toast.LENGTH_LONG).show()

                activity.startActivity(
                    Intent(activity, MainActivity::class.java).setFlags(
                        FLAG_ACTIVITY_SINGLE_TOP
                    )
                )

            },
                enabled = email.isNotEmpty() && password.isNotEmpty()
            ) {
                Text("Login")
            }

            Spacer(modifier = modifier.size(16.dp))

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF333333)
                ),
                onClick = { email = ""; password = "" }
            )

            {
                Text("Limpar")
            }
        }

        Spacer(modifier = modifier.size(8.dp))

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = geekPurple
            ),
            onClick = {
            activity.startActivity(
                Intent(activity, RegisterActivity::class.java).setFlags(
                    FLAG_ACTIVITY_SINGLE_TOP
                )
            )
        },

            ) {
            Text("Registrar")
        }

    }
}