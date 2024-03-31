package nuricanozturk.dev.onboarding_presentation.nutrient_goal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import nuricanozturk.dev.core.domain.preferences.IPreferences
import nuricanozturk.dev.core.domain.usecase.FilterOutDigits
import nuricanozturk.dev.core.navigation.Route
import nuricanozturk.dev.core.util.UiEvent
import nuricanozturk.dev.onboarding_domain.use_case.ValidateNutrients
import javax.inject.Inject

@HiltViewModel
class NutrientGoalViewModel @Inject constructor(
    private val preferences: IPreferences,
    private val filterOutDigits: FilterOutDigits,
    private val validateNutrients: ValidateNutrients
) : ViewModel() {

    var state by mutableStateOf(NutrientGoalState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: NutrientGoalEvent) {
        when (event) {
            is NutrientGoalEvent.OnCarbRationEnter -> state =
                state.copy(carbsRatio = filterOutDigits(event.ratio))

            is NutrientGoalEvent.OnProteinRationEnter -> state =
                state.copy(proteinRatio = filterOutDigits(event.ratio))

            is NutrientGoalEvent.OnFatRationEnter -> state =
                state.copy(fatRatio = filterOutDigits(event.ratio))

            is NutrientGoalEvent.OnNextClick -> {
                val result = validateNutrients(state.carbsRatio, state.proteinRatio, state.fatRatio)

                when (result) {
                    is ValidateNutrients.Result.Success -> {
                        preferences.saveCarbRatio(result.carbsRatio)
                        preferences.saveFatRatio(result.fatRatio)
                        preferences.saveProteinRatio(result.proteinRatio)
                        viewModelScope.launch {
                            _uiEvent.send(UiEvent.Navigate(Route.TRACKER_OVERVIEW))
                        }

                    }

                    is ValidateNutrients.Result.Error -> {
                        viewModelScope.launch {
                            _uiEvent.send(UiEvent.ShowSnackbar(result.message))
                        }
                    }
                }

            }
        }
    }
}