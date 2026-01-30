package aleosh.online.learnss.core.network

import aleosh.online.learnss.BuildConfig
import aleosh.online.learnss.features.lessons.solarSystem.data.datasources.remote.dtos.DailyImageDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaGOVApi {
    @GET("apod")
    suspend fun getDailyImage(
        @Query("api_key") apiKey: String = BuildConfig.NASA_API_KEY
    ): DailyImageDto
}