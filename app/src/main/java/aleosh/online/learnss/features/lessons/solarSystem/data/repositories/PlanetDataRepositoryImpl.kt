package aleosh.online.learnss.features.lessons.solarSystem.data.repositories

import aleosh.online.learnss.R
import aleosh.online.learnss.features.lessons.solarSystem.data.datasources.local.dtos.PlanetDataDto
import aleosh.online.learnss.features.lessons.solarSystem.data.datasources.local.mappers.toDomain
import aleosh.online.learnss.features.lessons.solarSystem.domain.entities.PlanetData
import aleosh.online.learnss.features.lessons.solarSystem.domain.repositories.PlanetDataRepository
import android.content.Context
import kotlinx.serialization.json.Json

class PlanetDataRepositoryImpl (
    private val context: Context
) : PlanetDataRepository {

    override suspend fun getPlanetData(): List<PlanetData> {
        return try {
            val jsonString = context.resources.openRawResource(R.raw.data_lessons)
                .bufferedReader()
                .use { it.readText() }

            val json = Json {ignoreUnknownKeys = true}

            val planetDtos = json.decodeFromString<List<PlanetDataDto>>(jsonString)

            planetDtos.map { dto ->
                dto.toDomain()
            }

        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }

    }

}