package com.example.animemoi_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.animemoi_app.common.*
import com.example.animemoi_app.common.category_card.GridComic

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    navController: NavHostController,
    selectedComic: (Int) -> Unit
    ){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val sources = listOf("Nettruyen", "BaoTangTruyen", "Yurineko", "Yurisneko")
        Bar(navController)
        Box(modifier = Modifier.padding(top = 10.dp)) {
            SearchBar()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            ButtonCommon(
                modifier = Modifier.padding(start = 16.dp),
                backgroundColor = Color(0xFF33CC00),
                iconButton = Icons.Default.Add,
                onClick = {},
                text = "Bộ sưu tập"
            )
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Default.MoreHoriz,
                    contentDescription = "Xem thêm"
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(top = 5.dp, bottom = 25.dp)
        ) {
            ListSourceComic(sources = sources)
        }
        Box {
            GridComic(
                modifier = Modifier,
                selectedComic = selectedComic
            )
        }
    }
}