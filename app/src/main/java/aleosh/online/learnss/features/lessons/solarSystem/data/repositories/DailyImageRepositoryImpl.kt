package aleosh.online.learnss.features.lessons.solarSystem.data.repositories

import aleosh.online.learnss.core.network.NasaGOVApi
import aleosh.online.learnss.features.lessons.solarSystem.data.datasources.remote.mappers.toDomain
import aleosh.online.learnss.features.lessons.solarSystem.domain.entities.DailyImage
import aleosh.online.learnss.features.lessons.solarSystem.domain.repositories.DailyImageRepository

class DailyImageRepositoryImpl (
    private val api: NasaGOVApi
) : DailyImageRepository {

    override suspend fun getDailyImage(): DailyImage {
        val response = api.getDailyImage()
        return response.toDomain()
    }
}