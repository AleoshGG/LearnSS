package aleosh.online.learnss.features.lessons.solarSystem.ui.views

import aleosh.online.learnss.R
import aleosh.online.learnss.core.ui.layout.TitlePageLayout
import aleosh.online.learnss.core.ui.theme.LearnSSTheme
import aleosh.online.learnss.features.lessons.planets.domain.entities.PlanetParams
import aleosh.online.learnss.features.lessons.solarSystem.ui.components.DailyImageCard
import aleosh.online.learnss.features.lessons.solarSystem.ui.components.PlanetCard
import aleosh.online.learnss.features.lessons.solarSystem.ui.components.SunCard
import aleosh.online.learnss.features.lessons.solarSystem.ui.viewModels.SolarSystemViewModel
import aleosh.online.learnss.features.lessons.solarSystem.ui.viewModels.SolarSystemViewModelFactory
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import java.util.Date


@Composable
fun SolarSystemView(
    factory : SolarSystemViewModelFactory,
    navigateTo: (PlanetParams) -> Unit,
) {

    val viewModel: SolarSystemViewModel = viewModel(factory = factory)
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiStatePlanetData by viewModel.uiStatePlanetData.collectAsStateWithLifecycle()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 32.dp)
    ) {
        TitlePageLayout(title = "solar system")

        // Parte superior media
        Column(
            modifier = Modifier
                .weight(7.5f)
                .fillMaxSize()
                .padding(top=32.dp, start = 32.dp, end = 32.dp)
        ) {

            DailyImageCard(
                date = uiState.dailyImage.date,
                imageUrl = uiState.dailyImage.imgSource,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "We begin our journey through the center of the solar system, the Sun.",
                    color = Color.White,
                    fontSize = 22.sp,
                    lineHeight = 30.sp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 16.dp)
                )

                SunCard(
                    modifier = Modifier
                        .weight(1f)
                        .clickable{
                            navigateTo(uiStatePlanetData.planetData[0].planetParams)
                        },
                    planet = uiStatePlanetData.planetData[0],
                )
            }

        }

        Column(
            modifier = Modifier
                .weight(10f)
                .fillMaxSize()
                .padding(horizontal = 32.dp)
        ) {
            Text(
                text = "Continue your journey through the planets.",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 16.dp).fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2), // 2 columnas fijas
                horizontalArrangement = Arrangement.spacedBy(16.dp), // Espacio horizontal entre cards
                verticalArrangement = Arrangement.spacedBy(16.dp),   // Espacio vertical entre cards
                contentPadding = PaddingValues(bottom = 16.dp),      // Padding final para no cortar el último elemento
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(uiStatePlanetData.planetData.drop(1)) { planet ->
                    PlanetCard(
                        modifier = Modifier
                            .clickable{
                            navigateTo(planet.planetParams)
                        },
                        planet = planet,
                    )
                }
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
        //SolarSystemView()
    }
}