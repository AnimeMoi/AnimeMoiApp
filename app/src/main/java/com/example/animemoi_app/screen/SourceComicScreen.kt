package com.example.animemoi_app.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.animemoi_app.R
import com.example.animemoi_app.common.ComeBack
import com.example.animemoi_app.data.SourceData
import com.example.animemoi_app.model.SourceComic

@Composable
fun SourceComicScreen(navController: NavHostController) {
    val items = SourceData().loadSourceData()

    ComeBack(title = stringResource(id = R.string.select_source), navController = navController)
    LazyColumn(
        modifier = Modifier.padding(start = 12.dp, top = 60.dp, end = 12.dp), contentPadding = PaddingValues(12.dp)
    ) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painterResource(id = item.icon), contentDescription = null, modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = item.name, modifier = Modifier.align(Alignment.CenterVertically), color = Color.White
                )
                Box(
                    modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd
                ) {
                    Icon(
                        Icons.Default.Add, contentDescription = null,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SourceComicScreenPreview() {
    SourceComicScreen(rememberNavController())
}