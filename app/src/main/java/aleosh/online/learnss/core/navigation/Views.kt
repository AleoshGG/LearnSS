package aleosh.online.learnss.core.navigation

import kotlinx.serialization.Serializable

sealed class Screen {

    @Serializable
    object Home

    @Serializable
    object LessonSolarSystem

    @Serializable
    object LessonPlanets
}