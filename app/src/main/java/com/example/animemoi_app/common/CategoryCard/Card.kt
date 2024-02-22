package com.example.animemoi_app.common.CategoryCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animemoi_app.data.ComicData
import com.example.animemoi_app.model.Category
import com.example.animemoi_app.model.Comic

@Composable
fun CardsComic(
    comic: Comic
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .width(150.dp)
                .height(200.dp),
            elevation = CardDefaults.cardElevation(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Black
            )
        ) {
            Image(
                painter = painterResource(id = comic.imageResourceId),
                contentDescription = stringResource(id = comic.stringResourceId),
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillWidth
            )


        }
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

@Composable
fun GridComic(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(1.dp),
        horizontalArrangement = Arrangement.spacedBy(1.dp),
        modifier = modifier
    ) {
        val comics = ComicData().loadComicCard()
        items(comics) { comic ->
            CardsComic(comic = comic)
        }
    }
}

@Composable
fun CategoryCard(category: Category, modifier: Modifier = Modifier) {
    Column() {
        Text(text = stringResource(id = category.stringResourceId))
    }
}

@Preview
@Composable
fun CardsPreview() {
    GridComic()
}