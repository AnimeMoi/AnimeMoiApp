package com.example.animemoi_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.animemoi_app.common.comic_detail.ChapterListDetail
import com.example.animemoi_app.common.comic_detail.InformationComicDetail
import com.example.animemoi_app.common.comic_detail.NavComicDetail
import com.example.animemoi_app.common.comic_detail.TitleDetail
import com.example.animemoi_app.common.comic_detail.VoteComicDetail

@Composable
fun DetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
        TitleDetail()
        VoteComicDetail()
        NavComicDetail()
        InformationComicDetail()
        ChapterListDetail()
    }
}
@Preview
@Composable
fun PreviewDetailScreen() {
    DetailScreen()
}