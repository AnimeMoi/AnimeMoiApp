package com.example.animemoi_app.common.comic_reading

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.animemoi_app.data.ComicDetailData
import com.example.animemoi_app.model.ComicDetail
import com.example.animemoi_app.model.ModeReader

@Composable
fun ComicImage(
    comicDetail: ComicDetail,
    modifier: Modifier = Modifier
) {
    Image(
        painterResource(id = comicDetail.imageResourceId),
        null,
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImagesComicList(
    modeReader: ModeReader = ModeReader.Vertical,
    navController: NavHostController,
    title: String
) {
    val imageList = ComicDetailData().loadComicDetail()
    if (modeReader == ModeReader.Vertical) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            //horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(imageList) { img ->
                ComicImage(comicDetail = img)
            }
            item {
                CommentDetailComic(navController, title)
            }
        }
    }
    if (modeReader == ModeReader.Horizontal) {
        val pagerState = rememberPagerState(pageCount = {
            imageList.size
        })
        HorizontalPager(state = pagerState) { page ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                ComicImage(
                    comicDetail = imageList[page],
                    Modifier.fillMaxSize()
                )
            }
        }
    }
}

