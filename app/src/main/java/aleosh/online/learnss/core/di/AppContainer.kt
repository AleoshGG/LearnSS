package aleosh.online.learnss.core.di

import aleosh.online.learnss.core.network.NasaGOVApi
import aleosh.online.learnss.features.lessons.solarSystem.data.repositories.DailyImageRepositoryImpl
import aleosh.online.learnss.features.lessons.solarSystem.domain.repositories.DailyImageRepository
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

    val dailyImageRepository: DailyImageRepository by lazy {
        DailyImageRepositoryImpl(nasaGOVApi)
    }

}