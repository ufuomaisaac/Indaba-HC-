package com.example.indabahc.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GradientHalfScreen() {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Top half with gradient
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight / 2)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(GradientGreen, Color.White)
                    )
                )
        )

        // Bottom half - replace with any content
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight / 2)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {

        }
    }
}


@Composable
@Preview
fun previewFunction() {
    GradientHalfScreen()
}