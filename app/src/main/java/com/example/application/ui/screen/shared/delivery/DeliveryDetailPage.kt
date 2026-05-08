package com.example.application.ui.screen.shared.delivery

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.application.R
import com.example.application.ui.component.global.Header
import com.example.application.ui.component.shared.delivery.StoreInfoCard
import com.example.application.ui.component.jajanin.menu.JajaninMenuSection
import com.example.application.viewmodel.JajaninViewModel

@Composable
fun DeliveryDetailPage(
    onBack: () -> Unit,
    onCartClick: () -> Unit,
    viewModel: JajaninViewModel = viewModel()
) {
    val menu by viewModel.menu.collectAsState()
    
    val restaurants by viewModel.restaurants.collectAsState()
    val selectedRestaurant by viewModel.selectedRestaurant.collectAsState()
    val restaurantToShow = selectedRestaurant ?: restaurants.firstOrNull()

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Spacer(modifier = Modifier.height(60.dp).statusBarsPadding())
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.dummy),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }

            item {
                restaurantToShow?.let {
                    Box(modifier = Modifier.offset(y = (-40).dp)) {
                        StoreInfoCard(restaurant = it)
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height((-20).dp))
                
                val groupedMenu = menu.groupBy { it.category }
                
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    groupedMenu.forEach { (category, items) ->
                        JajaninMenuSection(
                            title = category,
                            items = items
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(100.dp))
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp)
                .offset(y = 40.dp)
                .clickable { onCartClick() }
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(Color.White, CircleShape)
                    .border(1.dp, Color(0xFF2D9CDB), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bag),
                    contentDescription = "Cart",
                    tint = Color(0xFF2D9CDB),
                    modifier = Modifier.size(30.dp)
                )
                
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(20.dp)
                        .background(Color(0xFF2D9CDB), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "0",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
            }
        }

        Header(
            title = "Jajan-In",
            onBack = onBack,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}
