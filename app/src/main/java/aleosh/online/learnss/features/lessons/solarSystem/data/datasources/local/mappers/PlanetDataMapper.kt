package aleosh.online.learnss.features.lessons.solarSystem.data.datasources.local.mappers

import aleosh.online.learnss.features.lessons.solarSystem.data.datasources.local.dtos.PlanetDataDto
import aleosh.online.learnss.features.lessons.solarSystem.domain.entities.PlanetData

fun PlanetDataDto.toDomain(): PlanetData {
    return PlanetData(
        name = this.name,
        description = this.description,
        imageRes = this.imageRes
    )
}