package com.example.animemoi_app.common.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.animemoi_app.common.ButtonCommon
import com.example.animemoi_app.screen.CategoryScreen
import com.example.animemoi_app.screen.HistoryScreen
import com.example.animemoi_app.screen.HomeeScreen
import com.example.animemoi_app.screen.SearchScreen
import com.example.animemoi_app.screen.SettingScreen
import com.example.animemoi_app.screen.*


@Composable
fun AppNavigation() {
    val navController : NavHostController = rememberNavController()
    Scaffold (
        bottomBar = {
            NavigationBar (
                containerColor = Color.Black,
                modifier = Modifier
                    .background(Color.Black)
                    .graphicsLayer {
                        shape = RoundedCornerShape(
                            topEnd = 10.dp,
                            topStart = 10.dp
                        )
                        clip = true
                    }

            ){
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                listOfNavItem.forEach{navItem ->
                    NavigationBarItem(
                            selected = currentDestination?.hierarchy?.any{it.route == navItem.route} == true,
                            onClick = {
                                      navController.navigate(navItem.route){
                                          popUpTo(navController.graph.findStartDestination().id){
                                              saveState = true
                                          }
                                          launchSingleTop = true
                                          restoreState = true

                                      }
                            },
                            icon = {
                                Icon(
                                    imageVector = navItem.icon,
                                    contentDescription = null,
                                     modifier = Modifier
                                        .padding(2.dp)
                                         .size(30.dp)// Thêm padding cho biểu tượng

                                )},
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFFFF6666),
                            unselectedIconColor = Color.White,
                            indicatorColor = Color.Transparent
                        )
                        )
                }
            }
        }
    }) { paddingValues: PaddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.HomeScreen.name,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = Screens.HomeScreen.name) {
                HomeScreen(navController)
            }
            composable(route = Screens.SearchScreen.name) {
                SearchScreen(navController)
            }
            composable(route = Screens.HistoryScreen.name) {
                HistoryScreen()
            }
            composable(route = Screens.SettingScreen.name) {
                SettingScreen()
            }
            composable(route = Screens.CategoryScreen.name) {
                CategoryScreen()
            }
            composable(route = Screens.NotificationScreen.name) {
                NotificationScreen(navController)
            }
        }
    }
}@Preview
@Composable
fun AppNavigationPreview() {
    AppNavigation()
}




