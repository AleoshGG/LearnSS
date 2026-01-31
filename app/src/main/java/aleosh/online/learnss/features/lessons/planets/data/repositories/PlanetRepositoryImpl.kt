package aleosh.online.learnss.features.lessons.planets.data.repositories

import aleosh.online.learnss.core.network.NasaImagesApi
import aleosh.online.learnss.features.lessons.planets.data.datasource.remote.mappers.toDomain
import aleosh.online.learnss.features.lessons.planets.domain.entities.Planet
import aleosh.online.learnss.features.lessons.planets.domain.entities.PlanetParams
import aleosh.online.learnss.features.lessons.planets.domain.repositories.PlanetRepository

class PlanetRepositoryImpl (
    private val api: NasaImagesApi
) : PlanetRepository {


    override suspend fun getPlanet(params: PlanetParams): List<Planet> {
        val response = api.getImages(
            query = params.q,
            page = params.page,
            mediaType = params.media_type,
            yearStart = params.year_start,
            yearEnd = params.year_end
        )
        return response.toDomain()


    }
}