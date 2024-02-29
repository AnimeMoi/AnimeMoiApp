package com.example.animemoi_app.common.comic

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animemoi_app.data.ComicData

@Composable
fun ComicRow() {
    val listComic = ComicData().loadComicCard()

    LazyRow(
        modifier = Modifier.padding(16.dp)
    ) {
        items(listComic) { comic ->
            Comic(
                name = comic.stringResourceId,
                image = comic.imageResourceId,
                moreInfo = false
            )
        }
    }
}
