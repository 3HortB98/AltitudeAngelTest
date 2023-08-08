package com.example.altitudeangeltest.di

import android.net.Uri
import androidx.core.net.toUri
import com.example.altitudeangeltest.utils.Constants.API
import com.example.altitudeangeltest.utils.Constants.FORECAST_URI
import com.example.altitudeangeltest.utils.DispatcherProvider
import com.example.altitudeangeltest.utils.DispatcherProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesDispatcherProvider(): DispatcherProvider = DispatcherProviderImpl


    @Provides
    @Named(FORECAST_URI)
    fun provideHost(): Uri = API.toUri()
}
