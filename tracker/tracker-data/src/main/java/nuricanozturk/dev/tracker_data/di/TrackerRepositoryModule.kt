package nuricanozturk.dev.tracker_data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nuricanozturk.dev.tracker_data.local.ITrackerDao
import nuricanozturk.dev.tracker_data.local.TrackerDatabase
import nuricanozturk.dev.tracker_data.remote.IOpenFoodApi
import nuricanozturk.dev.tracker_data.repository.ITrackerRepository
import nuricanozturk.dev.tracker_data.repository.TrackerRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TrackerRepositoryModule {

    @Provides
    @Singleton
    fun provideTrackerDao(trackerDatabase: TrackerDatabase): ITrackerDao {
        return trackerDatabase.createTrackedFoodDao()
    }

    @Provides
    @Singleton
    fun provideTrackerRepository(dao: ITrackerDao, api: IOpenFoodApi): ITrackerRepository {
        return TrackerRepositoryImpl(dao, api)
    }
}