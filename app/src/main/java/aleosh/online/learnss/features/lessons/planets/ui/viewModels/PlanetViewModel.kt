package aleosh.online.learnss.features.lessons.planets.ui.viewModels

import aleosh.online.learnss.features.lessons.planets.domain.entities.PlanetParams
import aleosh.online.learnss.features.lessons.planets.domain.usecases.GetPlanetUseCase
import aleosh.online.learnss.features.lessons.planets.ui.views.PlanetUiState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlanetViewModel(
    private val getPlanetUseCase: GetPlanetUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(PlanetUiState())
    val uiState: StateFlow<PlanetUiState> = _uiState.asStateFlow()

    fun getPlanet(params: PlanetParams) {
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val result = getPlanetUseCase(params)
            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { data ->
                        currentState.copy(isLoading = false, planets = data)
                    },
                    onFailure = { error ->
                        currentState.copy(isLoading = false, error = error.message)
                    }
                )
            }
        }

    }

}