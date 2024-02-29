package com.example.animemoi_app.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonCommon(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    contentColor: Color = Color.White,
    backgroundColor: Color = Color(0xFFFF6666),
    iconButton: ImageVector? = null,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .background(color = backgroundColor, shape = CircleShape),
        colors = ButtonDefaults.textButtonColors(
            contentColor = contentColor
        )
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
        if (iconButton != null) {
            Icon(
                imageVector = iconButton,
                contentDescription = "",
                Modifier.size(24.dp)
                    .padding(8.dp, 0.dp, 0.dp, 0.dp)
            )
        }
    }
}

@Preview
@Composable
fun ButtonCommonPreview() {
    ButtonCommon(
        text = "Click me",
        onClick = { /* TODO: Handle button click */ },
        iconButton = Icons.Default.AccountBox
    )
}
