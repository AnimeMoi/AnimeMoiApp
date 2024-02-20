package com.example.animemoi_app.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListSourceComic(sources: List<String>) {
    var selectedSourceIndex by remember { mutableIntStateOf(0) }
    LazyRow(
        Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .height(40.dp)
    ) {
        items(sources) { item ->
            Source(source = item)
        }
    }
}

@Composable
fun Source(source: String) {
    var isClicked by remember { mutableStateOf(false) }

    Surface(
        onClick = {
            isClicked = !isClicked
        },
        color = Color.Transparent,
        modifier = Modifier
            .fillMaxHeight()
            .background(if (isClicked) Color.Red else Color.Transparent)
            .padding(10.dp, 0.dp, 10.dp, 0.dp)
    ) {
        Text(
            text = source,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        )
    }
}

@Preview
@Composable
fun PreviewListSourceComic() {
    val sources = listOf("Nettruyen", "BaoTangTruyen", "Yurineko")
    ListSourceComic(sources)
}