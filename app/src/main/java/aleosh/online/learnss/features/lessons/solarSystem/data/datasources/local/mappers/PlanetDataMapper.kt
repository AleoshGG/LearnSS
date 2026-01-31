package aleosh.online.learnss.features.lessons.solarSystem.data.datasources.local.mappers

import aleosh.online.learnss.features.lessons.planets.domain.entities.PlanetParams
import aleosh.online.learnss.features.lessons.solarSystem.data.datasources.local.dtos.PlanetDataDto
import aleosh.online.learnss.features.lessons.solarSystem.data.datasources.local.dtos.PlanetParamsDto
import aleosh.online.learnss.features.lessons.solarSystem.domain.entities.PlanetData

fun PlanetDataDto.toDomain(): PlanetData {
    return PlanetData(
        name = this.name,
        description = this.description,
        imageRes = this.imageRes,
        planetParams = this.planet_params.toDomain()
    )
}

fun PlanetParamsDto.toDomain(): PlanetParams {
    return PlanetParams(
        q = this.q,
        page = this.page,
        media_type = this.media_type,
        year_start = this.year_start,
        year_end = this.year_end,
    )
}