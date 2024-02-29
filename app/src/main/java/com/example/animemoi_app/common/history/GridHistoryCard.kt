package com.example.animemoi_app.common.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animemoi_app.common.comic.ComicColumn
import com.example.animemoi_app.data.ComicData
import com.example.animemoi_app.data.ComicRepo
import com.example.animemoi_app.model.ComicTest

@Composable
fun GridHistoryCard(
    showStatus: Boolean,
    showLastTimeUpdate: Boolean,
    selectedComic: (Int) -> Unit
    ) {
    val scrollState = rememberLazyGridState()
    val context = LocalContext.current
    val comics: List<ComicTest> = ComicRepo.getComicsList(context)
    LazyVerticalGrid(
        columns = GridCells.Fixed(1), verticalArrangement = Arrangement.spacedBy(20.dp),
        //horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 20.dp),
        state = scrollState
    ) {
        items(comics) { comic ->
            ComicColumn(
                comic, showStatus, showLastTimeUpdate, selectedComic = selectedComic
            )
        }
    }
}

@Preview
@Composable
fun HistoryCardPreview() {
   // GridHistoryCard(showStatus = true, showLastTimeUpdate = false)
}
