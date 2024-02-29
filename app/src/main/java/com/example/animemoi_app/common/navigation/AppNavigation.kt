package com.example.animemoi_app.common.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.animemoi_app.common.navigation.AppDestinations.COMIC_DETAIL_ID_KEY
import com.example.animemoi_app.screen.*

private object AppDestinations {
    const val COMIC_DETAIL_ID_KEY = "ComicDetailId"
}

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()
    val actions = remember(navController) { AppActions(navController) }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val shouldShowNavBar = listOfRoutesToShowNavBar.contains(currentDestination?.route)

    Scaffold(bottomBar = {
        if (shouldShowNavBar) {
            NavigationBar(containerColor = Color.Black, modifier = Modifier
                .background(Color.Black)
                .graphicsLayer {
                    shape = RoundedCornerShape(
                        topEnd = 10.dp, topStart = 10.dp
                    )
                    clip = true
                }) {
                listOfNavItem.forEach { navItem ->
                    NavigationBarItem(selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                        onClick = {
                            navController.navigate(navItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
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
                            )
                        },
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
                HomeScreen(navController, selectedComic = actions.selectedComic)
            }
            composable(route = Screens.SearchScreen.name) {
                SearchScreen(navController)
            }
            composable(route = Screens.HistoryScreen.name) {
                HistoryScreen(navController, selectedComic = actions.selectedComic)
            }
            composable(route = Screens.SettingScreen.name) {
                SettingScreen(navController)
            }
            composable(route = Screens.NotificationScreen.name) {
                NotificationScreen(navController, selectedComic = actions.selectedComic)
            }
            composable(route = Screens.CategoryScreen.name) {
                CategoryScreen(navController, selectedComic = actions.selectedComic)
            }
            composable(
                route = "${Screens.DetailComicScreen.name}/{${COMIC_DETAIL_ID_KEY}}",
                arguments = listOf(navArgument(COMIC_DETAIL_ID_KEY) {
                    type = NavType.IntType
                })
            ) { backStackEntry ->
                val arguments = requireNotNull(backStackEntry.arguments)
                DetailScreen(
                    comicId = arguments.getInt(COMIC_DETAIL_ID_KEY), navigateUp = actions.navigateUp, navController
                )
            }
            composable(
                route = "${Screens.MoreComicScreen.name}/{TitleScreen}",
            ) {
                val backStackEntry = navController.currentBackStackEntry

                // Handle potential null case gracefully
                val title = backStackEntry?.arguments?.getString("TitleScreen") ?: ""

                MoreComicScreen(title, navController = navController, selectedComic = actions.selectedComic)
            }
            composable(
                route = Screens.LoginScreen.name
            ) {
                LoginScreen(navController = navController)
            }
            composable(
                route = Screens.RegisterScreen.name
            ) {
                RegisterScreen(navController = navController)
            }
            composable(
                route = "${Screens.ReadingScreen.name}/{TitleComic}",
            ) {
                val backStackEntry = navController.currentBackStackEntry

                // Handle potential null case gracefully
                val title = backStackEntry?.arguments?.getString("TitleComic") ?: ""

                ReadingScreen(navController = navController, title = title)
            }
            composable(
                route = "${Screens.CommentScreen.name}/{TitleComic}",
            ) {
                val backStackEntry = navController.currentBackStackEntry

                // Handle potential null case gracefully
                val title = backStackEntry?.arguments?.getString("TitleComic") ?: ""

                CommentScreen(navController = navController, title = title)
            }
            composable(
                route = Screens.SourceComicScreen.name
            ) {
                SourceComicScreen(navController = navController)
            }
        }
    }
}

private class AppActions(
    navController: NavHostController
) {
    val selectedComic: (Int) -> Unit = { comicId: Int ->
        navController.navigate("${Screens.DetailComicScreen.name}/$comicId")
    }
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}

@Preview
@Composable
fun AppNavigationPreview() {
    AppNavigation()
}

