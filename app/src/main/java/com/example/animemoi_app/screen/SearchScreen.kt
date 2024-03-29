package com.example.animemoi_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.animemoi_app.common.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavHostController) {
    var historyItems = remember {
        mutableStateListOf("Toàn chức pháp sư", "Tu tiên truyện", "Xuyên không về thời cổ đại")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Bar(navController = navController)
        Spacer(modifier = Modifier.padding(8.dp))
        SearchBar()
        TextAndClear(onClearClick = {historyItems.clear()})
        ListPreviousSearch(historyItems)
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
                "Thể loại",
                "Thể loại",
                "Thể loại"
            )
        )
        AuthorSearch()
        StatusComic(listOf("Tạm dừng", "Đang cập nhật", "Đã hoàn thành"))
        Row (
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom
        ) {
            ButtonCommon(
                text = "Tìm kiếm",
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}


@Composable
fun StatusComic(listStatus: List<String>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Tình trạng:",
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(8.dp, 0.dp)
        ) {
            items(listStatus) { status ->
                Status(status)
            }
        }
    }
}

@Composable
fun Status(status: String) {
    var clickChoose by remember { mutableStateOf(false) }
    Surface(
        modifier = Modifier.clickable { clickChoose = !clickChoose },
        shape = CircleShape,
        content = {
            Box(
                modifier = Modifier
                    .background(
                        if (clickChoose) Color(0xFFFF6666) else Color(0xFF999999)
                    )
            ) {
                Text(
                    text = status,
                    fontWeight = FontWeight.Normal,
                    color = if (clickChoose) Color.White else Color.Black,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(8.dp, 4.dp)
                )
            }
        }
    )
}

@Composable
fun AuthorSearch() {
    var authorQuery by remember { mutableStateOf("") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = "Tác giả: ",
            fontSize = 14.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium,
        )
        TextField(
            shape = CircleShape,
            value = authorQuery,
            onValueChange = { query -> authorQuery = query },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                cursorColor = Color.White,
                unfocusedContainerColor = Color.Black,
                focusedContainerColor = Color.Black,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedIndicatorColor = Color(0xFFFF6666),
            ),
            trailingIcon = {
                if (authorQuery != "") {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "Clear",
                        tint = Color(0xFFFF6666),
                        modifier = Modifier.clickable { authorQuery = "" })
                }
            },
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
                    else -> Color.Black
                },
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
fun TextAndClear(onClearClick: () -> Unit) {
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
            textDecoration = TextDecoration.Underline,
            fontSize = 14.sp,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .clickable {
                    onClearClick()
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen(navController = rememberNavController())
}


