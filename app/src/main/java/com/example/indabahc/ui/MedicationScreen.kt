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
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.indabahc.R
import com.example.indabahc.ui.home.CurvedRectangle
import com.example.indabahc.ui.home.GreetingHeader
import com.example.indabahc.ui.home.HomeScreen
import com.example.indabahc.ui.home.MealCard1
import com.example.indabahc.ui.home.MealCard2
import com.example.indabahc.ui.theme.GGreen


@Composable
fun MedicationScreen(modifier: Modifier,
               onNavUp : () -> Unit, ) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight)
            .background(Color.White),
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight/2)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(GGreen, Color.White)
                )
            )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(Modifier.height(50.dp))

        TopAppBar(
            iconRes1 = R.drawable.arrow_left,
            iconRes2 = R.drawable.diet,
            title = "Medication Tracking",
            modifier = Modifier
        )

        Spacer(Modifier.height(50.dp))


        TriggerFoodQuestion(
            questionText = "Took Ulcer Medication Today?",
        )

        TriggerFoodQuestion(
            questionText = "Took Ulcer Medication Today?",
        )

        TriggerFoodQuestion(
            questionText = "Took Ulcer Medication Today?",
        )


    }
}

@Composable
@Preview
fun previewFunction() {
    MedicationScreen(
        modifier = Modifier
    ) { }

}


@Composable
fun TriggerFoodQuestion(
    questionText: String,
    onAnswerSelected: (Boolean) -> Unit = { },
    selectedAnswer: Boolean? = null
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFFFFFFF))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = questionText,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Row {
            AnswerButton("Yes", isSelected = selectedAnswer == true) {
                onAnswerSelected(true)
            }
            Spacer(modifier = Modifier.width(8.dp))
            AnswerButton("No", isSelected = selectedAnswer == false) {
                onAnswerSelected(false)
            }
        }
    }
}

@Composable
fun AnswerButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) Color(0xFFB6F1A4) else Color.Transparent
    val borderColor = if (isSelected) Color.Transparent else Color(0xFFB6F1A4)
    val textColor = if (isSelected) Color.Black else Color.Black

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .border(1.dp, borderColor, RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = text,
            color = textColor,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
        )
    }
}



@Composable
fun TopAppBar(
    @DrawableRes iconRes1: Int,
    @DrawableRes iconRes2: Int,
    title: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(Color(0xFFFFFFFF)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconRes1),
                contentDescription = title,
                tint = Color(0xFF0277BD),
                modifier = Modifier.size(18.dp)
            )
        }


        Text(
            //modifier = Modifier.weight(1f),
            text = title,
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 20.sp
            )

        )

        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(Color(0xFFB3E5FC)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconRes2),
                contentDescription = title,
                tint = Color(0xFF0277BD),
                modifier = Modifier.size(18.dp)
            )
        }
    }
}
