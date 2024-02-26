package com.example.animemoi_app.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.animemoi_app.R
import com.example.animemoi_app.common.ButtonCommon
import com.example.animemoi_app.common.ComeBack
import com.example.animemoi_app.common.setting.Input
import com.example.animemoi_app.common.setting.TitleWithIcon

@Composable
fun SettingScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ComeBack(title = "Cài đặt", navController)
        PersonalInformation(
            user = UserData(
                image = painterResource(id = R.drawable.deba),
                name = "Tuấn Kha",
                password = "TuanKha"
            )
        )
        LoginRegisterFrame()
        SettingSourceFrame()
    }
}

@Composable
fun ListSource() {
    val listSource = listOf(
        SourceData(painterResource(id = R.drawable.deba), "Nettruyen"),
        SourceData(painterResource(id = R.drawable.thegioihoanmy), "Tachiyomi"),
        SourceData(painterResource(id = R.drawable.requytroicho480197), "Tu tiên truyện")
    )
    LazyVerticalGrid(
        GridCells.Fixed(1),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(listSource) { source ->
            Source(source = source)
        }
    }
}

@Composable
fun Source(source: SourceData) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = source.image,
            contentDescription = "Image",
            Modifier.size(40.dp)
        )
        Text(
            text = source.name,
            color = Color.White,
            modifier = Modifier
                .padding(16.dp, 0.dp)
                .fillMaxWidth(0.9f)
        )
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Icon",
            tint = Color.White
        )
    }
}

@Composable
fun SettingSourceFrame() {
    Column(
        modifier = Modifier
            .padding(16.dp, 0.dp, 16.dp, 16.dp)
            .fillMaxWidth()
            .background(Color(0xFF4D4D4D), RoundedCornerShape(10.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Cài đặt nguồn truyện",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier
                    .padding(0.dp, 0.dp, 8.dp, 0.dp)
            )
            Input(text = "NSFW")
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0f, 0f, 0f, 0.5f), RoundedCornerShape(10.dp))
            ) {
                TitleWithIcon(
                    title = "Nguồn truyện của bạn",
                    icon = Icons.Default.KeyboardArrowUp
                )
                Box {
                    Divider(color = Color(0xFF808080), modifier = Modifier.padding(8.dp))
                }
                TitleWithIcon(title = "Thêm nguồn mới", icon = Icons.Default.Add)
                ListSource()
            }
        }
    }
}

@Composable
fun LoginRegisterFrame() {
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
                modifier = Modifier
                    .fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 16.dp, 0.dp, 0.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.5f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ButtonCommon(
                        text = "Đăng nhập",
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ButtonCommon(
                        text = "Đăng kí",
                        onClick = { /*TODO*/ },
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
    }
}

@Composable
fun MessageDialog(message: String, onExitClick: () -> Unit) {
    AlertDialog(
        containerColor = Color(0xFFCCCCCC),
        text = {
            Text(text = message)
        },
        onDismissRequest = { },
        confirmButton = {
            TextButton(
                onClick = {
                    onExitClick()
                },
                colors = ButtonDefaults.buttonColors(Color(0xFFFF6666))

            ) {
                Text("Đồng ý")
            }
        },
    )
}

@Composable
fun EditDialog(
    initialUserName: String,
    onConfirmClick: (String, String, String) -> Unit,
    onExitClick: () -> Unit
) {
    var userName by remember { mutableStateOf(initialUserName) }
    var newPassword by remember { mutableStateOf("") }
    var newPassword2 by remember { mutableStateOf("") }
    var showPass1 by remember { mutableStateOf(false) }
    var showPass2 by remember { mutableStateOf(false) }

    AlertDialog(
        containerColor = Color(0xFFCCCCCC),
        onDismissRequest = { },
        title = {
            Text(
                "Cập nhật thông tin",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        text = {
            Column {
                TextField(
                    value = userName,
                    onValueChange = { name -> userName = name },
                    label = { Text("Biệt danh") },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xFFd9d9d9),
                        focusedContainerColor = Color(0xFFd9d9d9),
                        focusedIndicatorColor = Color(0xFFFF9999)
                    )
                )
                TextField(
                    value = newPassword,
                    onValueChange = { password -> newPassword = password },
                    label = { Text("Mật khẩu mới") },
                    visualTransformation = if (showPass1) VisualTransformation.None else PasswordVisualTransformation(),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xFFd9d9d9),
                        focusedContainerColor = Color(0xFFd9d9d9),
                        focusedIndicatorColor = Color(0xFFFF9999)
                    ),
                    trailingIcon = {
                        if (newPassword != "")
                            Icon(
                                Icons.Outlined.VisibilityOff,
                                contentDescription = "",
                                modifier = Modifier.clickable { showPass1 = !showPass1 }
                            )
                    }
                )
                TextField(
                    value = newPassword2,
                    onValueChange = { password -> newPassword2 = password },
                    label = { Text("Nhập lại mật khẩu mới") },
                    visualTransformation = if (showPass2) VisualTransformation.None else PasswordVisualTransformation(),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xFFd9d9d9),
                        focusedContainerColor = Color(0xFFd9d9d9),
                        focusedIndicatorColor = Color(0xFFFF9999)
                    ),
                    trailingIcon = {
                        if (newPassword2 != "")
                            Icon(
                                Icons.Outlined.VisibilityOff,
                                contentDescription = "",
                                modifier = Modifier.clickable { showPass2 = !showPass2 }
                            )
                    }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = { onConfirmClick(userName, newPassword, newPassword2) },
                colors = ButtonDefaults.buttonColors(Color(0xFFFF6666))
            ) {
                Text("Đồng ý")
            }
        },
        dismissButton = {
            Button(
                onClick = { onExitClick() },
                colors = ButtonDefaults.buttonColors(Color(0xFFFF6666))
            ) {
                Text("Thoát")
            }
        }
    )
}

@Composable
fun PersonalInformation(user: UserData) {
    var showPassword by remember { mutableStateOf(false) }
    var isEditing by remember { mutableStateOf(false) }
    var messageVisible by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color(0xFF4D4D4D), RoundedCornerShape(10.dp))

    ) {
        Icon(
            Icons.Default.Edit,
            contentDescription = "",
            modifier = Modifier
                .padding(0.dp, 16.dp, 16.dp, 0.dp)
                .size(20.dp)
                .align(Alignment.End)
                .border(1.dp, Color(0xffff6666), RoundedCornerShape(5.dp))
                .clickable { isEditing = !isEditing },
            tint = Color(0xFFFF6666)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.3f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = user.image,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .height(72.dp)
                )
            }
            Column(
                modifier = Modifier
                    .padding(8.dp, 0.dp, 16.dp, 0.dp)
                    .fillMaxWidth()
            ) {
                Row {
                    Column {
                        Text(
                            text = "Biệt danh: ",
                            color = Color.White
                        )
                        Text(
                            text = "Mật khẩu: ",
                            color = Color.White,
                            modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.9f),
                    ) {
                        Text(
                            text = user.name,
                            color = Color.White,
                            modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 0.dp)
                        )
                        TextField(
                            shape = RectangleShape,
                            value = user.password,
                            onValueChange = {},
                            readOnly = true,
                            enabled = false,
                            colors = TextFieldDefaults.colors(
                                disabledContainerColor = Color(0xFF4D4D4D),
                                disabledTextColor = Color.White,
                                disabledIndicatorColor = Color.Transparent
                            ),
                            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "")
                        Text(text = "")
                        Icon(
                            if (showPassword) Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff,
                            contentDescription = "",
                            modifier = Modifier
                                .clickable {
                                    showPassword = !showPassword
                                },
                            tint = Color(0xFFFF6666)

                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 16.dp, 8.dp, 8.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(0.5f),
                horizontalAlignment = Alignment.Start
            ) {
                ButtonCommon(
                    text = "Xóa tài khoản",
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                ButtonCommon(
                    text = "Đăng xuất",
                    onClick = { /*TODO*/ },
                    iconButton = Icons.Default.Logout
                )
            }
        }
    }
    if (isEditing) {
        EditDialog(
            initialUserName = user.name,
            onConfirmClick = { updateName, updatePassword, updatePassword2 ->
                when {
                    updateName != "" && updateName != user.name && updatePassword != "" && updatePassword == updatePassword2 && updatePassword != user.password -> {
                        user.name = updateName
                        user.password = updatePassword
                        messageVisible = true
                        message = "Cập nhật thành công"
                    }

                    updateName != "" && updateName != user.name -> {
                        user.name = updateName
                        messageVisible = true
                        message = "Đã cập nhật biệt danh"
                    }

                    updatePassword != "" && updatePassword == updatePassword2 && updatePassword != user.password -> {
                        user.password = updatePassword
                        messageVisible = true
                        message = "Đã cập nhật mật khẩu mới"
                    }

                    else -> {
                        messageVisible = true
                        message = "Cập nhật thất bại"
                    }
                }
                isEditing = false
            },
            onExitClick = { isEditing = false }
        )
    }
    if (messageVisible) {
        MessageDialog(message = message, onExitClick = { messageVisible = false })
    }
}

@Preview(showBackground = true)
@Composable
fun SettingScreenPreview() {
    SettingScreen(navController = rememberNavController())
}

data class UserData(val image: Painter, var name: String, var password: String)
data class SourceData(val image: Painter, var name: String)
