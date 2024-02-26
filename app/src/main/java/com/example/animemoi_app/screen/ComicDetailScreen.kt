package com.example.animemoi_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.animemoi_app.common.comic_detail.ComicImage
import com.example.animemoi_app.common.comic_detail.CommentDetailComic
import com.example.animemoi_app.common.comic_detail.ImagesComicList
import com.example.animemoi_app.common.comic_detail.NavDetailComic
import com.example.animemoi_app.common.comic_detail.TitleDetailComic
import com.example.animemoi_app.data.ComicDetailData

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