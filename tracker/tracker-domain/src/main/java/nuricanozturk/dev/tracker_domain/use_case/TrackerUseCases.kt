package nuricanozturk.dev.tracker_domain.use_case

import nuricanozturk.dev.tracker_data.use_case.CalculateMealNutrients
import nuricanozturk.dev.tracker_data.use_case.DeleteTrackedFood
import nuricanozturk.dev.tracker_data.use_case.GetFoodsForDate
import nuricanozturk.dev.tracker_data.use_case.SearchFood
import nuricanozturk.dev.tracker_data.use_case.TrackFood

// Facade for Use cases
data class TrackerUseCases(
    val trackFood: TrackFood,
    val searchFood: SearchFood,
    val getFoodsForDate: GetFoodsForDate,
    val deleteTrackedFood: DeleteTrackedFood,
    val calculateMealNutrients: CalculateMealNutrients
)