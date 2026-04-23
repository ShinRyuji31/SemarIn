package com.example.application.ui.component.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.application.R
import com.example.application.ui.theme.WhiteSoft

@Composable
fun DashboardBottomNavBar(
    currentTab: Int, // 🌟 Tambahan: Untuk tahu tab mana yang harus menyala
    onHomeClick: () -> Unit, // 🌟 Tambahan: Fungsi untuk kembali ke Home
    onProfileClick: () -> Unit
) {

    val items = listOf("Home", "Order Status", "Order History", "Profile")
    val icons = listOf(
        R.drawable.ic_home,
        R.drawable.ic_orderstatus,
        R.drawable.ic_history,
        R.drawable.ic_profile
    )

    NavigationBar(
        containerColor = WhiteSoft,
        tonalElevation = 8.dp
    ) {
        items.forEachIndexed { index, label ->

            // 🌟 Mengecek apakah tab ini yang sedang aktif
            val isSelected = currentTab == index

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    when (index) {
                        0 -> onHomeClick()    // 🌟 Sekarang Home punya aksinya sendiri
                        1 -> { /* TODO */ }
                        2 -> { /* TODO */ }
                        3 -> onProfileClick()
                    }
                },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = icons[index]),
                            contentDescription = label,
                            modifier = Modifier.size(32.dp),
                            tint = if (isSelected) MaterialTheme.colorScheme.primary else Color.Black
                        )
                        Text(
                            text = label,
                            fontSize = 10.sp,
                            color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Black
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}