package aleosh.online.learnss.features.lessons.solarSystem.data.datasources.remote.mappers

import aleosh.online.learnss.features.lessons.solarSystem.data.datasources.remote.dtos.DailyImageDto
import aleosh.online.learnss.features.lessons.solarSystem.domain.entities.DailyImage

fun DailyImageDto.toDomain(): DailyImage {
    return DailyImage(
        date = this.date,
        imgSource = this.url
    )
}