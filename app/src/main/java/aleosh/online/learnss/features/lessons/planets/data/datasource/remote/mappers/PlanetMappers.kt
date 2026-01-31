package aleosh.online.learnss.features.lessons.planets.data.datasource.remote.mappers

import aleosh.online.learnss.features.lessons.planets.data.datasource.remote.dtos.SearchResponse
import aleosh.online.learnss.features.lessons.planets.domain.entities.Planet

// Ahora devuelve una LISTA de Planetas
fun SearchResponse.toDomain(): List<Planet> {
    return this.collection.items.map { item ->

        // Extraemos la data de CADA item individualmente
        val assetData = item.data.firstOrNull()

        // Buscamos la imagen en los links de ESE item
        val imageLink = item.links.firstOrNull { it.rel == "preview" }
            ?: item.links.firstOrNull()

        Planet(
            title = assetData?.title ?: "Sin título",
            description = assetData?.description ?: "Sin descripción disponible.",
            // Corregimos http a https para evitar errores en Android
            imagesUrl = imageLink?.href?.replace("http://", "https://") ?: ""
        )
    }
}