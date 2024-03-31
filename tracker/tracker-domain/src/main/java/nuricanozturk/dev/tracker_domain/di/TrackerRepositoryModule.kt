package nuricanozturk.dev.tracker_domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nuricanozturk.dev.tracker_domain.local.ITrackerDao
import nuricanozturk.dev.tracker_domain.local.TrackerDatabase
import nuricanozturk.dev.tracker_domain.remote.IOpenFoodApi
import nuricanozturk.dev.tracker_domain.repository.TrackerRepositoryImpl
import nuricanozturk.dev.tracker_domain.repository.ITrackerRepository
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