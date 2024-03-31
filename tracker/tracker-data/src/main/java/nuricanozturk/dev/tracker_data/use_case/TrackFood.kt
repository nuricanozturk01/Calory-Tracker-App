package nuricanozturk.dev.tracker_data.use_case


import nuricanozturk.dev.tracker_data.local.model.MealType
import nuricanozturk.dev.tracker_data.local.model.TrackableFood
import nuricanozturk.dev.tracker_data.local.model.TrackedFood
import nuricanozturk.dev.tracker_data.repository.ITrackerRepository
import java.time.LocalDate
import kotlin.math.roundToInt

class TrackFood(private val repository: ITrackerRepository) {

    suspend operator fun invoke(
        food: TrackableFood,
        amount: Int,
        mealType: MealType,
        date: LocalDate
    ) {
        repository.insertTrackedFood(
            TrackedFood(
                food.name,
                ((food.carbsPer100g / 100f) * amount).roundToInt(),
                ((food.proteinPer100g / 100f) * amount).roundToInt(),
                ((food.fatPer100g / 100f) * amount).roundToInt(),
                food.imageUrl,
                mealType,
                amount,
                date,
                ((food.caloriesPer100g / 100f) * amount).roundToInt()
            )
        )
    }
}