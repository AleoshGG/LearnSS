package aleosh.online.learnss.features.lessons.solarSystem.ui.views

import aleosh.online.learnss.features.lessons.solarSystem.domain.entities.DailyImage

data class DailyImageUiState (
    val isLoading: Boolean = false,
    val dailyImage: DailyImage = DailyImage("" , ""),
    val error: String? = null,
    val isRefreshing: Boolean = false
)