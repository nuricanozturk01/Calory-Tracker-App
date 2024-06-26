package nuricanozturk.dev.tracker_domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import nuricanozturk.dev.tracker_domain.local.ITrackerDao
import nuricanozturk.dev.tracker_domain.mapper.toTrackableFood
import nuricanozturk.dev.tracker_domain.mapper.toTrackedFood
import nuricanozturk.dev.tracker_domain.mapper.toTrackedFoodEntity
import nuricanozturk.dev.tracker_domain.remote.IOpenFoodApi
import nuricanozturk.dev.tracker_domain.model.TrackableFood
import nuricanozturk.dev.tracker_domain.model.TrackedFood

import java.time.LocalDate
import javax.inject.Inject

class TrackerRepositoryImpl @Inject constructor(
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

    override fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>> {
        return dao.getFoodsForDate(
            day = localDate.dayOfMonth,
            month = localDate.monthValue,
            year = localDate.year
        ).map { entities ->
            entities.map { it.toTrackedFood() }
        }
    }
}