package com.example.animemoi_app.common.comic_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animemoi_app.common.history.HistoryCard
import com.example.animemoi_app.data.ComicDetailData
import com.example.animemoi_app.model.ComicDetail

@Composable
fun ComicImage(
    comicDetail: ComicDetail
) {
    Image(painterResource(id = comicDetail.imageResourceId), null)
}
@Composable
fun ImagesComicList() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        //horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(vertical = 20.dp)){
        val imageList = ComicDetailData().loadComicDetail()
        items(imageList) { img ->
            ComicImage(comicDetail = img)
        }
        item {
            CommentDetailComic()
        }
        item {
            NavDetailComic()
        }
    }
}

@Preview
@Composable
fun Preview() {
    ImagesComicList()
}