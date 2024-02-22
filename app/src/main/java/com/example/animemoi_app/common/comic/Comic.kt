package com.example.animemoi_app.common.comic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun Comic(
    imageUrl: String,
    name: String,
    moreInfo: Boolean,
    star: Float = 4.5F,
    views: Int = 0,
    follow: Int = 0
) {
    Card(modifier = Modifier.background(Color.Transparent)) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(imageUrl).crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
        Card(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                Row {
                    Icon(Icons.Default.Star, contentDescription = null)
                    Text(star.toString())
                }
                Row {
                    Icon(Icons.Default.Add, contentDescription = null)
                    Text(views.toString())
                }
                Row {
                    Icon(Icons.Default.Favorite, contentDescription = null)
                    Text(follow.toString())
                }
            }
        }
        Text(
            text = name,
            modifier = Modifier
                .background(Color.Transparent)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
fun ComicPreview() {
    Comic(
        "https://www.nettruyenup.vn/images/comics/tho-san-hang-s-khong-muon-tro-thanh-ac-nu.jpg",
        name = "Test",
        moreInfo = false
    )
}