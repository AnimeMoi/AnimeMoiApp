package com.example.animemoi_app.model

import androidx.compose.ui.graphics.painter.Painter

data class UserData(val userId: Int, val email:String, var name: String, var password: String, val image: Painter  )

