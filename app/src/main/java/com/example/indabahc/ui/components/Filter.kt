package com.example.indabahc.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import java.util.logging.Filter

//-=-=565

@Composable
fun FilterChip(filter: Filter, modifier: Modifier = Modifier, shape: Shape = MaterialTheme.shapes.small) {
    val (selected, setSelected) = filter.enabled
    val backgroundColor by animateColorAsState(
        if (selected) JetsnackTheme.colors.brandSecondary else JetsnackTheme.colors.uiBackground,
        label = "background color",
    )
    val border = Modifier.fadeInDiagonalGradientBorder(
        showBorder = !selected,
        colors = JetsnackTheme.colors.interactiveSecondary,
        shape = shape,
    )
    val textColor by animateColorAsState(
        if (selected) Color.Black else JetsnackTheme.colors.textSecondary,
        label = "text color",
    )

    JetsnackSurface(
        modifier = modifier,
        color = backgroundColor,
        contentColor = textColor,
        shape = shape,
        elevation = 2.dp,
    ) {
        val interactionSource = remember { MutableInteractionSource() }

        val pressed by interactionSource.collectIsPressedAsState()
        val backgroundPressed =
            if (pressed) {
                Modifier.offsetGradientBackground(
                    JetsnackTheme.colors.interactiveSecondary,
                    200f,
                    0f,
                )
            } else {
                Modifier.background(Color.Transparent)
            }
        Box(
            modifier = Modifier
                .toggleable(
                    value = selected,
                    onValueChange = setSelected,
                    interactionSource = interactionSource,
                    indication = null,
                )
                .then(backgroundPressed)
                .then(border),
        ) {
            Text(
                text = filter.name,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                modifier = Modifier.padding(
                    horizontal = 20.dp,
                    vertical = 6.dp,
                ),
            )
        }
    }
}
