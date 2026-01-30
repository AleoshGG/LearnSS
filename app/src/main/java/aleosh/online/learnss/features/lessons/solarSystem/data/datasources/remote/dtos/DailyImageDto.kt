package aleosh.online.learnss.features.lessons.solarSystem.data.datasources.remote.dtos

data class DailyImageDto(
    val copyright: String? = null,
    val date: String,
    val explanation: String,
    val hdurl: String? = null,
    val mediaType: String,
    val serviceVersion: String,
    val title: String,
    val url: String
)
