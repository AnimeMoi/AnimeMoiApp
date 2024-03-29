package com.example.animemoi_app.common.comic_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Scanner
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleDetail(
    comicImage: Int,
    comicTitle: Int,
    navigateUp: () -> Unit
) {
    //Card title
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f),
        shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = comicImage),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Gray
                            )
                        )
                    )
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 15.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            navigateUp()
                        }
                )
                Column(
                    modifier = Modifier.padding(bottom = 15.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)

                ) {
                    Text(
                        text = stringResource(id = comicTitle),
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.BottomStart, true),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        //icon1
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = Icons.Default.Scanner,
                                contentDescription = "Đang cập nhật",
                                tint = Color.White
                            )
                            Text(text = "Đang cập nhật", color = Color.White)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        //icon2
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = Icons.Default.PermIdentity,
                                contentDescription = "Tác giả",
                                tint = Color.White
                            )
                            Text(text = "Gumayushi", color = Color.White)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        //icon3
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Đánh giá",
                                tint = Color.White
                            )
                            Text(text = "4.6", color = Color.White)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        //icon4
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = Icons.Default.RemoveRedEye,
                                contentDescription = "Số lượt xem",
                                tint = Color.White
                            )
                            Text(text = "46k", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}
