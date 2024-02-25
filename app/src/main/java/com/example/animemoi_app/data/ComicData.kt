package com.example.animemoi_app.data

import com.example.animemoi_app.R
import com.example.animemoi_app.model.Comic

class ComicData {
    fun loadComicCard(): List<Comic> {
        return listOf(
            Comic(
                R.string.cm01,
                R.drawable.huongdanchamsoctieuzombie,
                R.string.trtr,
                R.string.st01,
                "234",
                "22:00 12/1/2024"
            ),
            Comic(
                R.string.cm02, R.drawable.thancaodanton606028, R.string.tth, R.string.st01, "214", "22:00 12/1/2024"
            ),
            Comic(
                R.string.cm03, R.drawable.linhvuthienha, R.string.thieunhi, R.string.st02, "2123", "22:00 12/1/2024"
            ),
            Comic(
                R.string.cm04,
                R.drawable.truyendauphathuongkhung,
                R.string.trtr,
                R.string.st02,
                "234",
                "22:00 12/1/2024"
            ),
            Comic(
                R.string.cm05,
                R.drawable.mevokhongloive982891,
                R.string.thieunhi,
                R.string.st02,
                "234",
                "22:00 12/1/2024"
            ),
            Comic(
                R.string.cm06, R.drawable.thegioihoanmy, R.string.trtr, R.string.st01, "234", "22:00 12/1/2024"
            ),
            Comic(
                R.string.cm07, R.drawable.phamnhantutien, R.string.thieunhi, R.string.st01, "234", "22:00 12/1/2024"
            ),
            Comic(
                R.string.cm08, R.drawable.tiennghich, R.string.trtr, R.string.st01, "234", "22:00 12/1/2024"
            ),
            Comic(
                R.string.cm09, R.drawable.deba, R.string.thieunhi, R.string.st03, "234", "22:00 12/1/2024"
            ),
            Comic(
                R.string.cm10, R.drawable.tiennghich, R.string.thieunhi, R.string.st03, "234", "22:00 12/1/2024"
            ),
            Comic(
                R.string.cm11, R.drawable.requytroicho480197, R.string.trtr, R.string.st03, "234", "22:00 12/1/2024"
            ),
        )
    }
}