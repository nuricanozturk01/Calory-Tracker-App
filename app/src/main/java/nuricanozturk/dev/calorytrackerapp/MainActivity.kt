package nuricanozturk.dev.calorytrackerapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import nuricanozturk.dev.calorytrackerapp.navigation.navigate
import nuricanozturk.dev.calorytrackerapp.ui.theme.CaloryTrackerAppTheme
import nuricanozturk.dev.core.navigation.Route
import nuricanozturk.dev.onboarding_presentation.activity.ActivityScreen
import nuricanozturk.dev.onboarding_presentation.age.AgeScreen
import nuricanozturk.dev.onboarding_presentation.gender.GenderScreen
import nuricanozturk.dev.onboarding_presentation.goal.GoalScreen
import nuricanozturk.dev.onboarding_presentation.height.HeightScreen
import nuricanozturk.dev.onboarding_presentation.nutrient_goal.NutrientGoalScreen
import nuricanozturk.dev.onboarding_presentation.weight.WeightScreen
import nuricanozturk.dev.onboarding_presentation.welcome.WelcomeScreen
import nuricanozturk.dev.tracker_presentation.tracker_overview.TrackerOverviewScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerAppTheme {
                val navController = rememberNavController()
                val scaffoldState = remember { SnackbarHostState() }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(hostState = scaffoldState) }) {

                    NavHost(navController = navController, startDestination = Route.WELCOME) {
                        composable(Route.WELCOME) {
                            WelcomeScreen(onNavigate = navController::navigate)
                        }

                        composable(Route.AGE) {

                            AgeScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate
                            )
                        }

                        composable(Route.GENDER) {
                            GenderScreen(onNavigate = navController::navigate)
                        }

                        composable(Route.HEIGHT) {
                            HeightScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate
                            )
                        }

                        composable(Route.WEIGHT) {
                            WeightScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate
                            )
                        }

                        composable(Route.NUTRIENT_GOAL) {
                            NutrientGoalScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate
                            )

                        }

                        composable(Route.ACTIVITY) {
                            ActivityScreen(onNavigate = navController::navigate)
                        }

                        composable(Route.GOAL) {
                            GoalScreen(onNavigate = navController::navigate)

                        }

                        composable(Route.TRACKER_OVERVIEW) {
                            TrackerOverviewScreen(onNavigate = navController::navigate)
                        }

                        composable(Route.SEARCH) {

                        }
                    }
                }

            }
        }
    }
}