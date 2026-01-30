package aleosh.online.learnss.core.navigation

import aleosh.online.learnss.features.home.views.HomeView
import aleosh.online.learnss.features.lessons.solarSystem.ui.views.SolarSystemView
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home
    ) {
        composable<Screen.Home> {
            HomeView {
                navController.navigate(Screen.LessonSolarSystem)
            }
        }

        composable<Screen.LessonSolarSystem> {
            SolarSystemView()
        }
    }

}