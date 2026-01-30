package aleosh.online.learnss.features.home.views

import aleosh.online.learnss.R
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.LearnSSTheme

@Composable
fun HomeView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(32.dp)
    ) {

        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.ic_home_background), // Reemplaza con tu ID
            contentDescription = null,
            modifier = Modifier
                .offset(x = 145.dp, y = 32.dp)
                .size(700.dp)
                .align(Alignment.BottomEnd),
            contentScale = ContentScale.Fit,
            alpha = 0.7f
        )



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
        HomeView()
    }
}