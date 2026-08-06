package com.example.myapplication

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Premium Color Palette
private val Charcoal = Color(0xFF1E1E1E)
private val OffWhite = Color(0xFFF9F9F9)
private val GoldAccent = Color(0xFFC5A880)

@Composable
fun HomeScreen(onShowGreeting: (String) -> Unit) {
    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(OffWhite)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome",
            fontFamily = FontFamily.Serif,
            fontSize = 32.sp,
            color = Charcoal,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = {
                Text(
                    text = "Enter your name",
                    fontFamily = FontFamily.Serif
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(4.dp), // Sharper corners for a formal look
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Charcoal,
                unfocusedBorderColor = Color.Gray,
                cursorColor = Charcoal,
                focusedLabelColor = Charcoal
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(32.dp))

        Button(
            onClick = { onShowGreeting(name) },
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Charcoal,
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) {
            Text(
                text = "SHOW GREETING",
                fontFamily = FontFamily.Serif,
                fontSize = 14.sp,
                letterSpacing = 1.5.sp
            )
        }
    }
}

@Composable
fun GreetingScreen(userName: String, onNavigateBack: () -> Unit) {
    // Elegant fallback if the text field was left empty
    val displayName = if (userName.isNotBlank()) userName else "Guest"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(OffWhite)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Charcoal,
                contentColor = OffWhite
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Hello, $displayName!",
                    fontFamily = FontFamily.Serif,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    color = GoldAccent,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Text(
                    text = "Welcome to Jetpack Navigation.",
                    fontFamily = FontFamily.Serif,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    lineHeight = 28.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(48.dp))

        OutlinedButton(
            onClick = onNavigateBack,
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Charcoal
            ),
            border = BorderStroke(1.dp, Charcoal),
            modifier = Modifier
                .height(48.dp)
                .padding(horizontal = 32.dp)
        ) {
            Text(
                text = "GO BACK",
                fontFamily = FontFamily.Serif,
                letterSpacing = 1.5.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}