package com.example.animemoi_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.animemoi_app.common.ComeBack
import com.example.animemoi_app.common.comic.ComicGrid

@Composable
fun MoreComicScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ComeBack("Truyện mới đăng", navController)
        ComicGrid()
    }
}

@Preview
@Composable
fun PreviewMoreComicScreen() {
    MoreComicScreen(navController = rememberNavController())
}