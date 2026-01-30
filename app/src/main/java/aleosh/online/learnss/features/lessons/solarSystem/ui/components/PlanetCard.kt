package aleosh.online.learnss.features.lessons.solarSystem.ui.components

import aleosh.online.learnss.features.lessons.solarSystem.domain.entities.PlanetData
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlanetCard(
    planet: PlanetData,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    val drawableId = remember(planet.imageRes) {
        context.resources.getIdentifier(
            planet.imageRes,
            "drawable",
            context.packageName
        )
    }

    Card(
        modifier = modifier.height(150.dp).fillMaxWidth(), // Altura fija para uniformidad
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerHighest)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            // Título
            Text(
                text = planet.name,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                // Imagen circular pequeña
                Image(
                    painter = painterResource(drawableId),
                    contentDescription = planet.name,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(15.dp))

                // Descripción pequeña
                Text(
                    text = planet.description,
                    color = Color.White,
                    fontSize = 14.sp,
                    lineHeight = 13.sp,
                    textAlign = TextAlign.End
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "See more...",
                color = Color.Gray,
                fontSize = 10.sp,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}