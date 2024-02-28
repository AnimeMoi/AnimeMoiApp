package com.example.animemoi_app.common.comic_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.SaveAlt
import androidx.compose.material.icons.filled.Scanner
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animemoi_app.R
import com.example.animemoi_app.common.ButtonCommon
import com.example.animemoi_app.common.ListSourceComic

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleDetail() {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black)
    ) {
        //Card title
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            shape = RoundedCornerShape(15.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.huongdanchamsoctieuzombie),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .blur(
                            radiusX = 1.dp,
                            radiusY = 2.dp,
                            edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(8.dp))
                        ),
                    contentScale = ContentScale.Crop
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
                        tint = Color.White
                    )
                    Column(
                        modifier = Modifier.padding(bottom = 15.dp),
                        verticalArrangement = Arrangement.spacedBy(5.dp)

                    ) {
                        Text(
                            text = "Hướng dẫn chăm sóc tiểu zombie",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)

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
        //Vote comic

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Đánh giá cho truyện nhé", color = Color.White, fontSize = 18.sp)
            Row {
                Icon(
                    imageVector = Icons.Default.StarRate,
                    contentDescription = null,
                    tint = Color.Yellow
                )
                Icon(
                    imageVector = Icons.Default.StarRate,
                    contentDescription = null,
                    tint = Color.Yellow
                )
                Icon(
                    imageVector = Icons.Default.StarRate,
                    contentDescription = null,
                    tint = Color.Yellow
                )
                Icon(
                    imageVector = Icons.Default.StarRate,
                    contentDescription = null,
                    tint = Color.Yellow
                )
                Icon(
                    imageVector = Icons.Default.StarRate,
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        }
        //Nav comic
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ButtonCommon(
                onClick = { /*TODO*/ },
                text = "Đọc",
                iconButton = Icons.Default.MenuBook
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Bookmark,
                    contentDescription = null,
                    tint = Color(0xFFFF6666)
                )
                Icon(
                    imageVector = Icons.Default.SaveAlt,
                    contentDescription = null,
                    tint = Color(0xFFFF6666)
                )
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null,
                    tint = Color(0xFFFF6666)
                )
            }
        }
        //Nav
        Box(modifier = Modifier.padding(vertical = 15.dp)) {
            ListSourceComic(listOf("Mô tả", "Thể loại", "Truyện liên quan", "Bình luận"))
        }
        //Information card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .padding(horizontal = 5.dp),
            colors = CardDefaults.cardColors(Color(0xFF444242))
        ) {
            Column(
                modifier = Modifier.padding(10.dp),
                horizontalAlignment = AbsoluteAlignment.Left,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Tên khác: Unagi Oni; Lươn Quỷ",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White
                )
                Text(
                    text = "Đại Y Lăng Điền Vô Cùng Phiền Phức là một tiểu thuyết Trung Quốc nổi tiếng thuộc thể loại lịch sử võ hiệp, được viết bởi nhà văn Trung Quốc Hồ Điệp Khê. Truyện kể về cuộc sống và cuộc phiêu lưu của nhân vật chính trong thời kỳ những cuộc tranh đấu giữa các môn phái võ thuật ở Trung Quốc cổ đại",
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White
                )
            }
        }
        //Chapter List
        var text by remember {
            mutableStateOf("")
        }
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp, 15.dp, 5.dp, 5.dp),
            colors = CardDefaults.cardColors(Color(0xFF444242))
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = null,
                    placeholder = {
                        Text(text = "Nhập để tìm chương, vi du 1124", fontSize = 7.sp)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.Black,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(40.dp),
                    shape = RoundedCornerShape(30.dp),
                    maxLines = 1,
                    textStyle = TextStyle(fontSize = 7.sp)
                )
                Icon(
                    imageVector = Icons.Default.MoreHoriz,
                    contentDescription = "Xem thêm",
                    tint = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Chương", color = Color.White)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "Mới nhất", color = Color(0xFFFF6666))
                    Text(text = "Cũ nhất", color = Color.White)
                }
            }
            Divider(
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            //ListChapterDetail
            LazyColumn {
                item {
                    ListChapterDetail()
                }

                item {
                    ListChapterDetail()
                }

                item {
                    ListChapterDetail()
                }

                item {
                    ListChapterDetail()
                }

                item {
                    ListChapterDetail()
                }

                item {
                    ListChapterDetail()
                }

                item {
                    ListChapterDetail()
                }

                item {
                    ListChapterDetail()
                }
            }
        }
    }

}
@Composable
fun ListChapterDetail() {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ){
            Text(text = "Chuơng 1",color = Color.White, fontSize = 12.sp)
            Text(text = "Tên chương(Nếu có)", color = Color.White, fontSize = 12.sp)
        }
        Row (verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ){
            Text(text = "12 Giờ trước", color = Color.White, fontSize = 12.sp)
            Row (verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)){
                Icon(
                    imageVector = Icons.Default.RemoveRedEye,
                    contentDescription = null, tint = Color.White,
                    modifier = Modifier.size(15.dp)
                    )
                Text(text = "4.5k", color = Color.White, fontSize = 12.sp)
            }
        }
    }
}

@Preview
@Composable
fun PreviewTitleDetail() {
    TitleDetail()
}