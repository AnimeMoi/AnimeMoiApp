package com.example.animemoi_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.animemoi_app.common.Bar
import com.example.animemoi_app.common.ListSourceComic
import com.example.animemoi_app.common.comic.ComicRow
import com.example.animemoi_app.common.comic.ComicRowWithTitle

@Composable
fun HomeScreen(navController: NavHostController) {
    val sources = listOf("NetTruyen", "BaoTangTruyen", "Yurineko")
    Column (
        modifier = Modifier
            .background(Color.Black)
    ) {
        Bar(navController)
        ListSourceComic(sources)
        Column(Modifier.verticalScroll(rememberScrollState())) {
            ComicRow()
            ComicRowWithTitle(title = "Truyện mới đăng",navController = navController)
            ComicRowWithTitle(title = "Truyện hay",navController = navController)
            ComicRowWithTitle(title = "Truyện mới cập nhật",navController = navController)
            ComicRowWithTitle(title = "Truyện đầy đủ",navController = navController)
        }
    }
}
