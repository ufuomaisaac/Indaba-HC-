package com.example.indabahc.ui.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopAppBar(
    topAppBarTitle: String,
    NavUp: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = topAppBarTitle,
                modifier = Modifier
            )

        },
        navigationIcon = {
            IconButton(onClick = NavUp) {
                Icon(imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "navigation icon")
            }
        }


    )
}