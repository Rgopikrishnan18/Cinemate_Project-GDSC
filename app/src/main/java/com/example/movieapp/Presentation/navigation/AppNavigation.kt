package com.example.movieapp.Presentation.navigation

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.Presentation.detailsscreen.components.DetailScreen
import com.example.movieapp.Presentation.search_screen.Components.SearchScreen

@Composable
fun AppNavigation(){
    val navController= rememberNavController()
    
    NavHost(navController = navController, startDestination = Screen.SearchScreen.name){
        composable(route=Screen.SearchScreen.name){
            SearchScreen(onItemClick = {title -> navController.navigate(route="${Screen.DetailScreen.name}/$title")})
        }
        composable(route="${Screen.DetailScreen.name}/{title}",
            arguments = listOf(navArgument("title"){
                type= NavType.StringType

            }
            ),
            enterTransition = {
                slideInHorizontally (
                    initialOffsetX = {-it},
                    animationSpec = tween(
                        300,
                        easing = FastOutLinearInEasing
                    )
                )
            },
            exitTransition = { slideOutHorizontally (
                targetOffsetX = {-it},
                animationSpec = tween(
                    300,
                    easing = FastOutLinearInEasing
                )
            ) }
        ){
            navBackStackEntry -> navBackStackEntry.arguments?.getString("title").let { title ->
                DetailScreen(title = title!!)
        }

        }
    }
}