package com.devapps.justspeak.ui.screens.german.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.devapps.justspeak.R
import com.devapps.justspeak.ui.screens.german.grammar.GermanGrammarItem
import com.devapps.justspeak.ui.theme.appleGreen
import com.devapps.justspeak.ui.theme.grunGreen
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
fun GrammarCard(
    selected: Boolean,
    title: String,
    content: String,
    onClick: () -> Unit
) {

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clickable{
                onClick()
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 15.dp
        ),
        shape = RoundedCornerShape(10.dp),
    ) {
        Row(modifier = Modifier
            .padding(10.dp)) {
            Box(
                modifier = Modifier
                    .height(105.dp)
                    .width(110.dp)
            ) {
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxSize(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 15.dp
                    ),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = grunGreen
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painterResource(R.drawable.grammar),
                            contentDescription = null
                        )
                    }
                }
            }
            Spacer(modifier = Modifier
                .width(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(title,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier
                    .height(5.dp)
                )
                Text(content,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun GermanGrammarList(
    grammarList: List<GermanGrammarItem>,
    germanGrammarNavController: NavController,
    selectedItemIndex: Int,
    justSpeakNavController: NavController,
) {

    val lazyLayoutList: LazyListState = rememberLazyListState()

    LazyColumn(
        state = lazyLayoutList,
        modifier = Modifier
            .fillMaxWidth()
            .height(700.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        itemsIndexed(grammarList) { index, item ->
           GrammarCard(
                selected = index == selectedItemIndex,
                title = item.title,
                content = item.content,
                onClick = {
                     justSpeakNavController.navigate(item.route)
                }
           )
        }
    }
}



@Composable
@Preview
fun PreviewResource() {

}