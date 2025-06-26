package com.example.indabahc.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.example.indabahc.ui.theme.ButtonColor

@Composable
fun JetsnackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = ButtonShape,
    border: BorderStroke? = null,
    contentColor: Color = ButtonColor,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    JetsnackSurface(
        shape = shape,
        color = Color.Transparent,
        contentColor = contentColor,
        border = border,
        modifier = modifier
            .clickable(
                onClick = onClick,
                role = Role.Button,
                interactionSource = interactionSource,
                indication = null,
            ),
    ) {
        ProvideTextStyle(
            value = MaterialTheme.typography.labelLarge,
        ) {
            Row(
                Modifier
                    .defaultMinSize(
                        minWidth = ButtonDefaults.MinWidth,
                        minHeight = ButtonDefaults.MinHeight,
                    )
                    .indication(interactionSource, ripple())
                    .padding(contentPadding),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                content = content,
            )
        }
    }
}

private val ButtonShape = RoundedCornerShape(percent = 50)

@Preview("default", "round")
@Preview("dark theme", "round", uiMode = UI_MODE_NIGHT_YES)
@Preview("large font", "round", fontScale = 2f)
@Composable
private fun ButtonPreview() {

}

