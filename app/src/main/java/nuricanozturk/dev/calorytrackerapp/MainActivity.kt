package nuricanozturk.dev.calorytrackerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import nuricanozturk.dev.calorytrackerapp.navigation.navigate
import nuricanozturk.dev.calorytrackerapp.ui.theme.CaloryTrackerAppTheme
import nuricanozturk.dev.core.navigation.Route
import nuricanozturk.dev.onboarding_presentation.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Route.WELCOME) {
                    composable(Route.WELCOME) {
                        WelcomeScreen(onNavigate = navController::navigate)
                    }

                    composable(Route.AGE) {

                    }

                    composable(Route.GENDER) {

                    }

                    composable(Route.HEIGHT) {

                    }

                    composable(Route.WEIGHT) {

                    }

                    composable(Route.NUTRIENT_GOAL) {

                    }

                    composable(Route.ACTIVITY) {

                    }

                    composable(Route.GOAL) {

                    }

                    composable(Route.TRACKER_OVERVIEW) {

                    }

                    composable(Route.SEARCH) {

                    }
                }
            }
        }
    }
}