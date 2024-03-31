package nuricanozturk.dev.tracker_data.use_case

import kotlinx.coroutines.flow.Flow
import nuricanozturk.dev.tracker_data.local.model.TrackedFood
import nuricanozturk.dev.tracker_data.repository.ITrackerRepository
import java.time.LocalDate

class GetFoodsForDate(private val repository: ITrackerRepository) {

    operator fun invoke(date: LocalDate): Flow<List<TrackedFood>> {
        return repository.getFoodsForDate(date)
    }
}