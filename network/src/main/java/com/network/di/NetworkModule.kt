package com.network.di

import com.data.datasource.network.CategoryNetworkDataSource
import com.data.datasource.network.MealNetworkDatasource
import com.data.datasource.network.MealSnapShotNetworkDataSource
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.network.BuildConfig
import com.network.datasource.CategoryNetworkDataSourceImpl
import com.network.datasource.MealNetworkDataSourceImpl
import com.network.datasource.MealSnapShotNetworkDataSourceImpl
import com.network.exception.NetworkExceptionInterceptor
import com.network.service.RecipeService
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [NetworkModule.Providers::class])
abstract class NetworkModule {

    @Binds
    abstract fun mealsDetailsDataSource(
        mealsNetworkDataSource: MealNetworkDataSourceImpl
    ): MealNetworkDatasource

    @Binds
    abstract fun mealSnapshotsDataSource(
        mealSnapShotNetworkDataSource: MealSnapShotNetworkDataSourceImpl
    ): MealSnapShotNetworkDataSource

    @Binds
    abstract fun categoryDataSource(
        categoryDataSource: CategoryNetworkDataSourceImpl
    ): CategoryNetworkDataSource


    @Module
    object Providers {
        @JvmStatic
        @Provides
        @Singleton
        fun okHttpClient(): OkHttpClient {
            val builder = OkHttpClient.Builder()
            val loggerInterceptor = HttpLoggingInterceptor()
            when (BuildConfig.DEBUG) {
                true -> loggerInterceptor.level = HttpLoggingInterceptor.Level.BODY
                false -> loggerInterceptor.level = HttpLoggingInterceptor.Level.NONE
            }

            builder.addInterceptor(loggerInterceptor)
                .addInterceptor(NetworkExceptionInterceptor())
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .cache(null)
            return builder.build()
        }

        @JvmStatic
        @Provides
        @Singleton
        fun retrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()


        @JvmStatic
        @Provides
        @Singleton
        fun gson(): Gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setLenient()
            .create()


        @JvmStatic
        @Provides
        @Singleton
        fun recipeService(retrofit: Retrofit): RecipeService =
            retrofit.create(RecipeService::class.java)

    }
}