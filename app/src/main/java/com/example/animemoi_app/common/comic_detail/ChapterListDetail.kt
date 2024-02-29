package com.example.animemoi_app.common.comic_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterListDetail() {
    //Chapter List
    var text by remember {
        mutableStateOf("")
    }
    Card(
        modifier = Modifier
            .height(500.dp)
            .padding(5.dp, 15.dp, 5.dp, 5.dp),
        colors = CardDefaults.cardColors(Color(0xFF444242))
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = null,
                placeholder = {
                    Text(text = "Nhập để tìm chương, vi du 1124", fontSize = 7.sp)
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.Black,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(40.dp),
                shape = RoundedCornerShape(30.dp),
                maxLines = 1,
                textStyle = TextStyle(fontSize = 7.sp)
            )
            Icon(
                imageVector = Icons.Default.MoreHoriz,
                contentDescription = "Xem thêm",
                tint = Color.White
            )
        }
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Chương", color = Color.White)
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "Mới nhất", color = Color(0xFFFF6666))
                Text(text = "Cũ nhất", color = Color.White)
            }
        }
        Divider(
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        //ListChapterDetail
        LazyColumn {
            item () {
                ListChapterDetail()
                ListChapterDetail()
                ListChapterDetail()
                ListChapterDetail()
                ListChapterDetail()
                ListChapterDetail()
                ListChapterDetail()
                ListChapterDetail()
                ListChapterDetail()
                ListChapterDetail()
                ListChapterDetail()
                ListChapterDetail()
                ListChapterDetail()
                ListChapterDetail()
                ListChapterDetail()
                ListChapterDetail()
                ListChapterDetail()
                ListChapterDetail()
                ListChapterDetail()

            }
        }
    }

}

@Composable
fun ListChapterDetail() {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ){
            Text(text = "Chuơng 1",color = Color.White, fontSize = 12.sp)
            Text(text = "Tên chương(Nếu có)", color = Color.White, fontSize = 12.sp)
        }
        Row (verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ){
            Text(text = "12 Giờ trước", color = Color.White, fontSize = 12.sp)
            Row (verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)){
                Icon(
                    imageVector = Icons.Default.RemoveRedEye,
                    contentDescription = null, tint = Color.White,
                    modifier = Modifier.size(15.dp)
                )
                Text(text = "4.5k", color = Color.White, fontSize = 12.sp)
            }
        }
    }
}

@Preview
@Composable
fun PreviewChapterListDetail() {
    ChapterListDetail()
}