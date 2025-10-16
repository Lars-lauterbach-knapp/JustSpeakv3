package com.devapps.justspeak.ui.screens.german.grammar

import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEachIndexed
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
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
import com.devapps.justspeak.ui.screens.german.components.AlphabetCard
import com.devapps.justspeak.ui.screens.german.components.ConversationCard
import com.devapps.justspeak.ui.screens.german.components.GermanGrammarList
import com.devapps.justspeak.ui.screens.german.components.LanguageSections
import com.devapps.justspeak.ui.screens.german.components.ResourceSection
import com.devapps.justspeak.ui.screens.german.components.UserProfile
import com.devapps.justspeak.ui.screens.german.components.tabItems
import com.devapps.justspeak.ui.theme.appGray
import com.devapps.justspeak.ui.theme.teal
import com.devapps.justspeak.utility.Content.GermanGrammar.getGermanAlphabetData
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch
import java.util.Locale

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

    val textToSpeech = remember {
        var tts: TextToSpeech? = null
        tts = TextToSpeech(context) { status ->
            if(status == TextToSpeech.SUCCESS) {
                val result = tts?.setLanguage(Locale.GERMAN)
                if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "German not supported")
                }
            } else {
                Log.e("TTS", "Initialisation failed")
            }

        }
        tts
    }

    NavHost(
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
            GermanAlphabetScreen(
                justSpeakMainNavController,
                germanGrammarNavController,
                userData,
                textToSpeech,
                onSignOut = {
                    coroutineScope.launch {
                        googleClientAuth.signOut()
                        justSpeakMainNavController.navigate(Signout.route)
                    }
                }
            )
        }
        composable(GermanAdjectives.route) {
            GermanAdjectiveScreen(
                justSpeakMainNavController,
                germanGrammarNavController,
                userData,
                textToSpeech,
                onSignOut = {
                    coroutineScope.launch {
                        googleClientAuth.signOut()
                        justSpeakMainNavController.navigate(Signout.route)
                    }
                }
            )
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
            "Learn the German alphabet.",
            GermanAlphabet.route
        ),
        GermanGrammarItem(
            "Adjectives",
            "Understand German adjectives",
            GermanAdjectives.route
        ),
        GermanGrammarItem(
            "Cases",
            "Learn about cases in German",
            GermanCases.route
        ),
        GermanGrammarItem(
            "Nouns",
            "Explore German nouns.",
            GermanNouns.route
        ),
        GermanGrammarItem(
            "Numbers",
            "Learn how to count in German",
            GermanNumbers.route
        ),
        GermanGrammarItem(
            "Prepositions",
            "Understand prepositions in German",
            GermanPrepositions.route
        ),
        GermanGrammarItem(
            "Pronouns",
            "Learn about pronouns in German.",
            GermanPrepositions.route
        ),
        GermanGrammarItem(
            "Sentences",
            "Understand German sentence structure.",
            GermanSentences.route
        ),
        GermanGrammarItem(
            "Tenses",
            "Learn about tenses in German.",
            GermanTenses.route
        ),
        GermanGrammarItem(
            "Verbs",
            "Explore German verbs.",
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GermanAlphabetScreen(
    justSpeakMainNavController: NavController,
    germanGrammarNavController: NavController,
    userData: UserData?,
    textToSpeech: TextToSpeech,
    onSignOut: () -> Unit
) {

    val showMenu = remember { mutableStateOf(false) }
    val selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    DisposableEffect(Unit) {
        onDispose {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
    }

    val germanAlphabetData = getGermanAlphabetData()

    // LazyListState to keep track of the scroll position
    val listState = rememberLazyListState()
    val totalItems = germanAlphabetData.size


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Das Alphabet",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold)
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            germanGrammarNavController.popBackStack()
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
                Spacer(modifier = Modifier
                    .height(10.dp)
                )
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)

                ) {  }
                LazyColumn(
                    state = listState,
                    modifier = Modifier
                        .height(800.dp)
                ) {
                    items(germanAlphabetData) { letter ->
                        AlphabetCard(letter = letter, textToSpeech = textToSpeech)
                    }
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GermanAdjectiveScreen(
    justSpeakMainNavController: NavController,
    germanGrammarNavController: NavController,
    userData: UserData?,
    textToSpeech: TextToSpeech,
    onSignOut: () -> Unit
) {

    val showMenu = remember { mutableStateOf(false) }
    var selectedTabIndex  by rememberSaveable {
        mutableStateOf(0)
    }

    val pagerState = rememberPagerState {
        tabItems.size
    }

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if(!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
    }


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text("Adjektive",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            germanGrammarNavController.popBackStack()
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
        Column(
            modifier = Modifier
                .padding(it)
                .background(appGray)
                .verticalScroll(rememberScrollState())
        ) {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = Color.White
            ) {
                tabItems.fastForEachIndexed { index, item ->
                    Tab(
                        selected = index == selectedTabIndex,
                        onClick = {
                            selectedTabIndex = index
                        },
                        selectedContentColor = teal,
                        text = {
                            Text(text = item.title,
                                color = teal
                            )
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedTabIndex) {
                                    item.selectedIcon
                                } else item.unselectedIcon, contentDescription = item.title,
                                tint = teal
                            )
                        }
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) { page ->
                    when(page) {
                        0 -> GermanAdjectiveHome(textToSpeech)
                        1 -> GermanAdjectiveEndings()
                        2 -> GermanAdjectiveQuiz()
                    }
                }
            }
        }
    }
}