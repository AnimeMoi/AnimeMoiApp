package com.example.animemoi_app.data

import com.example.animemoi_app.R
import com.example.animemoi_app.model.Category
import com.example.animemoi_app.model.ComicDetail

class ComicDetailData {
    fun loadComicDetail() : List<ComicDetail>{
        return listOf<ComicDetail>(
           ComicDetail(R.drawable.img002),
           ComicDetail(R.drawable.img003),
           ComicDetail(R.drawable.img004),
           ComicDetail(R.drawable.img005),
           ComicDetail(R.drawable.img006),
           ComicDetail(R.drawable.img007),
        )
    }
}