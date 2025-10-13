package com.devapps.justspeak.ui.screens.german.grammar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.devapps.justspeak.ui.routes.Signout
import com.devapps.justspeak.ui.screens.german.components.ConversationCard
import com.devapps.justspeak.ui.screens.german.components.LanguageSections
import com.devapps.justspeak.ui.screens.german.components.ResourceSection
import com.devapps.justspeak.ui.screens.german.components.UserProfile

data class GermanGrammarItem(
    val title: String,
    val content: String,
    val route: String
)

@Composable
fun GermanGrammarNavigation() {


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GermanGrammarListScreen() {

    val germanGrammarNavController = rememberNavController()

    val showMenu = remember { mutableStateOf(false) }
    val selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val selectedItemIndex1 by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("German Grammar",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold)
                },
                navigationIcon = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                actions = {
                    IconButton(onClick = {
                        showMenu.value = true
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = null
                        )
                    }
                    DropdownMenu(
                        expanded = showMenu.value,
                        onDismissRequest = {
                            showMenu.value = false
                        },
                        modifier = Modifier
                            .width(100.dp)
                            .background(Color.White)
                    ) {
                        DropdownMenuItem(
                            text = {
                                Text("Logout",
                                    color = Color.Black
                                )
                            },
                            onClick = {
                                //logout
//                                justSpeakNavController.navigate(Signout.route)
//                                onSignOut()
                            },
                            modifier = Modifier
                                .background(color = Color.White)
                        )
                    }
                }
            )
        }
    ) { it ->
        Column(modifier = Modifier
            .padding(it)
            .background(Color.White)
            .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .background(Color.White)
            ) {

            }
        }

    }
}