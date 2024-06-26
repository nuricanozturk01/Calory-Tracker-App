package nuricanozturk.dev.tracker_domain.local

import androidx.room.Database
import androidx.room.RoomDatabase
import nuricanozturk.dev.tracker_domain.local.entity.TrackedFoodEntity

@Database(
    entities = [TrackedFoodEntity::class],
    version = 1
)
abstract class TrackerDatabase : RoomDatabase() {

    abstract fun createTrackedFoodDao(): ITrackerDao
}