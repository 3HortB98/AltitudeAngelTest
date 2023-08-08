package com.example.altitudeangeltest.di

import android.app.Application
import android.content.Context
import android.net.Uri
import com.example.altitudeangeltest.data.api.ApiHelper
import com.example.altitudeangeltest.data.api.ApiHelperImpl
import com.example.altitudeangeltest.data.api.ForecastService
import com.example.altitudeangeltest.utils.Constants.API
import com.example.altitudeangeltest.utils.Constants.API_TIMEOUT
import com.example.altitudeangeltest.utils.Constants.CACHE_SIZE
import com.example.altitudeangeltest.utils.Constants.FORECAST_CLIENT
import com.example.altitudeangeltest.utils.Constants.FORECAST_URI
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun provideBaseUrl() = API

    @Provides
    @Singleton
    fun provideCache(application: Application): Cache {
        return Cache(application.cacheDir, CACHE_SIZE)
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Named(FORECAST_CLIENT)
    fun providesRetrofit(
        @Named(FORECAST_URI) baseUri: Uri,
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(baseUri.toString().toHttpUrl())
        .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        .build()

    @Provides
    fun providesOkHttpClient(
        @ApplicationContext context: Context,
        cache: Cache
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(provideHttpLoggingInterceptor())
        .readTimeout(API_TIMEOUT, TimeUnit.SECONDS)
        .callTimeout(API_TIMEOUT, TimeUnit.SECONDS)
        .cache(cache)
        .build()

    @Provides
    fun provideMoshi(): Moshi = Moshi
        .Builder()
        .add(Date::class.java, Rfc3339DateJsonAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun provideApiService(@Named(FORECAST_CLIENT) retrofit: Retrofit) : ForecastService = retrofit.create(ForecastService::class.java)

//    @Provides
//    @Singleton
//    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper
}
