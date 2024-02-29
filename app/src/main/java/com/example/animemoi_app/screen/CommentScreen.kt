package com.example.animemoi_app.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.animemoi_app.R
import com.example.animemoi_app.common.ComeBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentScreen(title: String, navController: NavHostController, modifier: Modifier = Modifier) {
    var commentValue by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .background(Color.Black)
            .fillMaxSize()

    ) {
        ComeBack(title = title, navController = navController)

        Card(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.85f),
            colors = CardDefaults.cardColors(Color(0xFF444242))
        ) {
            //titleRow
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 10.dp, 10.dp, 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Bình luận nổi bật",
                    color = Color.White,
                    fontSize = 18.sp
                    )
                Text(
                    text = "Tổng 100 bình luận",
                    color = Color.White
                    )
            }
            //listComment
            LazyColumn{
                items(10){
                    CommentItem()
                }
            }
        }
        //Comment TextBox
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.deba),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Red)
            )
            OutlinedTextField(
                value = commentValue,
                onValueChange = { commentValue = it },
                label = null,
                placeholder = {
                    Text(text = "Viết gì đó", fontSize = 10.sp)
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.Black,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .fillMaxWidth(0.9f)
                    .height(45.dp),
                shape = RoundedCornerShape(30.dp),
                maxLines = 1,
                textStyle = TextStyle(fontSize = 10.sp)

            )
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.clickable { }
            )
        }
    }
}

@Composable
fun CommentItem() {
    Card(
        modifier = Modifier
            .padding(15.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.deba),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Red)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = "Lê Tuấn Kha",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Tập này hay quáaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "22 giờ trước",
                        color = Color.White,
                        fontWeight = FontWeight.Light
                    )
                    Row(

                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = null,
                            tint = Color(0xFFC2C2C2)
                        )
                        Icon(
                            imageVector = Icons.Default.Comment,
                            contentDescription = null,
                            tint = Color(0xFFC2C2C2),
                            modifier = Modifier.padding(end = 5.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.ThumbUp,
                            contentDescription = null,
                            tint = Color(0xFFC2C2C2)
                        )
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