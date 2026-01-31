package aleosh.online.learnss.features.lessons.planets.data.datasource.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    val collection: SearchCollection
)

@Serializable
data class SearchCollection(
    val items: List<SearchItem> = emptyList()
)

@Serializable
data class SearchItem(
    val data: List<AssetData> = emptyList(),
    val links: List<AssetLink> = emptyList()
)

// Estas dos clases (AssetData y AssetLink) se quedan igual que las tenías
@Serializable
data class AssetData(
    val description: String? = null,
    val title: String? = null
)

@Serializable
data class AssetLink(
    val href: String,
    val rel: String
)