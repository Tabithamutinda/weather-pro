package com.example.weatherpro.features.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherpro.features.home.HomeUiState

@Composable
fun HeaderSection(
    state: HomeUiState
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Icon(
                imageVector =
                    Icons.Default.LocationOn,
                contentDescription = null,
                tint =
                    MaterialTheme.colorScheme.primary
            )

            Text(
                text = "${state.city}, Kenya"
            )
        }

        Text(
            text = state.date,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Icon(

            imageVector = Icons.Default.WbSunny,

            contentDescription = null,

            tint = MaterialTheme.colorScheme.primary,

            modifier = Modifier.height(90.dp)

        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "${state.temperature}C",
            fontSize = 64.sp
        )

        Text(
            text = state.condition,
            style = MaterialTheme.typography.titleMedium
        )
    }
}