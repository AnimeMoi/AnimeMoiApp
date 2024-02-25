package com.example.animemoi_app.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.animemoi_app.R
import com.example.animemoi_app.common.ComeBack
import com.example.animemoi_app.common.history.GridHistoryCard

@Composable
fun NotificationScreen(navController: NavHostController) {
    val isLogin = true
    val systemNotification = true
    val systemNotificationContent =
        "Hệ thống thông báo dừng hệ thống để nâng cấp vào lúc 22:00 ngày 21/1/2024. Mong quý khách có một trải nghiệm thú vị với phiên bản mới"
    val systemNotificationTimeUpdate = "22:00 21/1/2024"

    ComeBack(title = "Thông báo", navController)

    if (!isLogin) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.bell), contentDescription = null, Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "Bạn cần đăng nhập để nhận thông báo",
                fontSize = 18.0.sp,
                color = Color.White,
            )
        }
    } else {
        Column {
            if (systemNotification) {
                Column(Modifier.padding(start = 12.dp, top = 48.dp, end = 0.dp, bottom = 0.dp)) {
                    Text(
                        systemNotificationContent,
                        color = Color.White,
                    )
                    Text(
                        systemNotificationTimeUpdate,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Light,
                        color = Color.White,
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            GridHistoryCard(showStatus = false, showLastTimeUpdate = true)
        }
    }
}

@Preview
@Composable
fun NotificationScreenPreview() {
    val navController: NavHostController = rememberNavController()
    NotificationScreen(navController)
}