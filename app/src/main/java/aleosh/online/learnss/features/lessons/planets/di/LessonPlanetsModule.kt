package aleosh.online.learnss.features.lessons.planets.di

import aleosh.online.learnss.core.di.AppContainer
import aleosh.online.learnss.features.lessons.planets.domain.usecases.GetPlanetUseCase
import aleosh.online.learnss.features.lessons.planets.ui.viewModels.PlanetViewModelFactory

class LessonPlanetsModule (
    private val appContainer: AppContainer
) {

    private fun providerGetPlanetUseCase(): GetPlanetUseCase {
        return GetPlanetUseCase(appContainer.planetImagesRepository)
    }

    fun provideLessonPlanetViewModelFactory(): PlanetViewModelFactory {
        return PlanetViewModelFactory(providerGetPlanetUseCase())
    }

}