package com.example.animemoi_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.animemoi_app.common.comic_reading.ImagesComicList
import com.example.animemoi_app.common.comic_reading.TitleDetailComic

@Composable
fun ComicDetailScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
        TitleDetailComic()
        ImagesComicList()
    }


}

@Preview
@Composable
fun PreviewComicDetailScreen() {
    ComicDetailScreen()
}