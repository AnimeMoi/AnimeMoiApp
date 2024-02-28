package com.example.animemoi_app.common.category_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animemoi_app.data.CategoryData
import com.example.animemoi_app.data.ComicRepo
import com.example.animemoi_app.model.Category
import com.example.animemoi_app.model.ComicTest


@Composable
fun CardsComic(
    comic: ComicTest,
    selectedComic: (Int) -> Unit
){
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(300.dp)
            .clickable(onClick = {
                selectedComic(comic.comicId)
            }),
        elevation = CardDefaults.cardElevation(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Image(
            painter = painterResource(id = comic.imageResourceId),
            contentDescription = stringResource(id = comic.stringResourceId),
            modifier = Modifier
                .width(150.dp)
                .height(230.dp)
                .clip(RoundedCornerShape(10.dp)), // Round corners
            contentScale = ContentScale.Crop // Scale the image content,
        )
        Text(
            text = stringResource(id = comic.stringResourceId),
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily.Monospace,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(18.dp),
            maxLines = 1, // Chỉ hiển thị một dòng
            overflow = TextOverflow.Ellipsis // Thêm dấu "..." khi văn bản quá dài
        )
    }
}
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GridComic(
    modifier: Modifier = Modifier,
    selectedComic: (Int) -> Unit
) {
    //val comics = ComicData().loadComicCard()
    val categories = CategoryData().loadCategory()
    val scrollState = rememberLazyListState()
    val context = LocalContext.current
    val comics: List<ComicTest> = ComicRepo.getComicsList(context)
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(1.dp),
        state = scrollState
        //modifier = Modifier.padding(horizontal = 25.dp, vertical = 15.dp)
    ) {
        categories.forEach { category ->
            // Lọc các bộ truyện thuộc vào danh mục này
            val comicsInCategory =
                comics.filter { it.categoryResourceId == category.stringResourceId }
            // Nếu có bộ truyện thuộc danh mục này, hiển thị tiêu đề danh mục và danh sách bộ truyện
            if (comicsInCategory.isNotEmpty()) {
                item {
                    CategoryHeader(category = category)
                }
                item {
                    FlowRow(
                        maxItemsInEachRow = 2,
                        modifier = modifier
                            .padding(horizontal = 35.dp)
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        for (comic in comicsInCategory) {
                            CardsComic(
                                comic = comic,
                                selectedComic = selectedComic
                                )
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun CategoryHeader(category: Category) {
    Text(
        text = stringResource(id = category.stringResourceId),
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Monospace,
        color = Color.White,
        fontSize = 18.sp,
        modifier = Modifier.padding(start = 18.dp, bottom = 25.dp),
        maxLines = 1, // Chỉ hiển thị một dòng
    )
}
@Preview
@Composable
fun CardsPreview() {
    //GridComic()
}