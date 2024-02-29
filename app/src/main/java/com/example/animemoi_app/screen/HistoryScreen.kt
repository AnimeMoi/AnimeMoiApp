package com.example.animemoi_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.animemoi_app.common.Bar
import com.example.animemoi_app.common.history.GridHistoryCard

@Composable
fun HistoryScreen(
    navController: NavHostController, selectedComic: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Bar(navController = navController)
        Row(
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Button(
                onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Text(text = "Hôm nay")
            }
            Button(
                onClick = {

                }, colors = ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Text(text = "Xoá tất cả", color = Color(0xFFFF6666))
            }
        }
        GridHistoryCard(showStatus = true, showLastTimeUpdate = false, selectedComic = selectedComic)
    }
}