package com.example.animemoi_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.animemoi_app.common.ComeBack
import com.example.animemoi_app.common.ListSourceComic
import com.example.animemoi_app.common.searchBar
import java.util.Locale.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ComeBack(title = "Tìm kiếm", navController)
        Spacer(modifier = Modifier.padding(8.dp))
        searchBar()
        TextAndClear()
        ListPreviousSearch(
            listOf(
                "Toàn chức pháp sư",
                "Tu tiên truyện",
                "18+",
                "Xuyên không về thời cổ đại",
                "Bạch tuyết và bảy chú lùn"
            )
        )
        ListSourceComic(
            listOf(
                "Nettruyen",
                "Bao Tang Truyen",
                "Tu Tiên Truyện",
                "Truyện xuyên Việt"
            )
        )
        CategorySearch(
            listOf(
                "Thể loại",
                "Thể loại",
                "Thể loại",
                "Thể loại",
                "Thể loại",
                "Thể loại",
                "Thể loại",
                "Thể loại",
                "Thể loại",
                "Thể loại"
            )
        )
    }
}

@Composable
fun CategorySearch(categories: List<String>) {
    Text(
        text = "Tìm kiếm thể loại",
        fontSize = 14.sp,
        color = Color.White,
        fontWeight = FontWeight.Medium,
        modifier = Modifier
            .padding(16.dp, 16.dp, 16.dp, 0.dp)
    )
    Box(
        modifier = Modifier
            .padding(16.dp, 8.dp)
    ) {
        Divider(color = Color(0xFF808080))
        LazyVerticalGrid(
            GridCells.Adaptive(60.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(0.dp, 16.dp)
        ) {
            items(categories) { category ->
                // Your category item composable
                Category(category)
            }
        }
    }
}

@Composable
fun Category(category: String) {
    var clickCount by remember { mutableIntStateOf(0) }
    Surface(
        shape = CircleShape,
        content = {
            Text(
                text = category,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = when (clickCount) {
                    1, 2 -> Color.White
                    else -> Color.Black},
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(
                        when (clickCount) {
                            1 -> Color(0xFF33CC66)
                            2 -> Color(0xFFFF6666)
                            else -> Color(0xFF999999)
                        }
                    )
                    .clickable {
                        clickCount++
                        if (clickCount == 3) clickCount = 0
                    }
            )
        }
    )
}

@Composable
fun ListPreviousSearch(searchs: List<String>) {
    LazyRow(
        Modifier
            .padding(16.dp, 0.dp, 16.dp, 16.dp)
            .fillMaxWidth()
            .height(30.dp)
    ) {
        items(searchs.take(10)) { item ->
            PreviousSearch(search = item)
        }
    }
}

@Composable
fun PreviousSearch(search: String) {
    Surface(
        onClick = {},
        color = Color.Transparent,
        modifier = Modifier
            .padding(8.dp, 0.dp, 8.dp, 0.dp)
            .clickable { },
    ) {
        Text(
            text = search,
            fontSize = 12.sp,
            color = Color(0xFF808080),
            fontWeight = FontWeight.Normal,
        )
    }
}

@Composable
fun TextAndClear() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp) // Optional: Add padding for better spacing
    ) {
        Text(
            text = "Tìm kiếm trước đây",
            fontWeight = FontWeight.Medium,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier
                .align(Alignment.CenterStart)
        )

        Text(
            text = "Xóa tất cả",
            fontWeight = FontWeight.Medium,
            color = Color(0xFFFF6666),
            fontSize = 14.sp,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .drawBehind {
                    drawLine(
                        color = Color(0xFFFF6666),
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = 1.dp.toPx()
                    )
                }
                .clickable {

                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen(navController = rememberNavController())
}


