package nuricanozturk.dev.tracker_domain.use_case

import nuricanozturk.dev.tracker_domain.repository.ITrackerRepository
import nuricanozturk.dev.tracker_domain.model.TrackedFood


class DeleteTrackedFood(private val repository: ITrackerRepository) {

    suspend operator fun invoke(food: TrackedFood) {
        return repository.deleteTrackedFood(food)
    }
}