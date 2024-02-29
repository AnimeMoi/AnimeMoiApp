package com.example.animemoi_app.common.comic_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.SaveAlt
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.animemoi_app.common.ButtonCommon
import com.example.animemoi_app.common.ListSourceComic

@Composable
fun NavComicDetail(navController: NavHostController) {
    Column {
        //Nav comic
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ButtonCommon(
                onClick = { navController.navigate("ReadingScreen") },
                text = "Đọc",
                iconButton = Icons.Default.MenuBook
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Bookmark,
                    contentDescription = null,
                    tint = Color(0xFFFF6666)
                )
                Icon(
                    imageVector = Icons.Default.SaveAlt,
                    contentDescription = null,
                    tint = Color(0xFFFF6666)
                )
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null,
                    tint = Color(0xFFFF6666)
                )
            }
        }
        //Nav
        Box(modifier = Modifier.padding(vertical = 15.dp)) {
            ListSourceComic(listOf("Mô tả", "Thể loại", "Truyện liên quan", "Bình luận"))
        }
    }
}

