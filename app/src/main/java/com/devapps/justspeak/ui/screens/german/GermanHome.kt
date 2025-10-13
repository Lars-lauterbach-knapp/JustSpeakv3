package com.devapps.justspeak.ui.screens.german

import android.widget.Toast
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devapps.justspeak.R
import com.devapps.justspeak.data.model.GoogleClientAuth
import com.devapps.justspeak.data.model.UserData
import com.devapps.justspeak.ui.routes.Signout
import com.devapps.justspeak.ui.routes.german.GermanConversations
import com.devapps.justspeak.ui.routes.german.GermanExam
import com.devapps.justspeak.ui.routes.german.GermanFlashcards
import com.devapps.justspeak.ui.routes.german.GermanGrammar
import com.devapps.justspeak.ui.routes.german.GermanHome
import com.devapps.justspeak.ui.routes.german.GermanPhrases
import com.devapps.justspeak.ui.screens.german.components.ConversationCard
import com.devapps.justspeak.ui.screens.german.components.LanguageSections
import com.devapps.justspeak.ui.screens.german.components.ResourceSection
import com.devapps.justspeak.ui.screens.german.components.UserProfile
import com.devapps.justspeak.ui.theme.appleGreen
import com.devapps.justspeak.ui.theme.neutralGreen
import com.devapps.justspeak.ui.theme.peach
import com.devapps.justspeak.ui.theme.teal
import com.devapps.justspeak.utility.ResourceCardItem
import com.devapps.justspeak.utility.TopicCardItem
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch

@Composable
fun GermanNavigation(
    justSpeakNavController: NavController,
    userData: UserData?
    ) {

    val germanNavController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current.applicationContext

    val googleClientAuth by lazy {
        GoogleClientAuth(
            context,
            Identity.getSignInClient(context)
        )
    }

    NavHost(germanNavController, startDestination = GermanHome.route) {
        composable(GermanHome.route) {
            GermanHomeScreen(
                userData,
                justSpeakNavController,
                germanNavController,
                onSignOut = {
                coroutineScope.launch {
                    googleClientAuth.signOut()
                    Toast.makeText(context, "Signed out", Toast.LENGTH_SHORT).show()
                }
            })
        }
        composable(GermanConversations.route) {

        }

        composable(GermanGrammar.route) {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GermanHomeScreen(
    userData: UserData?,
    justSpeakNavController: NavController,
    germanNavController: NavController,
    onSignOut: () -> Unit) {

    val showMenu = remember { mutableStateOf(false) }
    val selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val selectedItemIndex1 by rememberSaveable {
        mutableStateOf(0)
    }

    val topicCards = listOf(
        TopicCardItem(
            peach,
            title = "Grammar",
            pic = R.drawable.stack,
            route = GermanGrammar.route,
        ),
        TopicCardItem(
            appleGreen,
            title = "Phrases",
            pic = R.drawable.phrases,
            route = GermanPhrases.route,
        ),
    )

    val resourceCards = listOf(
        ResourceCardItem(
            "Exam preparations",
            teal,
            GermanExam.route
        ),
        ResourceCardItem(
            "Flashcards",
            neutralGreen,
            GermanFlashcards.route
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {

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
                                justSpeakNavController.navigate(Signout.route)
                                onSignOut()
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
                UserProfile(userData)
                Spacer(modifier = Modifier
                    .height(10.dp)
                )
                ConversationCard()
                Spacer(modifier = Modifier
                    .height(20.dp)
                )
                LanguageSections(
                    topicCards,
                    selectedItemIndex,
                    justSpeakNavController,
                    germanNavController
                    )
                Spacer(modifier = Modifier
                    .height(20.dp)
                )
                Text("Resources",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier
                    .height(10.dp)
                )
                ResourceSection(
                    resourceCards,
                    selectedItemIndex1,
                    justSpeakNavController,
                    germanNavController
                )
            }
        }

    }
}

@Composable
@Preview
fun ViewGermanHome() {
}