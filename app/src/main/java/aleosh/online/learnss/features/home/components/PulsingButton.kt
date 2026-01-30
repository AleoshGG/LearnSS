package aleosh.online.learnss.features.home.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PulsingButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    // Configuración de la animación infinita
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")

    // Animamos la escala (tamaño)
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.1f, // Crece un 10%
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing), // 1 segundo
            repeatMode = RepeatMode.Reverse // Va y regresa
        ),
        label = "scale"
    )

    // Animamos la opacidad (opcional, para darle más efecto)
    val alpha by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0.7f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha"
    )

    Row(
        modifier = modifier
            .scale(scale) // Aplicamos la escala animada
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Get Start",
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        // Icono de "Play" o flecha hueca
        Icon(
            imageVector = Icons.Default.PlayArrow, // O usa tu propio vector drawable
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(32.dp)
        )
    }
}