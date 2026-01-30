package aleosh.online.learnss

import aleosh.online.learnss.core.ui.theme.LearnSSTheme
import aleosh.online.learnss.features.home.views.HomeView
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnSSTheme {
                HomeView()
            }
        }
    }
}



