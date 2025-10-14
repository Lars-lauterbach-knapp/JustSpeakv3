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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devapps.justspeak.data.model.GoogleClientAuth
import com.devapps.justspeak.data.model.UserData
import com.devapps.justspeak.ui.routes.Signout
import com.devapps.justspeak.ui.routes.german.GermanAdjectives
import com.devapps.justspeak.ui.routes.german.GermanAlphabet
import com.devapps.justspeak.ui.routes.german.GermanCases
import com.devapps.justspeak.ui.routes.german.GermanGrammar
import com.devapps.justspeak.ui.routes.german.GermanNouns
import com.devapps.justspeak.ui.routes.german.GermanNumbers
import com.devapps.justspeak.ui.routes.german.GermanPrepositions
import com.devapps.justspeak.ui.routes.german.GermanSentences
import com.devapps.justspeak.ui.routes.german.GermanTenses
import com.devapps.justspeak.ui.routes.german.GermanVerbs
import com.devapps.justspeak.ui.screens.german.components.ConversationCard
import com.devapps.justspeak.ui.screens.german.components.GermanGrammarList
import com.devapps.justspeak.ui.screens.german.components.LanguageSections
import com.devapps.justspeak.ui.screens.german.components.ResourceSection
import com.devapps.justspeak.ui.screens.german.components.UserProfile
import com.devapps.justspeak.ui.theme.appGray
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch

data class GermanGrammarItem(
    val title: String,
    val content: String,
    val route: String
)

@Composable
fun GermanGrammarNavigation(
    justSpeakMainNavController: NavController,
    userData: UserData?
) {

    val germanGrammarNavController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current.applicationContext

    val googleClientAuth by lazy {
        GoogleClientAuth(
            context,
            Identity.getSignInClient(context)
        )
    }

    androidx.navigation.compose.NavHost(
        navController = germanGrammarNavController,
        startDestination = GermanGrammar.route
    ) {
        composable(GermanGrammar.route) {
            GermanGrammarListScreen(
                justSpeakMainNavController,
                germanGrammarNavController,
                userData,
                onSignOut = {
                    coroutineScope.launch {
                        googleClientAuth.signOut()
                        justSpeakMainNavController.navigate(Signout.route)
                    }
                }
            )
        }
        composable(GermanAlphabet.route) {
            //GermanAlphabetScreen(germanGrammarNavController)
        }
        composable(GermanAdjectives.route) {
            //GermanAdjectivesScreen(germanGrammarNavController)
        }
        composable(GermanCases.route) {
            //GermanCasesScreen(germanGrammarNavController)
        }
        composable(GermanNouns.route) {
            //GermanNounsScreen(germanGrammarNavController)
        }
        composable(GermanNumbers.route) {
            //GermanNumbersScreen(germanGrammarNavController)
        }
        composable(GermanPrepositions.route) {
            //GermanPrepositionsScreen(germanGrammarNavController)
        }
        composable(GermanSentences.route) {
            //GermanSentencesScreen(germanGrammarNavController)
        }
        composable(GermanTenses.route) {
            //GermanTensesScreen(germanGrammarNavController)
        }
        composable(GermanVerbs.route) {
            //GermanVerbsScreen(germanGrammarNavController)
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GermanGrammarListScreen(
    justSpeakMainNavController: NavController,
    germanGrammarNavController: NavController,
    userData: UserData?,
    onSignOut: () -> Unit
) {



    val showMenu = remember { mutableStateOf(false) }
    val selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val selectedItemIndex1 by rememberSaveable {
        mutableStateOf(0)
    }

    val germanGrammarList = listOf(

        GermanGrammarItem(
            "Alphabet",
            "Learn the German alphabet and pronunciation.",
            GermanAlphabet.route
        ),
        GermanGrammarItem(
            "Adjectives",
            "Understand how to use adjectives in German",
            GermanAdjectives.route
        ),
        GermanGrammarItem(
            "Cases",
            "Learn about the four grammatical cases in German",
            GermanCases.route
        ),
        GermanGrammarItem(
            "Nouns",
            "Explore German nouns, including gender, plural forms, and articles.",
            GermanNouns.route
        ),
        GermanGrammarItem(
            "Numbers",
            "Learn how to count in German",
            GermanNumbers.route
        ),
        GermanGrammarItem(
            "Prepositions",
            "Understand the use of prepositions in German",
            GermanPrepositions.route
        ),
        GermanGrammarItem(
            "Pronouns",
            "Learn about personal, possessive, reflexive, and relative pronouns in German.",
            GermanPrepositions.route
        ),
        GermanGrammarItem(
            "Sentences",
            "Understand German sentence structure and word order.",
            GermanSentences.route
        ),
        GermanGrammarItem(
            "Tenses",
            "Learn about the different verb tenses in German.",
            GermanTenses.route
        ),
        GermanGrammarItem(
            "Verbs",
            "Explore German verbs, including regular and irregular conjugations.",
            GermanVerbs.route
        )
    )


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
                            justSpeakMainNavController.popBackStack()
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
                                justSpeakMainNavController.navigate(Signout.route)
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
            .background(appGray)
            .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                GermanGrammarList(
                    germanGrammarList,
                    germanGrammarNavController,
                    selectedItemIndex,
                    justSpeakMainNavController
                )
            }
        }

    }
}