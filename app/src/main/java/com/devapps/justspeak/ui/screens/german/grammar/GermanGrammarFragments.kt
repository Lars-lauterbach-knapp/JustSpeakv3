package com.devapps.justspeak.ui.screens.german.grammar

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devapps.justspeak.ui.screens.german.components.GermanDefEndTable
import com.devapps.justspeak.ui.screens.german.components.TranslatableItem
import com.devapps.justspeak.ui.theme.teal
import com.devapps.justspeak.utility.Content.GermanGrammar.Column
import com.devapps.justspeak.utility.Content.GermanGrammar.GermanIndEndTable
import com.devapps.justspeak.utility.Content.GermanGrammar.germanAdjectiveQuizQuestions
import com.devapps.justspeak.utility.Content.GermanGrammar.getGermanAdjectives

@Composable
fun GermanAdjectiveHome(textToSpeech: TextToSpeech) {

    val adjectives = getGermanAdjectives()
    val germanAdjectives = adjectives["German"] ?: emptyList()
    val englishAdjectives = adjectives["English"] ?: emptyList()


    // Ensure both lists are of the same size to avoid index out of bounds
    val maxSize = minOf(germanAdjectives.size, englishAdjectives.size)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(text = "Adjektive - Adjectives",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 15.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Adjectives like in any other language are used for description of nouns" +
                            ". German adjectives are dependent on the gender and case of the nouns." +
                            " Below are common adjectives you will encounter:",
                    color = Color.Black,
                    fontSize = 14.sp,

                    )
            }

        }

        Spacer(modifier = Modifier
            .height(15.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(800.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            itemsIndexed(germanAdjectives.take(maxSize)) { index, germanAdjective ->
                val englishAdjective = englishAdjectives.getOrNull(index) ?: ""

                // Pass German and English adjectives and the TextToSpeech object to the TranslatableItem
                TranslatableItem(deu = germanAdjective, eng = englishAdjective, textToSpeech = textToSpeech)
            }
        }
    }
}

@Composable
fun GermanAdjectiveEndings() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 15.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(text = "Adjective declension",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Text(
                    text = "Adjectives in german have different endings. This is determined by the case" +
                            " of the sentence or the gender of a noun.",
                    color = Color.Black,
                    fontSize = 14.sp,

                    )
            }

        }
        Spacer(modifier = Modifier
            .height(15.dp)
        )
        //card start
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 15.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Text(
                    text = "Definite Articles - Bestimmte Artikeln",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(
                    text = "These correspond to definite articles (der, die, das) or the in english",
                    color = Color.Black,
                    fontSize = 14.sp,
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanDefEndTable()
            }
        }
        Spacer(modifier = Modifier
            .height(15.dp)
        )
        //card start
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 15.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Text(
                    text = "Indefinite Articles - Unbestimmte Artikeln",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(
                    text = "These correspond to indefinite articles (ein, eine, ein) or a in english",
                    color = Color.Black,
                    fontSize = 14.sp,
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanIndEndTable()
            }
        }
    }
}

@Composable
fun GermanAdjectiveQuiz() {

    val germanAdjectiveQuestions = germanAdjectiveQuizQuestions()

    // Maintain selection state for each question
    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanAdjectiveQuestions.size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanAdjectiveQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 15.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(
                    text = "Adjective Quiz",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                score?.let {

                    if (it == germanAdjectiveQuestions.size) {
                        Text(
                            text = "Your Score: $it/${germanAdjectiveQuestions.size}",
                            color = Color.Magenta,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    } else if (it != germanAdjectiveQuestions.size) {
                        Text(
                            text = "Your Score: $it/${germanAdjectiveQuestions.size}",
                            fontSize = 20.sp,
                            color = Color.Red,
                            fontWeight = FontWeight.Bold

                        )
                    }
                }
                // LazyColumn to display questions
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(800.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {

                    items(germanAdjectiveQuestions.size) { j ->
                        val adjectiveQuizList = germanAdjectiveQuestions[j]
                        // Display the current question
                        Text(
                            text = "${adjectiveQuizList.number} ${adjectiveQuizList.question}",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(vertical = 8.dp),
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.Black
                        )

                        // Display the options as radio buttons
                        adjectiveQuizList.options.forEach { option ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = selectedOptions[j] == option,
                                    onClick = {
                                        selectedOptions[j] = option
                                        // Reset score and showCorrectAnswers state when an option is changed
                                        score = null
                                        showCorrectAnswers = false
                                    },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = Color.Black,
                                        unselectedColor = Color.Gray
                                    )
                                )
                                Text(text = option,
                                    color = Color.Black,
                                    fontSize = 14.sp
                                )
                            }
                        }
                        if (showCorrectAnswers && selectedOptions[j] != adjectiveQuizList.correctAnswer) {
                            Text(
                                text = "Correct Answer: ${adjectiveQuizList.correctAnswer}",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(vertical = 4.dp),
                                color = Color.Red,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
                // Submit Button
                Button(
                    onClick = {
                        var tempScore = 0
                        for (i in germanAdjectiveQuestions.indices) {
                            if (selectedOptions[i] == germanAdjectiveQuestions[i].correctAnswer) {
                                tempScore++
                            }
                        }
                        score = tempScore
                        showCorrectAnswers = true
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = teal,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(0.dp)
                ) {
                    Text(text = "Submit",
                        color = Color.White
                    )
                }
            }
        }
    }
}
