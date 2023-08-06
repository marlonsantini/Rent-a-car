package fingerfire.com.aluguecarro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fingerfire.com.aluguecarro.screens.DetailScreen
import fingerfire.com.aluguecarro.screens.HomeScreen
import fingerfire.com.aluguecarro.screens.StartScreen


@Composable
fun MainNavigation() {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = SPLASH_SCREEN ){
        composable(SPLASH_SCREEN){
            StartScreen(navHostController)
        }
        composable(HOME_SCREEN){
            HomeScreen(navHostController)
        }
        composable(DETAIL_SCREEN){
            DetailScreen(navHostController)
        }
    }

}

const val SPLASH_SCREEN = "splash_screen"
const val HOME_SCREEN = "home_screen"
const val DETAIL_SCREEN = "detail_screen"