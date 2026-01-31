package aleosh.online.learnss.features.lessons.planets.data.datasource.remote.mappers

import aleosh.online.learnss.features.lessons.planets.data.datasource.remote.dtos.PlanetDto
import aleosh.online.learnss.features.lessons.planets.domain.entities.Planet

fun PlanetDto.toDomain(): Planet {
    return Planet(
        title = this.collection.items[0].data[0].title ?: "No title",
        description = this.collection.items[0].data[0].description ?: "No description",
        imagesUrl = this.collection.items[0].links?.map { it.href } ?: emptyList()
    )
}