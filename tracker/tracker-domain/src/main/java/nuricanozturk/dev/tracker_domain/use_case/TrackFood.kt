package nuricanozturk.dev.tracker_domain.use_case


import nuricanozturk.dev.tracker_domain.repository.ITrackerRepository
import nuricanozturk.dev.tracker_domain.model.MealType
import nuricanozturk.dev.tracker_domain.model.TrackableFood
import nuricanozturk.dev.tracker_domain.model.TrackedFood
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