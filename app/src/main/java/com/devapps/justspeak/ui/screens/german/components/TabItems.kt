package com.devapps.justspeak.ui.screens.german.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Article
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddComment
import androidx.compose.material.icons.filled.Airlines
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Cases
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.LockClock
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Rocket
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.AddComment
import androidx.compose.material.icons.outlined.Airlines
import androidx.compose.material.icons.outlined.Article
import androidx.compose.material.icons.outlined.Badge
import androidx.compose.material.icons.outlined.Cases
import androidx.compose.material.icons.outlined.Fastfood
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.LockClock
import androidx.compose.material.icons.outlined.Numbers
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material.icons.outlined.Rocket
import androidx.compose.ui.graphics.vector.ImageVector

data class TabItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector
)

val tabItems = listOf(
    TabItem(
        title = "Adjectives",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    TabItem(
        title = "Endings",
        Icons.Outlined.Article,
        Icons.Filled.Article
    ),
    TabItem(
        title = "Quiz",
        Icons.Outlined.Quiz,
        Icons.Filled.Quiz
    )
)

val caseTabItems = listOf(
    TabItem(
        title = "Articles",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    TabItem(
        title = "Cases",
        Icons.Outlined.Cases,
        Icons.Filled.Cases
    ),
    TabItem(
        title = "Quiz",
        Icons.Outlined.Quiz,
        Icons.Filled.Quiz
    )
)

val nounTabItems = listOf(
    TabItem(
        title = "Home",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    TabItem(
        title = "Place",
        Icons.Outlined.LocationOn,
        Icons.Filled.LocationOn
    ),
    TabItem(
        title = "Food",
        Icons.Outlined.Fastfood,
        Icons.Filled.Fastfood
    ),
    TabItem(
        title = "Body",
        Icons.Outlined.AccountCircle,
        Icons.Filled.AccountCircle
    ),
    TabItem(
        title = "Quiz",
        Icons.Outlined.Quiz,
        Icons.Filled.Quiz
    )
)

val germanNumberTabItem = listOf(
    TabItem(
        title = "Home",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    TabItem(
        title = "11 - 20",
        Icons.Outlined.Numbers,
        Icons.Filled.Numbers
    ),
    TabItem(
        title = "21-29",
        Icons.Outlined.Numbers,
        Icons.Filled.Numbers
    ),
    TabItem(
        title = "30-90",
        Icons.Outlined.Numbers,
        Icons.Filled.Numbers
    ),
    TabItem(
        title = "100-120",
        Icons.Outlined.Numbers,
        Icons.Filled.Numbers
    ),
    TabItem(
        title = "121+",
        Icons.Outlined.Numbers,
        Icons.Filled.Numbers
    ),
    TabItem(
        title = "Quiz",
        Icons.Outlined.Quiz,
        Icons.Filled.Quiz
    )
)

val prepositionTabItems = listOf(
    TabItem(
        title = "Home",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    TabItem(
        title = "Dative",
        Icons.Outlined.Badge,
        Icons.Filled.Badge
    ),
    TabItem(
        title = "Two-Way",
        Icons.Outlined.Airlines,
        Icons.Filled.Airlines
    ),
    TabItem(
        title = "Quiz",
        Icons.Outlined.Quiz,
        Icons.Filled.Quiz
    ),
)

val pronounTabItems = listOf(
    TabItem(
        title = "Home",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    TabItem(
        title = "Quiz",
        Icons.Outlined.Quiz,
        Icons.Filled.Quiz
    ),
)

val sentenceTabItems = listOf(
    TabItem(
        title = "Home",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    TabItem(
        title = "Sub",
        Icons.Outlined.AddComment,
        Icons.Filled.AddComment
    ),
    TabItem(
        title = "conjunc",
        Icons.Outlined.Add,
        Icons.Filled.Add
    ),
    TabItem(
        title = "Quiz",
        Icons.Outlined.Quiz,
        Icons.Filled.Quiz
    ),
)

val tenseTabItems = listOf(
    TabItem(
        title = "Home",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    TabItem(
        title = "Past",
        Icons.Outlined.LockClock,
        Icons.Filled.LockClock
    ),
    TabItem(
        title = "Future",
        Icons.Outlined.Rocket,
        Icons.Filled.Rocket
    ),
    TabItem(
        title = "Quiz",
        Icons.Outlined.Quiz,
        Icons.Filled.Quiz
    ),
)

val verbTabItems = listOf(
    TabItem(
        title = "Home",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    TabItem(
        title = "Verbs",
        Icons.Outlined.LockClock,
        Icons.Filled.LockClock
    ),
    TabItem(
        title = "Haben",
        Icons.Outlined.Rocket,
        Icons.Filled.Rocket
    ),
    TabItem(
        title = "Sein",
        Icons.Outlined.Rocket,
        Icons.Filled.Rocket
    ),
    TabItem(
        title = "können",
        Icons.Outlined.Rocket,
        Icons.Filled.Rocket
    ),
    TabItem(
        title = "Quiz",
        Icons.Outlined.Quiz,
        Icons.Filled.Quiz
    ),
)