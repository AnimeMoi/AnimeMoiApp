package com.example.animemoi_app.screen.setting.setting_app_frame

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animemoi_app.common.setting.InputListChoose
import com.example.animemoi_app.common.setting.TitleWithIcon

@Composable
fun ReadingModeFrame() {
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
                title = "Chế độ đọc",
                icon = Icons.Default.KeyboardArrowDown
            )
            Box {
                Divider(color = Color(0xFF808080), modifier = Modifier.padding(8.dp))
            }
            Mode("Chọn chiều đọc", "Chiều dọc", "Chiều ngang")
            InputListChoose(
                title = "Tự động lướt theo thời gian",
                listChoose = "Không bao giờ",
                icon = Icons.Default.KeyboardArrowUp,
                false
            )
            Mode("Chọn chế dộ tải ảnh", "Toàn bộ", "Từng trang")
        }
    }
}

@Composable
fun Mode(title: String, mode1: String, mode2: String) {
    var selectedMode by remember { mutableStateOf(mode1) }

    Row(
        modifier = Modifier.padding(8.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(0.4f)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            RadioOption(
                text = mode1,
                isSelected = selectedMode == mode1,
                onSelected = { selectedMode = mode1 }
            )
            RadioOption(
                text = mode2,
                isSelected = selectedMode == mode2,
                onSelected = { selectedMode = mode2 }
            )
        }
    }
}

@Composable
fun RadioOption(
    text: String,
    isSelected: Boolean,
    onSelected: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        RadioButton(
            selected = isSelected,
            onClick = onSelected,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color(0xFFFF6666)
            ),
            modifier = Modifier
                .clickable { onSelected() }
        )
        Text(
            text = text,
            fontSize = 10.sp,
            color = Color.White,
        )
    }
}