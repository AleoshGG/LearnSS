package aleosh.online.learnss.features.lessons.planets.ui.viewModels

import aleosh.online.learnss.features.lessons.planets.domain.usecases.GetPlanetUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PlanetViewModelFactory (
    private val getPlanetUseCase: GetPlanetUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlanetViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PlanetViewModel(getPlanetUseCase) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")

    }
}