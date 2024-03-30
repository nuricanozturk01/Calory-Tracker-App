package nuricanozturk.dev.calorytrackerapp.navigation

import androidx.navigation.NavController
import nuricanozturk.dev.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}