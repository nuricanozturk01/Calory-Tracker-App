package nuricanozturk.dev.tracker_domain.use_case

import kotlinx.coroutines.flow.Flow
import nuricanozturk.dev.tracker_domain.repository.ITrackerRepository
import nuricanozturk.dev.tracker_domain.model.TrackedFood
import java.time.LocalDate

class GetFoodsForDate(private val repository: ITrackerRepository) {

    operator fun invoke(date: LocalDate): Flow<List<TrackedFood>> {
        return repository.getFoodsForDate(date)
    }
}