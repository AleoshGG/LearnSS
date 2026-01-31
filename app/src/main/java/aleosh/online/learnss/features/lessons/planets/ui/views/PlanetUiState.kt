package aleosh.online.learnss.features.lessons.planets.ui.views

import aleosh.online.learnss.features.lessons.planets.domain.entities.Planet


data class PlanetUiState (
    val isLoading: Boolean = false,
    val planets: List<Planet> = emptyList(),
    val error: String? = null,
    val isRefreshing: Boolean = false
)
