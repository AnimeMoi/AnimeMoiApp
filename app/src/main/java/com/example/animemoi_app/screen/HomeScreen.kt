package com.example.animemoi_app.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.animemoi_app.common.Bar
import com.example.animemoi_app.common.ListSourceComic
import com.example.animemoi_app.common.comic.ComicRow

@Composable
fun HomeScreen() {
    val sources = listOf("NetTruyen", "BaoTangTruyen", "Yurineko")
    Column {
        Bar()
        ListSourceComic(sources)
        ComicRow()
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}