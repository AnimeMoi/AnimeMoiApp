package com.example.animemoi_app.common.history

import androidx.compose.foundation.layout.Arrangement
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
fun GridHistoryCard(showStatus: Boolean, showLastTimeUpdate: Boolean) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1), verticalArrangement = Arrangement.spacedBy(20.dp),
        //horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        val comics = ComicData().loadComicCard()
        items(comics) { comic ->
            HistoryCard(
                comic, showStatus, showLastTimeUpdate
            )
        }
    }
}

@Preview
@Composable
fun HistoryCardPreview() {
    GridHistoryCard(showStatus = true, showLastTimeUpdate = false)
}
