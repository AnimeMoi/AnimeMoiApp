package com.example.animemoi_app.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.animemoi_app.R
import com.example.animemoi_app.common.navigation.Screens

@Composable
fun Bar(navController: NavHostController, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Black)
            .height(40.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = stringResource(R.string.app_name),
            modifier = modifier
                .padding(16.dp, 8.dp, 0.dp, 8.dp)
                .align(Alignment.CenterVertically),
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 19.5.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.bell),
            modifier = modifier
                .padding(0.dp, 8.dp, 16.dp, 8.dp)
                .clickable {
                    navController.navigate(Screens.NotificationScreen.name)
                },
            contentDescription = "Notification",
            tint = Color.White,
        )
    }
}
