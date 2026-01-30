package aleosh.online.learnss.features.lessons.solarSystem.ui.views

import aleosh.online.learnss.features.lessons.solarSystem.domain.entities.PlanetData

data class PlanetDataUiState (
    val isLoading: Boolean = false,
    val planetData: List<PlanetData> = emptyList(),
    val error: String? = null,
    val isRefreshing: Boolean = false
)