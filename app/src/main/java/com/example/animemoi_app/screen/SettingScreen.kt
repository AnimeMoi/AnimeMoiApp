package com.example.animemoi_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.animemoi_app.R
import com.example.animemoi_app.common.ComeBack
import com.example.animemoi_app.data.User
import com.example.animemoi_app.model.UserData
import com.example.animemoi_app.screen.setting.LoginRegisterFrame
import com.example.animemoi_app.screen.setting.PersonalInformation
import com.example.animemoi_app.screen.setting.SettingAppFrame
import com.example.animemoi_app.screen.setting.SettingSourceFrame

@Composable
fun SettingScreen(navController: NavHostController) {
    var loggedIn by remember{ mutableStateOf(false)}
    Column(
        modifier = Modifier.background(Color.Black)
    ) {
        ComeBack(title = "Cài đặt", navController)
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            if(loggedIn)
                PersonalInformation(
                    user = User().loadUser()[1]
                )
            else LoginRegisterFrame(navController)
            SettingSourceFrame(navController)
            SettingAppFrame()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SettingScreenPreview() {
    SettingScreen(navController = rememberNavController())
}

