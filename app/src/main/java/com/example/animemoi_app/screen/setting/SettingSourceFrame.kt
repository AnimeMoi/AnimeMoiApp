package com.example.animemoi_app.screen.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.animemoi_app.R
import com.example.animemoi_app.common.navigation.Screens
import com.example.animemoi_app.common.setting.Input
import com.example.animemoi_app.common.setting.TitleWithIcon
import com.example.animemoi_app.model.SourceData

@Composable
fun ListSource() {
    val listSource = listOf(
        SourceData(painterResource(id = R.drawable.deba), "Nettruyen"),
        SourceData(painterResource(id = R.drawable.thegioihoanmy), "Tachiyomi"),
        SourceData(painterResource(id = R.drawable.requytroicho480197), "Tu tiên truyện")
    )
    LazyVerticalGrid(
        GridCells.Fixed(1),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.height(150.dp)
    ) {
        items(listSource) { source ->
            Source(source = source)
        }
    }
}

@Composable
fun Source(source: SourceData) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = source.image, contentDescription = "Image", Modifier.size(40.dp)
        )
        Text(
            text = source.name, color = Color.White, modifier = Modifier
                .padding(16.dp, 0.dp)
                .fillMaxWidth(0.9f)
        )
        Icon(
            imageVector = Icons.Default.Menu, contentDescription = "Icon", tint = Color.White
        )
    }
}

@Composable
fun SettingSourceFrame(navController: NavHostController) {
    Box {
        Column(
            modifier = Modifier
                .padding(16.dp, 0.dp, 16.dp, 16.dp)
                .fillMaxWidth()
                .background(
                    Color(0xFF4D4D4D),
                    RoundedCornerShape(10.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Cài đặt nguồn truyện",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Input(text = "NSFW", true)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0f, 0f, 0f, 0.5f), RoundedCornerShape(10.dp))
                ) {
                    TitleWithIcon(
                        title = "Nguồn truyện của bạn", icon = Icons.Default.KeyboardArrowUp
                    )
                    Box {
                        Divider(color = Color(0xFF808080), modifier = Modifier.padding(8.dp))
                    }
                    TitleWithIcon(title = "Thêm nguồn mới", icon = Icons.Default.Add,
                        modifier = Modifier.clickable {
                            navController.navigate(Screens.SourceComicScreen.name)
                        })
                    ListSource()
                }
            }
        }
    }
}
