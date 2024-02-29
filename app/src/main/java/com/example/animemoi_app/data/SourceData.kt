package com.example.animemoi_app.data

import com.example.animemoi_app.R
import com.example.animemoi_app.model.SourceComic

class SourceData {
    fun loadSourceData(): List<SourceComic> {
        return listOf(
            SourceComic(
                icon = R.drawable.nettruyen, name = "NetTruyen", label = "nettruyen", nsfw = false
            ), SourceComic(
                name = "Bảo Tàng Truyện", label = "BaoTangTruyen", nsfw = false
            ), SourceComic(
                icon = R.drawable.hentaivn, name = "HentaiVn", label = "HentaiVn", nsfw = true
            ), SourceComic(
                name = "Lxmanga", label = "Lxmanga", nsfw = true
            ), SourceComic(
                icon = R.drawable.sayhentai, name = "SayHentai", label = "SayHentai", nsfw = true
            ), SourceComic(
                name = "YuriNeko", label = "YuriNeko", nsfw = false
            )
        )
    }
}