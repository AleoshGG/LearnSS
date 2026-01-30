package aleosh.online.learnss.features.lessons.solarSystem.ui.viewModels

import aleosh.online.learnss.features.lessons.solarSystem.domain.usecases.GetDailyImageUseCase
import aleosh.online.learnss.features.lessons.solarSystem.domain.usecases.GetPlanetDataUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SolarSystemViewModelFactory (
    private val getDailyImageUseCase: GetDailyImageUseCase,
    private val getPlanetDataUseCase: GetPlanetDataUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SolarSystemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SolarSystemViewModel(getDailyImageUseCase, getPlanetDataUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}