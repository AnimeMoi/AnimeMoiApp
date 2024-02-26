package com.example.animemoi_app.common.setting

import android.widget.Switch
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Input(text: String) {
    var checked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(0.dp, 8.dp)
            .fillMaxWidth()
            .height(40.dp)
            .background(Color(0f, 0f, 0f, 0.5f), CircleShape),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp, 4.dp)
                .fillMaxWidth(),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = text,
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Switch(
                    checked = checked,
                    onCheckedChange = {checked = !checked},
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = Color(0xFFFF6666),
                        uncheckedThumbColor = Color.Gray,
                        uncheckedTrackColor = Color.Black,
                        uncheckedBorderColor = Color.Gray
                    )
                )
            }
        }
    }
}
