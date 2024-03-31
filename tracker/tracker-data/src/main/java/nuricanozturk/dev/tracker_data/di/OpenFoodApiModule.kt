package nuricanozturk.dev.tracker_data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import nuricanozturk.dev.tracker_data.remote.IOpenFoodApi
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object OpenFoodApiModule {

    @Provides
    fun provideOpenFoodApiModule(retrofit: Retrofit): IOpenFoodApi {
        return retrofit.create(IOpenFoodApi::class.java)
    }
}