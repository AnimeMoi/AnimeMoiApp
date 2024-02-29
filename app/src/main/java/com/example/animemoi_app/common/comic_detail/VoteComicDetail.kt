package com.example.animemoi_app.common.comic_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VoteComicDetail() {
    //Vote comic
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Đánh giá cho truyện nhé", color = Color.White, fontSize = 18.sp)
        Row {
            Icon(
                imageVector = Icons.Default.StarRate,
                contentDescription = null,
                tint = Color.Yellow
            )
            Icon(
                imageVector = Icons.Default.StarRate,
                contentDescription = null,
                tint = Color.Yellow
            )
            Icon(
                imageVector = Icons.Default.StarRate,
                contentDescription = null,
                tint = Color.Yellow
            )
            Icon(
                imageVector = Icons.Default.StarRate,
                contentDescription = null,
                tint = Color.Yellow
            )
            Icon(
                imageVector = Icons.Default.StarRate,
                contentDescription = null,
                tint = Color.Gray
            )
        }
    }
}

@Preview
@Composable
fun PreviewVoteComicDetail() {
    VoteComicDetail()
}