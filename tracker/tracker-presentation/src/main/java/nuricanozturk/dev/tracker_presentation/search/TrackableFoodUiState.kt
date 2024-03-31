package nuricanozturk.dev.tracker_presentation.search

import nuricanozturk.dev.tracker_domain.model.TrackableFood

data class TrackableFoodUiState(
    val food: TrackableFood,
    val isExpanded: Boolean = false,
    val amount: String = ""
)
