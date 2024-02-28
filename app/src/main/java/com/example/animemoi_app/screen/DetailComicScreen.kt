package com.example.animemoi_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.animemoi_app.common.comic_detail.ChapterListDetail
import com.example.animemoi_app.common.comic_detail.InformationComicDetail
import com.example.animemoi_app.common.comic_detail.NavComicDetail
import com.example.animemoi_app.common.comic_detail.TitleDetail
import com.example.animemoi_app.common.comic_detail.VoteComicDetail
import com.example.animemoi_app.data.ComicRepo.getComic
import com.example.animemoi_app.model.ComicTest

@Composable
fun DetailScreen(
    comicId : Int,
    navigateUp: () ->Unit
) {
    val context = LocalContext.current
    val comic: ComicTest = remember(comicId) {
        getComic(comicId, context)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
        TitleDetail(comic.imageResourceId,comic.stringResourceId,navigateUp)
        VoteComicDetail()
        NavComicDetail()
        InformationComicDetail()
        ChapterListDetail()
    }
}
@Preview
@Composable
fun PreviewDetailScreen() {
   DetailScreen(6,navigateUp = { })
}