package com.example.animemoi_app.common.comic

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animemoi_app.model.Comic


@Composable
fun Comic(
    moreInfo: Boolean,
    star: Float = 4.5F,
    views: Int = 0,
    follow: Int = 0,
    comic: Comic,
    selectedComic: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .padding(horizontal = 8.dp),
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    selectedComic(comic.comicId)
                }
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painterResource(comic.imageResourceId), contentDescription = null,
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
            text = stringResource(comic.stringResourceId),
            color = Color.White,
            modifier = Modifier
                .background(Color.Transparent)
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
    }
}
