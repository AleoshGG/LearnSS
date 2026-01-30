package aleosh.online.learnss.features.lessons.solarSystem.di

import aleosh.online.learnss.core.di.AppContainer
import aleosh.online.learnss.features.lessons.solarSystem.domain.usecases.GetDailyImageUseCase
import aleosh.online.learnss.features.lessons.solarSystem.domain.usecases.GetPlanetDataUseCase
import aleosh.online.learnss.features.lessons.solarSystem.ui.viewModels.SolarSystemViewModelFactory

class SolarSystemModule (
    private val appContainer: AppContainer
) {

    private fun providerGetDailyImageUseCase(): GetDailyImageUseCase {
        return GetDailyImageUseCase(appContainer.dailyImageRepository)
    }

    private fun providerGetPlanetDataUseCase(): GetPlanetDataUseCase {
        return GetPlanetDataUseCase(appContainer.planetDataRepository)
    }

    fun provideSolarSystemViewModelFactory(): SolarSystemViewModelFactory {
        return SolarSystemViewModelFactory(providerGetDailyImageUseCase(), providerGetPlanetDataUseCase())
    }
}