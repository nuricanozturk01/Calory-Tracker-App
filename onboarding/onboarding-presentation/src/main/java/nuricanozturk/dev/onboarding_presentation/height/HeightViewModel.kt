package nuricanozturk.dev.onboarding_presentation.height

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
class HeightViewModel @Inject constructor(
    private val preferences: IPreferences,
    private val filterOurDigits: FilterOutDigits
) : ViewModel() {

    var height by mutableStateOf("174")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onHeightEnter(height: String) {
        if (height.length <= 3)
            this.height = filterOurDigits(height)
    }

    fun onNextClick() {
        viewModelScope.launch {
            val heightNumber = height.toIntOrNull() ?: kotlin.run {
                _uiEvent.send(UiEvent.ShowSnackbar(UiText.StringResource(nuricanozturk.dev.core.R.string.error_height_cant_be_empty)))
                return@launch
            }

            preferences.saveHeight(heightNumber)
            _uiEvent.send(UiEvent.Navigate(Route.WEIGHT))
        }

    }
}