package com.devapps.justspeak.ui.screens.german.components

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devapps.justspeak.ui.theme.teal

@Composable
fun AlphabetCard(letter : String,textToSpeech: TextToSpeech) {

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(70.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 10.dp
        ),
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = letter,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier
                    .width(200.dp))
                IconButton(
                    onClick = {
                        textToSpeech.speak(letter, TextToSpeech.QUEUE_FLUSH, null, null)
                    }) {
                    Icon(
                        imageVector = Icons.Filled.Mic, contentDescription = "Microphone",
                        tint = teal,
                        modifier = Modifier
                            .size(60.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun TranslatableItem(deu: String, eng: String, textToSpeech: TextToSpeech) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, top = 5.dp, bottom = 5.dp, end = 5.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = deu,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black
                )
                Text(
                    text = eng,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                IconButton(
                    onClick = {
                        textToSpeech.speak(deu, TextToSpeech.QUEUE_FLUSH, null, null)
                    }) {
                    Icon(
                        imageVector = Icons.Filled.Mic, contentDescription = "Microphone",
                        tint = teal,
                        modifier = Modifier
                            .size(60.dp)
                    )
                }
            }
        }
    }
}