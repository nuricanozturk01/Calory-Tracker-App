package nuricanozturk.dev.tracker_data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import nuricanozturk.dev.tracker_data.local.ITrackerDao
import nuricanozturk.dev.tracker_data.local.entity.TrackedFoodEntity
import nuricanozturk.dev.tracker_data.mapper.toTrackableFood
import nuricanozturk.dev.tracker_data.mapper.toTrackedFood
import nuricanozturk.dev.tracker_data.mapper.toTrackedFoodEntity
import nuricanozturk.dev.tracker_data.remote.IOpenFoodApi
import nuricanozturk.dev.tracker_domain.model.TrackableFood
import nuricanozturk.dev.tracker_domain.model.TrackedFood
import nuricanozturk.dev.tracker_domain.repository.ITrackerRepository
import java.time.LocalDate

class TrackerRepositoryImpl(
    private val dao: ITrackerDao,
    private val api: IOpenFoodApi
) : ITrackerRepository {

    override suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>> {
        return try {
            val searchDto = api.searchFood(
                query = query,
                page = page,
                pageSize = pageSize
            )
            Result.success(
                searchDto.products.mapNotNull { it.toTrackableFood() }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun insertTrackedFood(food: TrackedFood) {
        dao.insertTrackedFood(food.toTrackedFoodEntity())
    }

    override suspend fun deleteTrackedFood(food: TrackedFood) {
        dao.deleteTrackedFood(food.toTrackedFoodEntity())
    }

    override suspend fun getFoodsForDate(date: LocalDate): Flow<List<TrackedFood>> {
        return dao.getFoodsForDate(
            day = date.dayOfMonth,
            month = date.monthValue,
            year = date.year
        ).map { entities ->
            entities.map { it.toTrackedFood() }
        }
    }
}