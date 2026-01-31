package aleosh.online.learnss.features.lessons.planets.ui.views

import aleosh.online.learnss.core.ui.layout.TitlePageLayout
import aleosh.online.learnss.core.ui.theme.LearnSSTheme
import aleosh.online.learnss.features.lessons.planets.domain.entities.PlanetParams
import aleosh.online.learnss.features.lessons.planets.ui.components.CardPlanet
import aleosh.online.learnss.features.lessons.planets.ui.viewModels.PlanetViewModel
import aleosh.online.learnss.features.lessons.planets.ui.viewModels.PlanetViewModelFactory
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PlanetView(
    factory: PlanetViewModelFactory,
    planetParams: PlanetParams,
) {

    val viewModel: PlanetViewModel = viewModel(factory = factory)
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    viewModel.getPlanet(planetParams)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(32.dp)
    ) {

        TitlePageLayout(title = planetParams.q.split(' ')[0])

        LazyVerticalGrid(
            columns = GridCells.Fixed(1), // 2 columnas fijas
            horizontalArrangement = Arrangement.spacedBy(16.dp), // Espacio horizontal entre cards
            verticalArrangement = Arrangement.spacedBy(16.dp),   // Espacio vertical entre cards
            contentPadding = PaddingValues(bottom = 16.dp),      // Padding final para no cortar el último elemento
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(uiState.planet.imagesUrl) { planet ->
                CardPlanet(
                    urlImage = planet,
                    title = uiState.planet.title,
                    description = uiState.planet.description,
                )
            }
        }


    }
}

@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Tablet Preview",
    device = "spec:width=800dp,height=1280dp,dpi=240"
)
@Composable
fun HomeViewPreview() {
    LearnSSTheme {
        //PlanetView()
    }
}