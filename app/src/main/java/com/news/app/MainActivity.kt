package com.news.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.news.app.presentation.navgraph.NavGraph
import com.news.app.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * MainActivity is the entry point of the JetNews app. It extends ComponentActivity
 * and is annotated with @AndroidEntryPoint for Hilt integration.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // ViewModel instance obtained using viewModels delegate
    val viewModel by viewModels<MainViewModel>()

    /**
     * Overrides the onCreate method to set up the activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set system bars to be transparent and fit system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)
        // Install splash screen with a condition to keep it on screen based on MainViewModel's splashCondition
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.splashCondition
            }
        }
        // Set content of the activity
        setContent {
            // Apply NewsAppTheme to the content
            NewsAppTheme {
                // Check system's dark mode
                val isSystemInDarkMode = isSystemInDarkTheme()
                // Obtain system UI controller
                val systemController = rememberSystemUiController()
                // Apply system bar color based on dark mode
                SideEffect {
                    systemController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isSystemInDarkMode
                    )
                }
                // Set up the layout of the activity
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    // Obtain start destination from MainViewModel and navigate to NavGraph
                    val startDestination = viewModel.startDestination
                    NavGraph(startDestination = startDestination)
                }
            }
        }
    }
}
