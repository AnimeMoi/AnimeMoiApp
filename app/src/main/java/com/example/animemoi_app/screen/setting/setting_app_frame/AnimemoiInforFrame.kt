package com.example.animemoi_app.screen.setting.setting_app_frame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animemoi_app.common.setting.TitleWithIcon

@Composable
fun AnimemoiInforFrame() {
    Column(
        modifier = Modifier
            .padding(0.dp, 8.dp, 0.dp, 0.dp)
            .fillMaxWidth()
            .background(Color(0xFF4D4D4D), RoundedCornerShape(10.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0f, 0f, 0f, 0.5f), RoundedCornerShape(10.dp))
        ) {
            TitleWithIcon(
                title = "Thông tin AnimeMoi",
                icon = Icons.Default.KeyboardArrowDown
            )
            Box {
                Divider(color = Color(0xFF808080), modifier = Modifier.padding(8.dp))
            }
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(
                    text = "Thông tin nhà phát triển",
                    color = Color.White,
                    fontSize = 12.sp
                )
                Text(
                    text = "Nguyễn Văn Hoàng - Nhà phát triển chính - nvh@gmail.com",
                    color = Color.Gray,
                    fontSize = 8.sp
                )
                Text(
                    text = "Lê Đức Tuấn Vũ - Nhà phát triển chính - leductuanvu5@gmail.com",
                    color = Color.Gray,
                    fontSize = 8.sp
                )
                Text(
                    text = "Lê Tuấn Kha - Nhà phát triển chính - Kha090403@gmail.com",
                    color = Color.Gray,
                    fontSize = 8.sp
                )
            }
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(
                    text = "Bản quyền và giấy phép",
                    color = Color.White,
                    fontSize = 12.sp
                )
                Text(
                    text = "© 2024 AnimeMoi. Bảo lưu mọi quyền.",
                    color = Color.Gray,
                    fontSize = 8.sp
                )
            }
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(
                    text = "Liên kết",
                    color = Color.White,
                    fontSize = 12.sp
                )
                Text(
                    text = "Trang chính thức: https://animemoireact.vercel.app/",
                    color = Color.Gray,
                    fontSize = 8.sp
                )
                Text(
                    text = "Repository Github: https://github.com/AnimeMoi",
                    color = Color.Gray,
                    fontSize = 8.sp
                )
            }
            Text(
                text = "Xin chân thành cảm ơn tất cả những người đã đóng góp vào sự phát triển của ứng dụng!",
                color = Color.Gray,
                fontSize = 8.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}