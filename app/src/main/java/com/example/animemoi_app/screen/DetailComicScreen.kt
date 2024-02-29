package com.example.animemoi_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.animemoi_app.common.comic_detail.ChapterListDetail
import com.example.animemoi_app.common.comic_detail.InformationComicDetail
import com.example.animemoi_app.common.comic_detail.NavComicDetail
import com.example.animemoi_app.common.comic_detail.TitleDetail
import com.example.animemoi_app.common.comic_detail.VoteComicDetail
import com.example.animemoi_app.data.ComicRepo.getComic
import com.example.animemoi_app.model.ComicTest

@Composable
fun DetailScreen(
    comicId: Int, navigateUp: () -> Unit, navController: NavHostController
) {
    val context = LocalContext.current
    val comic: ComicTest = remember(comicId) {
        getComic(comicId, context)
    }
    val titleComic = stringResource(id = comic.stringResourceId)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        TitleDetail(comic.imageResourceId, comic.stringResourceId, navigateUp)
        VoteComicDetail()
        NavComicDetail(titleComic, navController)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            InformationComicDetail()
            ChapterListDetail()
        }
    }
}
