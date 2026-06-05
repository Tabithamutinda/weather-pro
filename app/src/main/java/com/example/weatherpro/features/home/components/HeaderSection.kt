package com.example.weatherpro.features.home.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import com.example.weatherpro.core.util.getConditionText
import com.example.weatherpro.features.home.HomeState
import com.example.weatherpro.ui.theme.WeatherTextPrimary

@Composable
fun HeaderSection(
    state: HomeState
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
                contentDescription = null
            )

            Text(
                text =
                    "${state.city}, ${state.country}"
            )
        }

        Text(
            text = state.date,
            style =
                MaterialTheme.typography.bodyMedium
        )

        Spacer(
            modifier =
                Modifier.height(16.dp)
        )

        val context =
            LocalContext.current

        val imageLoader =
            ImageLoader.Builder(context)
                .components {
                    add(
                        SvgDecoder.Factory()
                    )
                }
                .build()

        AsyncImage(
            model =
                state.iconUrl,
            imageLoader =
                imageLoader,
            contentDescription = null,
            modifier =
                Modifier.size(120.dp),
            colorFilter =
                ColorFilter.tint(
                    WeatherTextPrimary
                )
        )

        Spacer(
            modifier =
                Modifier.height(8.dp)
        )

        AnimatedContent(

            targetState = state.temperature,

            label = "temperature"

        ) { temp ->

            Text(

                text = temp,

                fontSize = 64.sp

            )

        }

        Text(
            text =
                getConditionText(
                    state.conditionCode
                ),
            style =
                MaterialTheme.typography.titleMedium
        )
    }
}