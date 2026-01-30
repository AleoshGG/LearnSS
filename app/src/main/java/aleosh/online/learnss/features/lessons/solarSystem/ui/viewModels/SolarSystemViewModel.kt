package aleosh.online.learnss.features.lessons.solarSystem.ui.viewModels

import aleosh.online.learnss.features.lessons.solarSystem.domain.usecases.GetDailyImageUseCase
import aleosh.online.learnss.features.lessons.solarSystem.domain.usecases.GetPlanetDataUseCase
import aleosh.online.learnss.features.lessons.solarSystem.ui.views.DailyImageUiState
import aleosh.online.learnss.features.lessons.solarSystem.ui.views.PlanetDataUiState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SolarSystemViewModel (
    private val getDailyImageUseCase: GetDailyImageUseCase,
    private val getPlanetDataUseCase: GetPlanetDataUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(DailyImageUiState())
    val uiState: StateFlow<DailyImageUiState> = _uiState.asStateFlow()

    private val _uiStatePlanetData = MutableStateFlow(PlanetDataUiState())
    val uiStatePlanetData: StateFlow<PlanetDataUiState> = _uiStatePlanetData.asStateFlow()

    init {
        loadDailyImage()
        loadPlanetData()
    }

    private fun loadDailyImage() {
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val result = getDailyImageUseCase()
            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { data ->
                        currentState.copy(isLoading = false, dailyImage = data)
                    },
                    onFailure = { error ->
                        currentState.copy(isLoading = false, error = error.message)
                    }
                )
            }
        }
    }
    private fun loadPlanetData() {
        _uiStatePlanetData.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val result = getPlanetDataUseCase()
            _uiStatePlanetData.update { currentState ->
                result.fold(
                    onSuccess = { data ->
                        currentState.copy(isLoading = false, planetData = data)
                    },
                    onFailure = { error ->
                        currentState.copy(isLoading = false, error = error.message)
                    }
                )
            }
        }
    }


}