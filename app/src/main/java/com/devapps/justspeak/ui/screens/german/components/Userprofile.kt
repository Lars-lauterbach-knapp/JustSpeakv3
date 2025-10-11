package com.devapps.justspeak.ui.screens.german.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.allowHardware
import coil3.request.bitmapConfig
import com.devapps.justspeak.R
import com.devapps.justspeak.data.model.UserData
import com.devapps.justspeak.ui.theme.teal
import com.devapps.justspeak.utility.ResourceCardItem
import com.devapps.justspeak.utility.TopicCardItem

@Composable
fun UserProfile(userData: UserData?) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
       ) {

            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                if (userData?.userProfileUrl != null) {
                    val req = ImageRequest.Builder(LocalContext.current)
                        .data(userData.userProfileUrl)
                        .bitmapConfig(Bitmap.Config.RGB_565)
                        .allowHardware(false)
                        .build()
                AsyncImage(
                    model = req,
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                    Spacer(
                        modifier = Modifier
                            .width(10.dp)
                    )
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text("Welcome Back!",
                            fontSize = 16.sp
                        )
                        Text("${userData.username}",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
            } else {
                    Image(
                        painterResource(
                            R.drawable.avatar
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                    )
                    Spacer(
                        modifier = Modifier
                            .width(10.dp)
                    )
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Welcome Back!",
                            fontSize = 14.sp
                        )
                        Text(
                            "No user found",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painterResource(
                    R.drawable.deutsch
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
        }
    }
}

@Composable
fun ConversationCard() {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        colors = CardDefaults.cardColors(
            containerColor = teal
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(30.dp)
            ) {
                Text("Conservation \n scenarios",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(
                    modifier = Modifier
                        .height(70.dp)
                )
                ElevatedButton(
                    modifier = Modifier
                        .width(100.dp),
                    onClick = {
                        
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text("Start")
                }
            }
            Column(
                modifier = Modifier
                    .padding(30.dp)
            ) {
                Image(
                    painterResource(R.drawable.convo),
                    contentDescription = null,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun TopicCard(
    selected: Boolean,
    title: String,
    color: Color,
    picture: Int,
   onClick: () -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp)
            .clickable {
                onClick()
            },
        colors = CardDefaults.cardColors(
            containerColor = color
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(title,
                    fontSize = 22.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier
                    .height(140.dp)
                )
                Icon(
                    Icons.Outlined.ArrowForwardIos,
                    tint = Color.Black,
                    contentDescription = ""
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.End
            ) {
                Spacer(modifier = Modifier
                    .height(40.dp)
                )
                Image(
                    painterResource(picture),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                )
            }
        }
    }
}

@Composable
fun LanguageSections(
    topicCards: List<TopicCardItem>,
    selectedItemIndex: Int,
    justSpeakNavController: NavController,
    germanNavController: NavController
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(topicCards.size) {i ->
            val listItem = topicCards[i]
            TopicCard(
                selectedItemIndex == i,
                listItem.title,
                listItem.color,
                listItem.pic,
                onClick = {
                    germanNavController.navigate(listItem.route)
                }

            )
        }
    }
}

@Composable
fun ResourceSection(
    resourceCards: List<ResourceCardItem>,
    selectedItemIndex: Int,
    justSpeakNavController: NavController,
    germanNavController: NavController
) {

    val lazyListState: LazyListState = rememberLazyListState()

    LazyRow(
        state = lazyListState,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
        itemsIndexed(resourceCards) { index, item ->
            ResourceCard(
                selected = index == selectedItemIndex,
                title = item.title,
                color = item.color,
                onClick = {
                    germanNavController.navigate(item.route)
                }
            )
        }
    }
}


@Composable
@Preview
fun ViewComponent() {

}