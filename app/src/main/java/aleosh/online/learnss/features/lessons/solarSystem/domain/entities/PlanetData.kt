package aleosh.online.learnss.features.lessons.solarSystem.domain.entities

import aleosh.online.learnss.features.lessons.planets.domain.entities.PlanetParams

data class PlanetData(
    val name: String,
    val description: String,
    val imageRes: String,
    val planetParams: PlanetParams
)