package com.example.animemoi_app.common.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector


data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val listOfNavItem : List<NavItem> = listOf(
     NavItem(
         label = "Home",
         icon = Icons.Default.Home,
         route = Screens.HomeeScreen.name
     ),
    NavItem(
        label = "Category",
        icon = Icons.Default.AccountBox,
        route = Screens.CategoryScreen.name
),
    NavItem(
        label = "Search",
        icon = Icons.Default.Search,
        route = Screens.SearchScreen.name
    ),
    NavItem(
        label = "History",
        icon = Icons.Default.Refresh,
        route = Screens.HistoryScreen.name
    ),
    NavItem(
        label = "Settings",
        icon = Icons.Default.Settings,
        route = Screens.SettingScreen.name
    ),

)


