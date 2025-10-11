package com.devapps.justspeak.utility

import androidx.compose.ui.graphics.Color

data class TopicCardItem(
    val color: Color,
    val title: String,
    val pic: Int,
    val route: String
)

data class ResourceCardItem(
    val title: String,
    val color: Color,
    val route: String
)
