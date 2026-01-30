package aleosh.online.learnss.features.lessons.solarSystem.domain.repositories

import aleosh.online.learnss.features.lessons.solarSystem.domain.entities.PlanetData

interface PlanetDataRepository {
    suspend fun getPlanetData(): List<PlanetData>
}