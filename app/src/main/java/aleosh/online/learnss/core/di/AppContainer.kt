package aleosh.online.learnss.core.di

import aleosh.online.learnss.core.network.NasaGOVApi
import aleosh.online.learnss.core.network.NasaImagesApi
import aleosh.online.learnss.features.lessons.planets.data.repositories.PlanetRepositoryImpl
import aleosh.online.learnss.features.lessons.planets.domain.repositories.PlanetRepository
import aleosh.online.learnss.features.lessons.solarSystem.data.repositories.DailyImageRepositoryImpl
import aleosh.online.learnss.features.lessons.solarSystem.data.repositories.PlanetDataRepositoryImpl
import aleosh.online.learnss.features.lessons.solarSystem.domain.repositories.DailyImageRepository
import aleosh.online.learnss.features.lessons.solarSystem.domain.repositories.PlanetDataRepository
import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer (context: Context) {

    private val NasaGOVApiRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.nasa.gov/planetary/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val nasaGOVApi: NasaGOVApi by lazy {
        NasaGOVApiRetrofit.create(NasaGOVApi::class.java)
    }

    private val NasaImagesApiRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://images-api.nasa.gov/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val nasaImagesApi: NasaImagesApi by lazy {
        NasaImagesApiRetrofit.create(NasaImagesApi::class.java)
    }

    val dailyImageRepository: DailyImageRepository by lazy {
        DailyImageRepositoryImpl(nasaGOVApi)
    }

    val planetDataRepository: PlanetDataRepository by lazy {
        PlanetDataRepositoryImpl(context)
    }

    val planetImagesRepository: PlanetRepository by lazy {
        PlanetRepositoryImpl(nasaImagesApi)
    }

}