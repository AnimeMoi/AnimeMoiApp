package com.example.animemoi_app.model
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Comic(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val categoryResourceId: Int,
    @StringRes val statusComic: Int,
    @StringRes val statusChapter: Int
)
