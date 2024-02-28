package com.example.animemoi_app.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.RemoveRedEye
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.animemoi_app.R
import com.example.animemoi_app.common.ButtonCommon
import com.example.animemoi_app.common.ComeBack

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .background(Color.Black)
    ) {
        ComeBack(title = "AnimeMoi", rememberNavController())
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight(0.8f)
        ) {
            TextFieldInput("Tên đăng nhập", Icons.Rounded.Clear, false)
            TextFieldInput("Mật khẩu", Icons.Rounded.VisibilityOff, true)
            ButtonCommon(
                text = "Đăng nhập",
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp)
            )
            TextAction()
            Text(
                text = "Hoặc",
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
                text = "Tiếp tục đồng nghĩa với việc bạn đã đọc và đồng ý với Điều khoản sử dụng và Thỏa thuận dịch vụ người dùng",
                color = Color(0xFFFF6666),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(16.dp, 16.dp)
            )
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
fun LoginChoose() {
    Row(
        modifier = Modifier
            .padding(0.dp, 16.dp, 0.dp, 0.dp)
    ) {
        Image(
            painterResource(id = R.drawable.google),
            contentDescription = "Google",
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .clickable { }
        )
        Image(
            painterResource(id = R.drawable.facebook),
            contentDescription = "Facebook",
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .clickable { }
        )
        Image(
            painterResource(id = R.drawable.github),
            contentDescription = "Github",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
        )
    }
}

@Composable
fun TextAction() {
    Row(
        modifier = Modifier
            .padding(0.dp, 16.dp)
    ) {
        Text(
            text = "Quên mật khẩu",
            color = Color(0xFFFF6666),
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.5f)
        )
        Text(
            text = "Đăng kí tài khoản",
            color = Color(0xFFFF6666),
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun TextFieldInput(label: String, trailingIcon: ImageVector, password: Boolean) {
    var userInput by remember { mutableStateOf("") }
    var pass by remember {
        mutableStateOf(password)
    }
    Surface(
        border = BorderStroke(1.dp, Color.Gray),
        shape = CircleShape,
        color = Color.Transparent,
        modifier = Modifier.padding(0.dp, 8.dp)
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = userInput,
            onValueChange = { value -> userInput = value },
            placeholder = {
                Text(
                    text = label,
                )
            },
            visualTransformation = if (pass) PasswordVisualTransformation() else VisualTransformation.None,
            shape = CircleShape,
            colors = TextFieldDefaults.colors(
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White,
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = Color(0xFFFF6666)
            ),
            singleLine = true,
            trailingIcon = {
                if (userInput != "") {
                    Icon(
                        imageVector = if (password) {
                            if (pass) Icons.Rounded.VisibilityOff else Icons.Rounded.Visibility
                        } else trailingIcon,
                        contentDescription = "",
                        tint = Color(0xFFFF6666),
                        modifier = Modifier
                            .clickable {
                                if (password)
                                    pass = !pass
                                else
                                    userInput = ""
                            }
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}