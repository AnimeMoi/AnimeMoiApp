package com.example.animemoi_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.animemoi_app.R
import com.example.animemoi_app.common.ComeBack
import com.example.animemoi_app.screen.setting.LoginRegisterFrame
import com.example.animemoi_app.screen.setting.PersonalInformation
import com.example.animemoi_app.screen.setting.SettingAppFrame
import com.example.animemoi_app.screen.setting.SettingSourceFrame

@Composable
fun SettingScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ComeBack(title = "Cài đặt", navController)
        Column {
           /* PersonalInformation(
                user = UserData(
                    image = painterResource(id = R.drawable.deba),
                    name = "Tuấn Kha",
                    password = "TuanKha"
                )
            )
            LoginRegisterFrame()
            SettingSourceFrame()*/
            SettingAppFrame()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SettingScreenPreview() {
    SettingScreen(navController = rememberNavController())
}

data class UserData(val image: Painter, var name: String, var password: String)
data class SourceData(val image: Painter, var name: String)
