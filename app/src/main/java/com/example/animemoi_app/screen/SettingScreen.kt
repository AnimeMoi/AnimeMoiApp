package com.example.animemoi_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.animemoi_app.common.ComeBack

@Composable
fun SettingScreen(navController: NavHostController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ComeBack(title = "Cài đặt", navController)
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            
        }
    }
}

@Preview (showBackground = true)
@Composable
fun SettingScreenPreview(){
    SettingScreen(rememberNavController())
}