package aleosh.online.learnss.core.network

import aleosh.online.learnss.features.lessons.planets.data.datasource.remote.dtos.PlanetDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaImagesApi {
    @GET("search")
    suspend fun getImages(
        @Query("q") query: String,
        @Query("page") page: String,
        @Query("media_type") mediaType: String = "image",
        @Query("year_start") yearStart: String,
        @Query("year_end") yearEnd: String,
    ) : PlanetDto
}