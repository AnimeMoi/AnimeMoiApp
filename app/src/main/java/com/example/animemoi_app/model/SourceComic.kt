package com.example.animemoi_app.model

import androidx.annotation.DrawableRes
import com.example.animemoi_app.R

data class SourceComic(
    @DrawableRes val icon: Int = R.drawable.hentaivn,
    val name: String,
    val label: String,
    val nsfw: Boolean
)
