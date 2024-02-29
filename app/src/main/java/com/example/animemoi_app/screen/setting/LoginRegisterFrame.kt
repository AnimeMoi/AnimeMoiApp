package com.example.animemoi_app.screen.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.animemoi_app.R
import com.example.animemoi_app.common.ButtonCommon

@Composable
fun LoginRegisterFrame(navController: NavHostController) {
    Box {
        Column(
            modifier = Modifier
                .padding(16.dp, 0.dp, 16.dp, 16.dp)
                .fillMaxWidth()
                .background(Color(0xFF4D4D4D), RoundedCornerShape(10.dp))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Bạn cần đăng nhập để quản lí thông tin cũng như sử dụng những tính nằng đặc biệt của ứng dụng",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 16.dp, 0.dp, 0.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(0.5f), horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ButtonCommon(
                            text = "Đăng nhập", onClick = { navController.navigate("LoginScreen") }, modifier = Modifier
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ButtonCommon(
                            text = "Đăng kí",
                            onClick = { navController.navigate("RegisterScreen") },
                        )
                    }
                }
                Text(
                    text = "Hoặc đăng nhập bằng",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .padding(0.dp, 16.dp, 0.dp, 0.dp)
                        .fillMaxWidth()
                )
                Row(
                    modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp)
                ) {
                    Image(painterResource(id = R.drawable.google),
                        contentDescription = "Google",
                        modifier = Modifier
                            .fillMaxWidth(0.3f)
                            .clickable { })
                    Image(painterResource(id = R.drawable.facebook),
                        contentDescription = "Facebook",
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .clickable { })
                    Image(painterResource(id = R.drawable.github),
                        contentDescription = "Github",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { })
                }
            }
        }
    }
}
