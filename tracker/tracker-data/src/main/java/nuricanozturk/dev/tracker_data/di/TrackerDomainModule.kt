package nuricanozturk.dev.tracker_data.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import nuricanozturk.dev.core.domain.preferences.IPreferences
import nuricanozturk.dev.tracker_data.repository.ITrackerRepository
import nuricanozturk.dev.tracker_data.use_case.CalculateMealNutrients
import nuricanozturk.dev.tracker_data.use_case.DeleteTrackedFood
import nuricanozturk.dev.tracker_data.use_case.GetFoodsForDate
import nuricanozturk.dev.tracker_data.use_case.SearchFood
import nuricanozturk.dev.tracker_data.use_case.TrackFood
import nuricanozturk.dev.tracker_data.use_case.TrackerUseCases

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {
    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        repository: ITrackerRepository,
        preferences: IPreferences
    ): TrackerUseCases {
        return TrackerUseCases(
            trackFood = TrackFood(repository),
            searchFood = SearchFood(repository),
            getFoodsForDate = GetFoodsForDate(repository),
            deleteTrackedFood = DeleteTrackedFood(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences)
        )
    }
}