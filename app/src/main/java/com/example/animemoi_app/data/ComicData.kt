package com.example.animemoi_app.data

import com.example.animemoi_app.R
import com.example.animemoi_app.model.Comic

class ComicData {
    fun loadComicCard():List<Comic>{
        return listOf<Comic>(
            Comic(R.string.cm01, R.drawable.huongdanchamsoctieuzombie),
            Comic(R.string.cm02, R.drawable.thancaodanton606028),
            Comic(R.string.cm03, R.drawable.linhvuthienha),
            Comic(R.string.cm04, R.drawable.truyendauphathuongkhung),
            Comic(R.string.cm05, R.drawable.mevokhongloive982891),
            Comic(R.string.cm06, R.drawable.thegioihoanmy),
            Comic(R.string.cm07, R.drawable.phamnhantutien),
            Comic(R.string.cm08, R.drawable.tiennghich),
            Comic(R.string.cm09, R.drawable.deba),
            Comic(R.string.cm10, R.drawable.tiennghich),
            Comic(R.string.cm11, R.drawable.requytroicho480197),
        )
    }
}