package com.example.animemoi_app.screen.setting.frame

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
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animemoi_app.common.setting.TitleWithIcon

@Composable
fun AmountComicFrame() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF4D4D4D), RoundedCornerShape(10.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0f, 0f, 0f, 0.5f), RoundedCornerShape(10.dp))
        ) {
            TitleWithIcon(
                title = "Số lượng truyện hiển thị",
                icon = Icons.Default.KeyboardArrowDown
            )
            Box {
                Divider(color = Color(0xFF808080), modifier = Modifier.padding(8.dp))
            }
            LayoutVerticalHorizontal("Chiều dọc", 2)
            LayoutVerticalHorizontal("Chiều ngang", 6)
        }
    }
}

@Composable
fun LayoutVerticalHorizontal(title: String, amountDefault: Int){
    var amount by remember { mutableIntStateOf(amountDefault) }
    amount = amount.coerceIn(1, 10)
    Row (
        modifier = Modifier.padding(8.dp, 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(0.8f)
        )
       Row (
           horizontalArrangement = Arrangement.Center,
           verticalAlignment = Alignment.CenterVertically,
           modifier = Modifier.fillMaxWidth()
       ) {
           Icon(
               Icons.Default.KeyboardArrowLeft,
               contentDescription = "Icon",
               tint = Color.White,
               modifier = Modifier.clickable { amount-- }
           )
           Text(
               text = amount.toString(),
               color = Color.White
           )
           Icon(
               Icons.Default.KeyboardArrowRight,
               contentDescription = "Icon",
               tint = Color.White,
               modifier = Modifier.clickable { amount++ }
           )
       }
    }
}

