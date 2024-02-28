package com.example.animemoi_app.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ComicTest(
    val comicId : Int,
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val categoryResourceId: Int,
    @StringRes val status: Int,
    val lastChapter: String,
    val timeUpdate: String?
)