package aleosh.online.learnss.features.lessons.planets.data.datasource.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlanetDto(
    val collection: NasaCollection
)

@Serializable
data class NasaCollection(
    val version: String,
    val href: String,
    val items: List<NasaItem>,
    val metadata: NasaMetadata? = null,
    val links: List<NasaCollectionLink>? = null
)

@Serializable
data class NasaItem(
    val href: String,
    val data: List<NasaData>,
    val links: List<NasaLink>? = null
)

@Serializable
data class NasaData(
    val center: String? = null,
    val title: String? = null,

    @SerialName("nasa_id")
    val nasaId: String? = null,

    @SerialName("date_created")
    val dateCreated: String? = null,

    val keywords: List<String>? = null,

    @SerialName("media_type")
    val mediaType: String? = null,

    val description: String? = null,

    @SerialName("description_508")
    val description508: String? = null,

    @SerialName("secondary_creator")
    val secondaryCreator: String? = null,

    val photographer: String? = null,
    val location: String? = null
)

@Serializable
data class NasaLink(
    val href: String,
    val rel: String,
    val render: String? = null
)

@Serializable
data class NasaMetadata(
    @SerialName("total_hits")
    val totalHits: Int
)

@Serializable
data class NasaCollectionLink(
    val rel: String,
    val prompt: String,
    val href: String
)