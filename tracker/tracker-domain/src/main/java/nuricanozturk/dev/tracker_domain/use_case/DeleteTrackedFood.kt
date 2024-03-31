package nuricanozturk.dev.tracker_domain.use_case

import nuricanozturk.dev.tracker_domain.model.TrackedFood
import nuricanozturk.dev.tracker_domain.repository.ITrackerRepository

class DeleteTrackedFood(private val repository: ITrackerRepository) {

    suspend operator fun invoke(food: TrackedFood) {
        return repository.deleteTrackedFood(food)
    }
}