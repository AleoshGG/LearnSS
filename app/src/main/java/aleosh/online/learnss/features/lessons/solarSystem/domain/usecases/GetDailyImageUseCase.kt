package aleosh.online.learnss.features.lessons.solarSystem.domain.usecases

import aleosh.online.learnss.features.lessons.solarSystem.domain.entities.DailyImage
import aleosh.online.learnss.features.lessons.solarSystem.domain.repositories.DailyImageRepository

class GetDailyImageUseCase (
    private val repository: DailyImageRepository
) {
    suspend operator fun invoke(): Result<DailyImage> {
        return try {
            val dailyImage = repository.getDailyImage()
            Result.success(dailyImage)
        }
        catch (e: Exception) {
            Result.failure(e)
        }
    }
}