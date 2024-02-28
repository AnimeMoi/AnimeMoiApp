package com.example.animemoi_app.common.comic

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ComicRowWithTitle(title: String, modifier: Modifier = Modifier) {
    Column {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = title,
                color = Color.White,
                modifier = modifier
                    .padding(start = 16.dp, top = 8.dp, end = 0.dp, bottom = 8.dp)
            )
            Icon(
                Icons.Default.ArrowForward,
                tint = Color.White,
                contentDescription = null,
                modifier = modifier
                    .padding(start = 0.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
                    .clickable {}
            )
        }
        ComicRow()
    }
}

@Preview
@Composable
fun ComicRowWithTitlePreview() {
    ComicRowWithTitle(title = "Truyện mới đăng")
}