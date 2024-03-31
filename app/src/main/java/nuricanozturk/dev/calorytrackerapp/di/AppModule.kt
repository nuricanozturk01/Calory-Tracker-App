package nuricanozturk.dev.calorytrackerapp.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nuricanozturk.dev.core.data.preferences.DefaultPreferences
import nuricanozturk.dev.core.domain.preferences.IPreferences
import nuricanozturk.dev.core.domain.usecase.FilterOutDigits
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providesSharedPreferences(app: Application): SharedPreferences {
        return app.getSharedPreferences("shared_pref", MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providesPreferences(sharedPref: SharedPreferences): IPreferences =
        DefaultPreferences(sharedPref)

    @Provides
    @Singleton
    fun provideFilterOutDigitsUseCase(): FilterOutDigits = FilterOutDigits()
}