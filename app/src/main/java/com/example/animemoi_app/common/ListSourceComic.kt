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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
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
            .height(50.dp)
    ) {
        items(sources) { item ->
            Source(
                source = item, isSelect = selectedSourceIndex == sources.indexOf(item)
            ) {
                selectedSourceIndex = sources.indexOf(item)
            }
        }
    }
}

@Composable
fun Source(source: String, isSelect: Boolean, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        color = Color.Transparent,
        modifier = Modifier
            .fillMaxHeight()
            .padding(15.dp)
            .drawBehind {
                drawLine(
                    color = if (isSelect) Color(0xFFFF6666) else Color.Transparent,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 3.dp.toPx()
                )
            },
    ) {
        Text(
            text = source,
            color = if (isSelect) Color(0xFFFF6666) else Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxSize(),
        )
    }
}

@Preview
@Composable
fun PreviewListSourceComic() {
    val sources = listOf("NetTruyen", "BaoTangTruyen", "Yurineko")
    ListSourceComic(sources)
}

