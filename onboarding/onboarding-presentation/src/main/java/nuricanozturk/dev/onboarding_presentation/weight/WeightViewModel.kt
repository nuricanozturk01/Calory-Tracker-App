package nuricanozturk.dev.onboarding_presentation.weight

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
import nuricanozturk.dev.core.util.UiText
import javax.inject.Inject

@HiltViewModel
class WeightViewModel @Inject constructor(
    private val preferences: IPreferences
) : ViewModel() {

    var weight by mutableStateOf("105.0")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onWeightEnter(weight: String) {
        if (weight.length <= 5)
            this.weight = weight
    }

    fun onNextClick() {
        viewModelScope.launch {
            val heightNumber = weight.toFloatOrNull() ?: kotlin.run {
                _uiEvent.send(UiEvent.ShowSnackbar(UiText.StringResource(nuricanozturk.dev.core.R.string.error_weight_cant_be_empty)))
                return@launch
            }

            preferences.saveWeight(heightNumber)
            _uiEvent.send(UiEvent.Navigate(Route.ACTIVITY))
        }

    }
}