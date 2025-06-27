package com.example.indabahc.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.indabahc.R
import com.example.indabahc.ui.theme.GGreen
import com.example.indabahc.ui.theme.GWhite


@Composable
fun DietScreen(modifier: Modifier,
                     onNavUp : () -> Unit, ) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight)
            .background(GWhite),
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight/2)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(GGreen, GWhite)
                )
            )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Spacer(Modifier.height(50.dp))

        TopAppBar(
            iconRes1 = R.drawable.arrow_left,
            iconRes2 = R.drawable.group_r,
            title = "Diet And Meal Tracking",
            modifier = Modifier
        )

        Spacer(Modifier.height(50.dp))


        TriggerFoodQuestion(
            questionText = "Ate spicy foods today?",
        )

        TriggerFoodQuestion(
            questionText = "Skipped meals",
        )

        TriggerFoodQuestion(
            questionText = "Ate late at night?",
        )


    }
}

@Composable
@Preview
fun previewFunction2() {
    TopAppBar(
        iconRes1 = R.drawable.arrow_left,
        iconRes2 = R.drawable.group_r,
        title = "Medi Tracking",
        modifier = Modifier
    )

    /*MedicationScreen(
        modifier = Modifier
    ) { }*/

}

