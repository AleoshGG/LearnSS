package aleosh.online.learnss.features.lessons.solarSystem.data.datasources.local.dtos

import kotlinx.serialization.Serializable

@Serializable
data class PlanetDataDto(
    val name: String,
    val description: String,
    val imageRes: String,
)
