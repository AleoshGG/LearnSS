package aleosh.online.learnss.features.lessons.solarSystem.data.datasources.local.dtos

import kotlinx.serialization.Serializable

@Serializable
data class PlanetDataDto(
    val name: String,
    val description: String,
    val imageRes: String,
    val planet_params: PlanetParamsDto
)

@Serializable
data class PlanetParamsDto(
    val q: String,
    val page: String,
    val media_type: String,
    val year_start: String,
    val year_end: String,
)