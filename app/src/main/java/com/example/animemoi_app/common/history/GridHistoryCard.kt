@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.animemoi_app.common.history

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissState
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animemoi_app.common.comic.ComicColumn
import com.example.animemoi_app.data.ComicRepo
import com.example.animemoi_app.model.ComicTest
import kotlinx.coroutines.delay

@SuppressLint("UnrememberedMutableState")
@Composable
fun GridHistoryCard(
    showStatus: Boolean,
    showLastTimeUpdate: Boolean,
    selectedComic: (Int) -> Unit
) {
    val context = LocalContext.current
    val comics: MutableList<ComicTest> = remember {
        ComicRepo.getComicsList(context).toMutableList()
    }
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        //horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 20.dp),
    ) {
        items(
           items = comics,
            key = {it.comicId}
        ) { comic ->
            SwipeToDeleteContainer(
                item = comic,
                onDelete = {
                    comics -= comic
                }
            ) {
                ComicColumn(
                    comic,
                    showStatus,
                    showLastTimeUpdate,
                    selectedComic
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> SwipeToDeleteContainer(
    item: T,
    onDelete: (T) -> Unit,
    animationDurarion: Int = 500,
    content: @Composable (T) -> Unit
) {
    var isRemove by remember {
        mutableStateOf(false)
    }
    val state = rememberDismissState(
        confirmValueChange = { value ->
            if (value == DismissValue.DismissedToStart) {
                isRemove = true
                true
            } else {
                false
            }
        }
    )

    LaunchedEffect(key1 = isRemove) {
        if (isRemove) {
            delay(animationDurarion.toLong())
            onDelete(item)
        }
    }

    AnimatedVisibility(
        visible = !isRemove,
        exit = shrinkVertically(
            animationSpec = tween(durationMillis = animationDurarion),
            shrinkTowards = Alignment.Top
        ) + fadeOut()
    ) {
        SwipeToDismiss(
            state = state,
            background = {
                DeleteBackGround(swipeDismissState = state)
            },
            dismissContent = {
                content(item)
            },
            directions = setOf(DismissDirection.EndToStart)
        )

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteBackGround(
    swipeDismissState: DismissState
) {
    val color = if (
        swipeDismissState.dismissDirection == DismissDirection.EndToStart
    ) {
        Color.Red
    } else Color.Transparent
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Preview
@Composable
fun HistoryCardPreview() {
    // GridHistoryCard(showStatus = true, showLastTimeUpdate = false)
}
