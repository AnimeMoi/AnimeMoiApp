package com.example.animemoi_app.screen.setting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign

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
