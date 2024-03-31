package nuricanozturk.dev.tracker_domain.use_case

import nuricanozturk.dev.tracker_domain.repository.ITrackerRepository
import nuricanozturk.dev.tracker_domain.model.TrackableFood

class SearchFood(private val repository: ITrackerRepository) {

    suspend operator fun invoke(
        query: String,
        page: Int = 1,
        pageSize: Int = 40
    ): Result<List<TrackableFood>> {
        if (query.isBlank())
            return Result.success(emptyList())
        return repository.searchFood(query.trim(), page, pageSize)
    }
}