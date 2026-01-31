package aleosh.online.learnss.features.lessons.planets.ui.views

import aleosh.online.learnss.core.ui.layout.TitlePageLayout
import aleosh.online.learnss.core.ui.theme.LearnSSTheme
import aleosh.online.learnss.features.lessons.solarSystem.ui.components.CardPlanet
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PlanetView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(32.dp)
    ) {
        TitlePageLayout(title = "planet")
        CardPlanet()
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
        PlanetView()
    }
}