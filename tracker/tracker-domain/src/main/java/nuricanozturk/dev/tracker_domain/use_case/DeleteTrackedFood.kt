package nuricanozturk.dev.tracker_domain.use_case

import nuricanozturk.dev.tracker_data.local.model.TrackedFood
import nuricanozturk.dev.tracker_data.repository.ITrackerRepository


class DeleteTrackedFood(private val repository: ITrackerRepository) {

    suspend operator fun invoke(food: TrackedFood) {
        return repository.deleteTrackedFood(food)
    }
}