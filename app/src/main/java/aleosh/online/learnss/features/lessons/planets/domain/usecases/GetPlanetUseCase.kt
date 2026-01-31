package aleosh.online.learnss.features.lessons.planets.domain.usecases

import aleosh.online.learnss.features.lessons.planets.domain.entities.Planet
import aleosh.online.learnss.features.lessons.planets.domain.entities.PlanetParams
import aleosh.online.learnss.features.lessons.planets.domain.repositories.PlanetRepository

class GetPlanetUseCase (
    private val repository: PlanetRepository,
) {
    suspend operator fun invoke(params: PlanetParams): Result<List<Planet>> {
        return try {
            val planet = repository.getPlanet(params)
            Result.success(planet)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}