package com.example.animemoi_app.common.comic_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animemoi_app.R

@Composable
fun CommentCard() {
    Card {
        Row {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentDetailComic() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(Color(0xFF444242))

    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 50.dp,
                    vertical = 15.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            //Like
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Icon(
                    imageVector = Icons.Default.ThumbUp,
                    contentDescription = null,
                    tint = Color.White
                )
                Text(text = "Thích", color = Color.White)
                Text(text = "100", color = Color.White)

            }
            //Add to library
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Icon(
                    imageVector = Icons.Default.Bookmark,
                    contentDescription = null,
                    tint = Color.White
                )
                Text(text = "Thêm vào thư viện", color = Color.White)
                Text(text = "100", color = Color.White)
            }
        }
        Divider(
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 15.dp)
        )
        //Headline
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Bình luận nổi bật",
                color = Color.White,
                fontSize = 18.sp)
            Text(text = "Tổng 100 bình luận", color = Color.White)
        }
        //Comment Card
        Card (
            modifier = Modifier
                .padding(15.dp),
            colors = CardDefaults.cardColors(Color.Transparent)
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.deba),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.Red)
                )
                Column (
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ){
                    Text(
                        text = "Lê Tuấn Kha",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Tập này hay quá",
                        color = Color.White,
                        fontWeight = FontWeight.Light,
                    )
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(text = "22 giờ trước", color = Color.White, fontWeight = FontWeight.Light)
                        Row (

                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                        ){
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = null, tint = Color(0xFFC2C2C2))
                            Icon(imageVector = Icons.Default.Comment, contentDescription = null, tint = Color(0xFFC2C2C2), modifier = Modifier.padding(end = 5.dp))
                            Icon(imageVector = Icons.Default.ThumbUp, contentDescription = null, tint = Color(0xFFC2C2C2))
                        }
                    }
                }
            }
        }
        Card (
            modifier = Modifier
                .padding(15.dp),
            colors = CardDefaults.cardColors(Color.Transparent)
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.deba),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.Red)
                )
                Column (
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ){
                    Text(
                        text = "Lê Tuấn Kha",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Tập này hay quá",
                        color = Color.White,
                        fontWeight = FontWeight.Light,
                    )
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(text = "22 giờ trước", color = Color.White, fontWeight = FontWeight.Light)
                        Row (

                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                        ){
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = null, tint = Color(0xFFC2C2C2))
                            Icon(imageVector = Icons.Default.Comment, contentDescription = null, tint = Color(0xFFC2C2C2), modifier = Modifier.padding(end = 5.dp))
                            Icon(imageVector = Icons.Default.ThumbUp, contentDescription = null, tint = Color(0xFFC2C2C2))
                        }
                    }
                }
            }
        }
        //Comment TextBox
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 20.dp)
                ,
            verticalAlignment = Alignment.CenterVertically
        ){

            Image(
                painter = painterResource(id = R.drawable.deba),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Red)
            )
            var text by remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = text,
                onValueChange = {text = it},
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
                modifier = Modifier.clickable {  }
            )

        }

    }
}

@Preview
@Composable
fun PreviewCommentComicDetail() {
    CommentDetailComic()
}