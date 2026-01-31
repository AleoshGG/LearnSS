package aleosh.online.learnss.features.lessons.planets.domain.repositories

import aleosh.online.learnss.features.lessons.planets.domain.entities.Planet
import aleosh.online.learnss.features.lessons.planets.domain.entities.PlanetParams

interface PlanetRepository {
    suspend fun getPlanet(params: PlanetParams): Planet
}