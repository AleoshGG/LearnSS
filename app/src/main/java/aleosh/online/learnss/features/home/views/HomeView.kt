package aleosh.online.learnss.features.home.views

import aleosh.online.learnss.core.ui.theme.LearnSSTheme
import aleosh.online.learnss.R
import aleosh.online.learnss.features.home.components.PulsingButton
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeView(navToLessons: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(32.dp)
    ) {

        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.ic_home_background), // Reemplaza con tu ID
            contentDescription = "background",
            modifier = Modifier
                .offset(x = 145.dp, y = 32.dp)
                .size(700.dp)
                .align(Alignment.BottomEnd),
            contentScale = ContentScale.Fit,
            alpha = 0.7f
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 150.dp, horizontal = 75.dp)
        ) {
            Text(
                text = "Welcome!",
                color = Color.White,
                style = MaterialTheme.typography.displayLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "This app helps make your learning\n\nmore interesting",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 25.sp
                )
            )

        }

        PulsingButton(
            modifier = Modifier
                .padding(horizontal = 100.dp)
                .align(Alignment.Center)
                .fillMaxWidth()
        ) {
            navToLessons()
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 75.dp, bottom = 32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo_background), // Reemplaza con tu ID
                contentDescription = "NASA Logo",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "All information is obtained\ndirectly from NASA.",
                color = Color.White,
                style = MaterialTheme.typography.labelLarge
            )
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
        HomeView(navToLessons = {})
    }
}
