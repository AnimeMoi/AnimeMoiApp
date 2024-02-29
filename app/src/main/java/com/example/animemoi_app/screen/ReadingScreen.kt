package com.example.animemoi_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.animemoi_app.common.comic_reading.ImagesComicList
import com.example.animemoi_app.common.comic_reading.NavDetailComic
import com.example.animemoi_app.common.comic_reading.TitleDetailComic

@Composable
fun ReadingScreen(navController: NavHostController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
        Box (
            modifier = Modifier
                .fillMaxHeight(0.9f)
        ){
            ImagesComicList()
            TitleDetailComic(navController)
        }
        NavDetailComic()
    }


}

