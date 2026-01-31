package aleosh.online.learnss.features.lessons.planets.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
fun CardPlanet(
    urlImage: String,
    title: String,
    description: String,
) {

    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                expanded = !expanded
            },
        shape = MaterialTheme.shapes.medium

    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            modifier = Modifier
                .padding(top = 16.dp, start = 32.dp, end = 32.dp)
                .fillMaxWidth()
        )

        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(urlImage)
                .crossfade(true)
                .build(),
            contentDescription = "Daily space image",
            contentScale = ContentScale.Crop,
            // Modifier para el tamaño y forma
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = 4.dp)
                .fillMaxWidth()
                .height(240.dp)
                .clip(RoundedCornerShape(8.dp)),

            // Bloque de carga: Se muestra mientras la imagen se descarga
            loading = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    // Animación circular (Spinner)
                    CircularProgressIndicator(
                        modifier = Modifier.size(32.dp),
                        color = MaterialTheme.colorScheme.primary,
                        strokeWidth = 3.dp
                    )
                }
            },

            // Opcional: Bloque de error si falla la carga
            error = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Error loading image", color = Color.Red, fontSize = 12.sp)
                }
            }
        )

        Text(
            text = "Description:",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, bottom = 4.dp),
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray,
        )

        Text(
            text = description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, bottom = 16.dp),
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.labelLarge,
            color = Color.White,
            maxLines = if(expanded) Int.MAX_VALUE else 1,
        )
    }
}