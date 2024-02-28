package com.example.animemoi_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.animemoi_app.common.ButtonCommon
import com.example.animemoi_app.common.ComeBack

@Composable
fun RegisterScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .background(Color.Black)
    ) {
        ComeBack(title = "AnimeMoi", navController)
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight(0.9f)
        ) {
            TextFieldInput("Tên đăng nhập", Icons.Rounded.Clear, false)
            TextFieldInput("Email", Icons.Rounded.Clear, false)
            TextFieldInput("Mật khẩu", Icons.Rounded.VisibilityOff, true)
            TextFieldInput("Nhập lại mật khẩu", Icons.Rounded.VisibilityOff, true)
            ButtonCommon(
                text = "Đăng kí",
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp)
            )
            CheckAccept()
            Text(
                text = "Hoặc đăng nhập",
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            LoginChoose()
        }
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = "Chức năng đăng nhập nhanh qua Google, Facebook, Github do Google, Facebook, Github cung cấp và bảo mật an toàn cho tài khoản của bạn",
                color = Color.White,
                fontSize = 8.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp, 16.dp)
            )

        }
    }
}

@Composable
fun CheckAccept() {
    var checked by remember { mutableStateOf(false)}
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Checkbox(
            checked = checked ,
            onCheckedChange = {checked = !checked},
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFFFF6666),
            )
        )
        Text(
            text = "Điều khoản sử dụng",
            color = Color(0xFFFF6666),
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp, 16.dp)
        )
    }
}
