package com.example.weatherpro.core.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.weatherpro.core.navigation.BottomNavItem
import com.example.weatherpro.ui.theme.WeatherCard

@Composable
fun WeatherBottomBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Current,
    )

    NavigationBar(
        containerColor = WeatherCard
    ) {

        items.forEach { item ->

            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    onNavigate(item.route)
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(item.title)
                },
                colors =
                    NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.White,
                        selectedTextColor = Color.White,
                        indicatorColor = Color.Transparent,
                        unselectedIconColor =
                            Color.White.copy(alpha = .6f),
                        unselectedTextColor =
                            Color.White.copy(alpha = .6f)
                    )
            )
        }
    }
}