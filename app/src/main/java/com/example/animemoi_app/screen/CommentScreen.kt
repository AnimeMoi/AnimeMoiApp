package com.example.animemoi_app.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.animemoi_app.R
import com.example.animemoi_app.common.ComeBack

@Composable
fun CommentScreen(title: String, navController: NavHostController) {
    var commentValue by remember { mutableStateOf("") }

    Column {
        ComeBack(title = title, navController = navController)
        Card(
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(id = R.string.comments),
                    fontWeight = FontWeight.Bold
                )
                Text(text = stringResource(id = R.string.total_comments))
            }
            LazyColumn(
                modifier = Modifier.padding(top = 12.dp)
            ) {
                items(5) { CommentItem() }
            }
        }
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.BottomStart),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier.weight(1f) // Set weight for TextField
                ) {
                    TextField(
                        value = commentValue,
                        onValueChange = { value ->
                            commentValue = value
                        },
                        placeholder = {
                            Text(
                                text = "Viết gì đó",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(
                                RoundedCornerShape(
                                    60.dp
                                )
                            )
                    )
                }
                Icon(
                    Icons.Default.Send, contentDescription = null,
                    modifier = Modifier
                        .size(35.dp),
                )
            }
        }
    }
}

@Composable
fun CommentItem() {

}

@Preview(showSystemUi = true)
@Composable
fun CommentScreenPreview() {
    CommentScreen(title = "Chap 1: Cùng nhau nở hoa", navController = rememberNavController())
}