package com.example.animemoi_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.animemoi_app.common.navigation.AppNavigation
import com.example.animemoi_app.screen.CategoryScreen
import com.example.animemoi_app.ui.theme.AnimeMoi_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeMoi_AppTheme {
                AppNavigation()
            }
        }
    }
}

