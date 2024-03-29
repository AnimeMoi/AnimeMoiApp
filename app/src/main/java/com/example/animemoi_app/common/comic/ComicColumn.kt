package com.example.animemoi_app.common.comic

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animemoi_app.R
import com.example.animemoi_app.model.Comic
import com.example.animemoi_app.model.ComicTest

@Composable
fun ComicColumn(
    comic: ComicTest,
    showStatus: Boolean,
    showLastTimeUpdate: Boolean,
    selectedComic: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(horizontal = 15.dp)
            .clickable {
                selectedComic(comic.comicId)
            },
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Black),
        shape = RoundedCornerShape(5.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = comic.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(8.dp)), // Round corners
                contentScale = ContentScale.Crop // Scale the image content,
            )
            Column(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = comic.stringResourceId),
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    maxLines = 1, // Chỉ hiển thị một dòng
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = stringResource(R.string.chapter) + " " + comic.lastChapter,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 13.sp
                )
                if (showStatus) {
                    Text(
                        text = stringResource(R.string.status) + ": " + stringResource(id = comic.status),
                        color = Color.White,
                        fontWeight = FontWeight.Light,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 13.sp
                    )
                }
                if (showLastTimeUpdate) {
                    Text(
                        text = stringResource(R.string.update) + ": " + comic.timeUpdate,
                        color = Color.White,
                        fontWeight = FontWeight.Light,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 13.sp
                    )
                }
            }
        }
    }
}
