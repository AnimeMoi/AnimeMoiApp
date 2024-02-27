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
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animemoi_app.common.setting.InputListChoose
import com.example.animemoi_app.common.setting.TitleWithIcon

@Composable
fun StorageManagermentFrame() {
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
                title = "Quản lí bộ nhớ",
                icon = Icons.Default.KeyboardArrowDown
            )
            Box {
                Divider(color = Color(0xFF808080), modifier = Modifier.padding(8.dp))
            }
            CleanStorage("Dung lượng truyện tải về", "1gb")
            InputListChoose(
                title = "Số lượng cache mong muốn",
                listChoose = "500mb",
                icon = Icons.Default.KeyboardArrowUp,
                false
            )
            CleanStorage("Cache", "100mb")
        }
    }
}

@Composable
fun CleanStorage(title: String, capacity: String) {
    Row (
        modifier = Modifier
            .padding(8.dp, 8.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier.fillMaxWidth(0.5f)
        )
        Text(
            text = capacity,
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier.fillMaxWidth(0.5f)
        )
        Text(
            text = "Làm sạch",
            textAlign = TextAlign.Right,
            textDecoration = TextDecoration.Underline,
            color = Color(0xFFFF6666),
            fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {  }
        )
    }
}