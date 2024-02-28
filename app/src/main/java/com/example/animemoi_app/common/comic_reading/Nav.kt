package com.example.animemoi_app.common.comic_reading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Minimize
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SyncAlt
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NavDetailComic() {
    Row (
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
        Icon(imageVector = Icons.Default.SyncAlt, contentDescription = null, tint = Color.White)
        Row(){
            Icon(imageVector = Icons.Default.ArrowBackIos, contentDescription = null, tint = Color.White)
            Text(text = "1" , color = Color.White)
            Icon(imageVector = Icons.Default.Minimize, contentDescription = null, tint = Color.White)
            Text(text = "10", color = Color.White)
            Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = null, tint = Color.White)
        }
        Icon(imageVector = Icons.Default.Warning, contentDescription = null, tint = Color.White)
        Icon(imageVector = Icons.Default.Settings, contentDescription = null, tint = Color.White)

    }
}
@Preview
@Composable
fun PreviewNavDetail() {
    NavDetailComic()
}