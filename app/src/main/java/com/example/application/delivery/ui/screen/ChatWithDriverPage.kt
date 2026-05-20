package com.example.application.delivery.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.application.R
import com.example.application.global.ui.component.BackButton
import com.example.application.global.ui.theme.BlackSoft
import com.example.application.global.ui.theme.BluePrimary
import com.example.application.global.ui.theme.WhiteSoft

@Composable
fun ChatWithDriverPage(
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            ChatHeader(onBack = onBack)
        },
        bottomBar = {
            ChatInput()
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(WhiteSoft),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "23 April 2026, 12:00 WIB",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
            items(chatMessages) { message ->
                ChatBubble(message)
            }
        }
    }
}

@Composable
fun ChatHeader(onBack: () -> Unit) {
    Surface(
        color = BluePrimary,
        modifier = Modifier.fillMaxWidth().statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BackButton(onClick = onBack)
            Spacer(modifier = Modifier.width(12.dp))
            Image(
                painter = painterResource(id = R.drawable.dummy),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Kyle",
                    color = WhiteSoft,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "AD 6767 SP (Honda Beat)",
                    color = WhiteSoft.copy(alpha = 0.8f),
                    fontSize = 12.sp
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_orderstatus),
                    contentDescription = "Call",
                    tint = WhiteSoft,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun ChatBubble(message: MessageData) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (message.isFromUser) Alignment.End else Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .widthIn(max = 280.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 12.dp,
                        topEnd = 12.dp,
                        bottomStart = if (message.isFromUser) 12.dp else 0.dp,
                        bottomEnd = if (message.isFromUser) 0.dp else 12.dp
                    )
                )
                .background(if (message.isFromUser) BluePrimary else Color.White)
                .border(
                    width = if (message.isFromUser) 0.dp else 1.dp,
                    color = if (message.isFromUser) Color.Transparent else Color.LightGray,
                    shape = RoundedCornerShape(
                        topStart = 12.dp,
                        topEnd = 12.dp,
                        bottomStart = if (message.isFromUser) 12.dp else 0.dp,
                        bottomEnd = if (message.isFromUser) 0.dp else 12.dp
                    )
                )
                .padding(12.dp)
        ) {
            Text(
                text = message.text,
                color = if (message.isFromUser) WhiteSoft else BlackSoft,
                fontSize = 14.sp
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = message.time,
            fontSize = 10.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun ChatInput() {
    Surface(
        tonalElevation = 8.dp,
        color = WhiteSoft,
        modifier = Modifier.navigationBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Message...", fontSize = 14.sp) },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(25.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(24.dp)
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.LightGray
                )
            )
        }
    }
}

data class MessageData(
    val text: String,
    val time: String,
    val isFromUser: Boolean
)

val chatMessages = listOf(
    MessageData("Hello, I'm your driver. I've received your order!", "12:00 WIB", false),
    MessageData("I'm on the way to the restaurant now", "12:00 WIB", false),
    MessageData("Okay!", "12:01 WIB", true),
    MessageData("I'm on the way to your location now. Can you please confirm your exact location?", "12:30 WIB", false),
    MessageData("Sure. My building is right next to the convenience store", "12:31 WIB", true)
)
