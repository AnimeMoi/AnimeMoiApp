package com.example.animemoi_app.screen.setting.setting_app_frame

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animemoi_app.common.setting.Input
import com.example.animemoi_app.common.setting.TitleWithIcon

@Composable
fun PrivacyFrame() {
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
                title = "Bảo mật riêng tư",
                icon = Icons.Default.KeyboardArrowDown
            )
            Box {
                Divider(color = Color(0xFF808080), modifier = Modifier.padding(8.dp))
            }
            Input(text = "Bật/ Tắt", false)
            PasswordPrivacy()
            Clear()
        }
    }
}

@Composable
fun Clear(){
    Row (
        modifier = Modifier
            .padding(8.dp, 8.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = "Xóa khóa bảo mật",
            color = Color(0xFFFF6666),
            fontSize = 12.sp,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable {  }
        )
        Text(
            text = "Lưu ý sau khi xóa, dữ liệu thư viện sẽ mất toàn bộ",
            fontSize = 10.sp,
            color = Color.Gray,
            textAlign = TextAlign.Right,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun PasswordPrivacy() {
    val password = "password"
    Row (
        modifier = Modifier
            .padding(8.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Mật khẩu bảo mật",
            color = Color.White,
            fontSize = 12.sp,
        )
        TextField(
            value = password,
            onValueChange = {},
            enabled = false,
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(
                disabledContainerColor = Color.Transparent,
                disabledIndicatorColor = Color.White,
                disabledTextColor = Color.White
            )
        )
    }
}