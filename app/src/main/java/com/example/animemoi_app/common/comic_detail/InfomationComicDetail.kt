package com.example.animemoi_app.common.comic_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InformationComicDetail() {
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
}

@Preview
@Composable
fun PreviewInformationComicDetail() {
    InformationComicDetail()
}