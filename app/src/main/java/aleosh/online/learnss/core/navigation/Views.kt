package aleosh.online.learnss.core.navigation

import aleosh.online.learnss.features.lessons.planets.domain.entities.PlanetParams
import kotlinx.serialization.Serializable

sealed class Screen {

    @Serializable
    object Home

    @Serializable
    object LessonSolarSystem

    @Serializable
    data class LessonPlanets(val params: PlanetParams) : Screen()
}