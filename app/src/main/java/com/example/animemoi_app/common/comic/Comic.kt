package com.example.animemoi_app.common.comic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl).crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(150.dp)
                )
                if (moreInfo) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .background(
                                Color.Black.copy(0.5f)
                            )
                            .width(150.dp),
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.padding(0.dp, 8.dp)

                        ) {
                            Icon(
                                Icons.Default.Star,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .size(16.dp)
                            )
                            Text(
                                star.toString(),
                                fontSize = 10.sp,
                                color = Color.White
                            )
                            Icon(
                                Icons.Default.RemoveRedEye,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .size(16.dp)
                            )
                            Text(
                                views.toString(),
                                fontSize = 10.sp,
                                color = Color.White
                            )
                            Icon(
                                Icons.Default.Favorite,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .size(16.dp)
                            )
                            Text(
                                follow.toString(),
                                fontSize = 10.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }

        }
        Text(
            text = name,
            color = Color.White,
            modifier = Modifier
                .background(Color.Transparent)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(top = 10.dp),
            textAlign = TextAlign.Center
        )
    }
}


@Preview
@Composable
fun ComicPreview() {
    Comic(
        "https://www.nettruyenup.vn/images/comics/tho-san-hang-s-khong-muon-tro-thanh-ac-nu.jpg",
        moreInfo = true,
        name = "Test2",
        views = 1,
        follow = 60
    )

}