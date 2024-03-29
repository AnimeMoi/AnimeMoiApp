package com.example.animemoi_app.screen.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.animemoi_app.common.ButtonCommon
import com.example.animemoi_app.model.UserData

@Composable
fun PersonalInformation(user: UserData) {
    var showPassword by remember { mutableStateOf(false) }
    var isEditing by remember { mutableStateOf(false) }
    var messageVisible by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }
    Box {
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
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.3f), horizontalAlignment = Alignment.CenterHorizontally
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
                                text = "Biệt danh: ", color = Color.White
                            )
                            Text(
                                text = "Mật khẩu: ",
                                color = Color.White,
                                modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp)
                            )
                        }
                        Column(
                            modifier = Modifier.fillMaxWidth(0.9f),
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
                                modifier = Modifier.clickable {
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
                    modifier = Modifier.fillMaxWidth(0.5f), horizontalAlignment = Alignment.Start
                ) {
                    ButtonCommon(
                        text = "Xóa tài khoản", onClick = { /*TODO*/ }, modifier = Modifier
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End
                ) {
                    ButtonCommon(
                        text = "Đăng xuất", onClick = { /*TODO*/ }, iconButton = Icons.Default.Logout
                    )
                }
            }
        }
        if (isEditing) {
            EditDialog(initialUserName = user.name, onConfirmClick = { updateName, updatePassword, updatePassword2 ->
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
            }, onExitClick = { isEditing = false })
        }
        if (messageVisible) {
            MessageDialog(message = message, onExitClick = { messageVisible = false })
        }
    }
}
