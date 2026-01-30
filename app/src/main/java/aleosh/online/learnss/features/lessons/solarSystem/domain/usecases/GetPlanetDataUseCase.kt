package aleosh.online.learnss.features.lessons.solarSystem.domain.usecases

import aleosh.online.learnss.features.lessons.solarSystem.domain.entities.PlanetData
import aleosh.online.learnss.features.lessons.solarSystem.domain.repositories.PlanetDataRepository

class GetPlanetDataUseCase (
    private val repository: PlanetDataRepository
) {

    suspend operator fun invoke(): Result<List<PlanetData>> {
        return try {
            val planets = repository.getPlanetData()
            Result.success(planets)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}