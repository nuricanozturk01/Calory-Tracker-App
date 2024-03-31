package nuricanozturk.dev.tracker_data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import nuricanozturk.dev.tracker_data.remote.IOpenFoodApi
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OpenFoodApiModule {

    @Provides
    @Singleton
    fun provideOpenFoodApiModule(retrofit: Retrofit): IOpenFoodApi {
        return retrofit.create(IOpenFoodApi::class.java)
    }
}