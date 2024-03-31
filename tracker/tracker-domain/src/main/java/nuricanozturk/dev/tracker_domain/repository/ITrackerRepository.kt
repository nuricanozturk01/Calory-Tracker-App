package nuricanozturk.dev.tracker_domain.repository

import kotlinx.coroutines.flow.Flow
import nuricanozturk.dev.tracker_domain.model.TrackableFood
import nuricanozturk.dev.tracker_domain.model.TrackedFood

import java.time.LocalDate


interface ITrackerRepository {
    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>

    suspend fun insertTrackedFood(food: TrackedFood)

    suspend fun deleteTrackedFood(food: TrackedFood)

    fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>>
}