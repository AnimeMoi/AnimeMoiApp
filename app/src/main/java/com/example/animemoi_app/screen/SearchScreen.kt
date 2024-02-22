package com.example.animemoi_app.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.animemoi_app.common.ComeBack

@Composable
fun SearchScreen(navController: NavHostController){
    ComeBack(title = "Tìm kiếm", navController)
}


