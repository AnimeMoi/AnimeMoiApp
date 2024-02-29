package com.example.animemoi_app.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.animemoi_app.R
import com.example.animemoi_app.common.ComeBack

@Composable
fun CommentScreen(title: String, navController: NavHostController, modifier: Modifier = Modifier) {
    var commentValue by remember { mutableStateOf("") }

    Column(
        modifier = modifier.background(Color.Black)
    ) {
        ComeBack(title = title, navController = navController)
        Card(
            modifier = Modifier
                .padding(12.dp)
                .background(Color.Gray)
        ) {
            Row(
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(id = R.string.comments), fontWeight = FontWeight.Bold
                )
                Text(text = stringResource(id = R.string.total_comments))
            }
            LazyColumn(
                modifier = Modifier
                    .background(Color.Gray)
                    .padding(top = 12.dp)
            ) {
                items(5) { CommentItem() }
            }
        }
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.align(Alignment.BottomStart),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier.weight(1f) // Set weight for TextField
                ) {
                    TextField(value = commentValue, onValueChange = { value ->
                        commentValue = value
                    }, placeholder = {
                        Text(
                            text = "Viết gì đó",
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .background(Color.Black),
                            color = Color.White
                        )
                    }, colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Black,
                        unfocusedContainerColor = Color.Black,
                        disabledContainerColor = Color.Black,
                        unfocusedTextColor = Color.White,
                        focusedTextColor = Color.White
                    ), modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(60.dp))
                    )
                }
                Icon(
                    Icons.Default.Send,
                    contentDescription = null,
                    modifier = Modifier
                        .size(35.dp)
                        .padding(start = 12.dp, end = 12.dp),
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun CommentItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp)
    ) {
        Image(
            painterResource(id = R.drawable.deba),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
        ) {
            Text(text = "username", fontWeight = FontWeight.Bold)
            Text(text = "content chat")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "22 giờ trước")
                LazyRow(contentPadding = PaddingValues(4.dp)) {
                    item {
                        Icon(Icons.Default.Share, contentDescription = null)
                        Icon(Icons.Default.Share, contentDescription = null)
                        Icon(Icons.Default.Share, contentDescription = null)
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CommentScreenPreview() {
    CommentScreen(title = "Chap 1: Cùng nhau nở hoa", navController = rememberNavController())
}

@Preview
@Composable
fun CommentItemPreview() {
    CommentItem()
}