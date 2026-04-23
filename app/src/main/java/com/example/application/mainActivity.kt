package com.example.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.application.ui.navigation.AppNavigation
import com.example.application.ui.navigation.Routes
import com.example.application.ui.theme.ApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ApplicationTheme {

                // 1. Inisialisasi BackStack (Tumpukan Layar) Navigasi 3
                // Kita mulai tumpukan pertamanya dengan halaman LandingRoute
                val backStack = remember { mutableStateListOf<Routes>(Routes.LandingRoute) }

                // 2. Mengambil layar paling atas (terakhir ditambahkan) untuk ditampilkan
                val currentRoute = backStack.last()

                // 3. Memanggil file Compositions.kt (AppNavigation)
                AppNavigation(
                    currentRoute = currentRoute,
                    onNavigate = { newRoute ->
                        // Misi: Basic Routing (Pindah ke halaman baru dengan cara ditumpuk)
                        backStack.add(newRoute)
                    },
                    onBack = {
                        // Misi: Back Navigation (Mengambil/menghapus tumpukan teratas tanpa error)
                        if (backStack.size > 1) {
                            backStack.removeLastOrNull()
                        }
                    }
                )

            }
        }
    }
}