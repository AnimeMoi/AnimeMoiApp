package com.example.animemoi_app.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.animemoi_app.common.ComeBack
import com.example.animemoi_app.common.comic.ComicGrid

@Composable
fun SearchResultScreen(
    navController: NavHostController,
    selectedComic: (Int) -> Unit) {
    ComeBack(title = "Kết quả", navController)
    Spacer(modifier = Modifier.height(16.dp))
    ComicGrid(selectedComic)
}

