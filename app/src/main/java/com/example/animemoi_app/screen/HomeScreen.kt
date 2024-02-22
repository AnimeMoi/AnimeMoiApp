package com.example.animemoi_app.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.animemoi_app.common.Bar
import com.example.animemoi_app.common.ListSourceComic
import com.example.animemoi_app.common.comic.ComicRow
import com.example.animemoi_app.common.comic.ComicRowWithTitle

@Composable
fun HomeScreen() {
    val sources = listOf("NetTruyen", "BaoTangTruyen", "Yurineko")
    Column {
        Bar()
        ListSourceComic(sources)
        LazyColumn {
            item {
                ComicRow()
                ComicRowWithTitle(title = "Truyện mới đăng")
                ComicRowWithTitle(title = "Truyện hay")
                ComicRowWithTitle(title = "Truyện mới cập nhật")
                ComicRowWithTitle(title = "Truyện đầy đủ")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}