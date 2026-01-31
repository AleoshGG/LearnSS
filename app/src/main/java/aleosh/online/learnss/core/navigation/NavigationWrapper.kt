package aleosh.online.learnss.core.navigation

import aleosh.online.learnss.core.di.AppContainer
import aleosh.online.learnss.features.home.views.HomeView
import aleosh.online.learnss.features.lessons.planets.di.LessonPlanetsModule
import aleosh.online.learnss.features.lessons.planets.domain.entities.PlanetParams
import aleosh.online.learnss.features.lessons.planets.domain.entities.PlanetParamsType
import aleosh.online.learnss.features.lessons.planets.ui.views.PlanetView
import aleosh.online.learnss.features.lessons.solarSystem.di.SolarSystemModule
import aleosh.online.learnss.features.lessons.solarSystem.ui.views.SolarSystemView
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper(appContainer: AppContainer) {

    val lessonSolarSystemModule = SolarSystemModule(appContainer)
    val lessonPlanetsModule = LessonPlanetsModule(appContainer)

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
            SolarSystemView(
                factory = lessonSolarSystemModule.provideSolarSystemViewModelFactory(),
                navigateTo = { selectPlanet ->
                    navController.navigate(Screen.LessonPlanets(params = selectPlanet))
                }
            )
        }

        composable<Screen.LessonPlanets>(
            // AQUI ESTÁ LA CLAVE: Le pasamos el mapa de tipos manual
            typeMap = mapOf(typeOf<PlanetParams>() to PlanetParamsType)
        ) { backStackEntry ->

            // Ahora sí funcionará el toRoute
            val args = backStackEntry.toRoute<Screen.LessonPlanets>()

            PlanetView(
                factory = lessonPlanetsModule.provideLessonPlanetViewModelFactory(),
                planetParams = args.params
            )
        }
    }

}