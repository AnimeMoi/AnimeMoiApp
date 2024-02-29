package com.example.animemoi_app.common.comic

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animemoi_app.data.ComicData

@Composable
fun ComicGrid() {
    val comics = ComicData().loadComicCard()

    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        columns = GridCells.Adaptive(minSize = 128.dp),
    ) {
        items(comics) { comic ->
            Box(modifier = Modifier.padding(8.dp)) {
                Comic(
                    name = comic.stringResourceId,
                    image = comic.imageResourceId,
                    moreInfo = true
                )
            }
        }
    }
}

@Preview
@Composable
fun ComicGridPreview() {
    ComicGrid()
}