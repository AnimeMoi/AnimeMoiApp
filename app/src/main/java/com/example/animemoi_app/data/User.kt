package com.example.animemoi_app.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.animemoi_app.R
import com.example.animemoi_app.model.UserData

class User {
    @Composable
    fun loadUser(): List<UserData> {
        return listOf(
            UserData(
                1,
                "Kha090403@gmail.com",
                "Tuấn Kha",
                "TuanKha",
                painterResource(id = R.drawable.deba)
            ),
            UserData(
                2,
                "Hoang@gmail.com",
                "Wibu",
                "VanHoang",
                painterResource(id = R.drawable.deba)
            ),
            UserData(
                3,
                "Vule5@gmail.com",
                "Tuấn Vũ",
                "TuanVu",
                painterResource(id = R.drawable.deba)
            )
        )
    }
}

