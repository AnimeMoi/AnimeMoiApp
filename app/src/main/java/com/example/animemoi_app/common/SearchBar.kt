package com.example.animemoi_app.common

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@ExperimentalMaterial3Api
@Composable
fun searchBar() {
    //This is the text users enter
    var queryString by remember {
        mutableStateOf("")
    }
    //if the search bar is active or not
    var isActive by remember {
        mutableStateOf(false)
    }

    val contextForToast = LocalContext.current.applicationContext
    //previous search terms
    val historyItems = remember {
        mutableStateListOf("SemicolonSpace","Jetpack Compose","Android")
    }
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp)
                .background(Color.Black)
                .border(0.5.dp, if(isActive) Color.Transparent else Color.White, RoundedCornerShape(50))
                ,
            query = queryString,
            onQueryChange = { newQueryString ->
                queryString = newQueryString
            },
            onSearch = {
                isActive = false
                Toast.makeText(contextForToast, "Bạn đã tìm: $queryString", Toast.LENGTH_SHORT)
                    .show()
                historyItems.add(queryString)

            },
            active = isActive,
            onActiveChange = { activeChange ->
                isActive = activeChange
            },
            placeholder = {
                Text(text = "Tìm kiếm...", color = Color.White)
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = Color.White)
            },
            trailingIcon = {
                if (isActive) {
                    Icon(
                        modifier = Modifier.clickable {
                            if (queryString.isNotEmpty()) {
                                queryString = ""
                            } else {
                                isActive = false
                            }
                        },
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Icon"
                    )
                }
            },
            colors = SearchBarDefaults.colors(
                Color.Black, Color(0xFFFF6666), TextFieldDefaults.colors(Color.White)
            ),
            tonalElevation = 500.dp
            ,
            content = {
                    //this is a column scope
                    //all the items are displayed vertically
                    historyItems.forEach{ historyItem ->
                        Row (modifier = Modifier.padding(all = 16.dp)){
                            Icon(
                                modifier = Modifier.padding(end = 12.dp),
                                imageVector = Icons.Default.Refresh, contentDescription = null,
                                tint = Color.White
                            )
                            Text(text = historyItem, color = Color.White)
                        }
                    }
            }

        )
       



}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SearchBarPreview() {
    searchBar()
}