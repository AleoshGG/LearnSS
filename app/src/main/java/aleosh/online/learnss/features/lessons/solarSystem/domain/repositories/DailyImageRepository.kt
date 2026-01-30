package aleosh.online.learnss.features.lessons.solarSystem.domain.repositories

import aleosh.online.learnss.features.lessons.solarSystem.domain.entities.DailyImage

interface DailyImageRepository {
    suspend fun getDailyImage(): DailyImage
}