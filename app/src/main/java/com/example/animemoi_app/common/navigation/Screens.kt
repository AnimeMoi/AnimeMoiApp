package com.example.animemoi_app.common.navigation

enum class Screens {
    HomeScreen,
    HistoryScreen,
    SearchScreen,
    SettingScreen,
    CategoryScreen,
    NotificationScreen,
    DetailComicScreen,
    MoreComicScreen,
    LoginScreen,
    RegisterScreen,
    ReadingScreen,
    CommentScreen,
    SourceComicScreen,
}

// Define the routes where you want the NavigationBar to be visible
val listOfRoutesToShowNavBar = listOf(
    Screens.HomeScreen.name,
    Screens.SearchScreen.name,
    Screens.HistoryScreen.name,
    Screens.SettingScreen.name,
    Screens.NotificationScreen.name,
    Screens.CategoryScreen.name
)