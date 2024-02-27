package com.example.animemoi_app.screen.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animemoi_app.R
import com.example.animemoi_app.common.setting.Input
import com.example.animemoi_app.common.setting.InputIcon
import com.example.animemoi_app.common.setting.InputListChoose
import com.example.animemoi_app.screen.setting.setting_app_frame.AmountComicFrame
import com.example.animemoi_app.screen.setting.setting_app_frame.ReadingModeFrame
import com.example.animemoi_app.screen.setting.setting_app_frame.StorageManagermentFrame

@Composable
fun SettingAppFrame() {
    Column(
        modifier = Modifier
            .padding(16.dp, 0.dp, 16.dp, 16.dp)
            .fillMaxWidth()
            .background(Color(0xFF4D4D4D), RoundedCornerShape(10.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Cài đặt ứng dụng",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier
                    .padding(0.dp, 0.dp, 8.dp, 0.dp)
            )
            InputIcon(text = "Chọn màu nền", icon = painterResource(id = R.drawable.color))
            InputListChoose(
                title = "Chọn ngôn ngữ",
                listChoose = "Tiếng việt",
                icon = Icons.Default.KeyboardArrowUp,
                background = true)
            Input(text = "Ẩn lịch sử")
            Input(text = "Đồng bộ tiến trình")
            Input(text = "Khóa xoay")
            AmountComicFrame()
            ReadingModeFrame()
            StorageManagermentFrame()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    SettingAppFrame()
}