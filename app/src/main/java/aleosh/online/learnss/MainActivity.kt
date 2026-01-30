package aleosh.online.learnss

import aleosh.online.learnss.core.di.AppContainer
import aleosh.online.learnss.core.navigation.NavigationWrapper
import aleosh.online.learnss.core.ui.theme.LearnSSTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {

    lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appContainer = AppContainer(this)

        enableEdgeToEdge()
        setContent {
            LearnSSTheme {
                NavigationWrapper(appContainer)
            }
        }
    }
}



