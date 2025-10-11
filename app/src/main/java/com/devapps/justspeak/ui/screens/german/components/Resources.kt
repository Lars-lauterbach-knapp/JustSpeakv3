package com.devapps.justspeak.ui.screens.german.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devapps.justspeak.ui.theme.teal

@Composable
fun ResourceCard(
    selected: Boolean,
    title: String,
    color: Color,
    onClick: () -> Unit) {
    ElevatedCard(
        modifier = Modifier
            .width(350.dp)
            .height(200.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.elevatedCardColors(
            containerColor = color,
            contentColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            Text(title,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(
                modifier = Modifier
                    .height(70.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        onClick()
                },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(170.dp)
                        .height(60.dp)
                ) {
                    Text("Get Started")
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewResource() {
}