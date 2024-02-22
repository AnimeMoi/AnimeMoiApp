package com.example.animemoi_app.data

import com.example.animemoi_app.R
import com.example.animemoi_app.model.Category
import com.example.animemoi_app.model.Comic

class CategoryData {
    fun loadCategory() : List<Category>{
        return listOf<Category>(
            Category(R.string.thieunhi),
            Category(R.string.anime),
            Category(R.string.trtr),
            Category(R.string.tth),
        )
    }
}