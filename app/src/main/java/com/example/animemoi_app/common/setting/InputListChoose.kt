package com.example.animemoi_app.common.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputListChoose(title: String, listChoose: String, icon: ImageVector, background: Boolean){
    Row(
        modifier = Modifier
            .padding(0.dp, 8.dp)
            .fillMaxWidth()
            .height(40.dp)
            .background(if(background) Color(0f, 0f, 0f, 0.5f) else Color.Transparent, CircleShape),
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp, 4.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
               Text(
                   text = listChoose,
                   color = Color.White,
                   fontSize = 12.sp
               )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    icon,
                    tint = Color.White,
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { }
                )
            }
        }
    }
}