package com.cache.di

import android.app.Application
import androidx.room.Room
import com.cache.datasource.CategoryCacheDataSourceImpl
import com.cache.datasource.MealSnapShotCacheDataSourceImpl
import com.cache.datasource.MealsCacheDataSourceImpl
import com.cache.room.CookBookDB
import com.data.datasource.cache.CategoryCacheDataSource
import com.data.datasource.cache.MealCacheDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [RoomModule.Providers::class])
abstract class RoomModule {

    @Binds
    abstract fun categoryCacheDataSource(
        categoryCacheDataSourceImpl: CategoryCacheDataSourceImpl
    ): CategoryCacheDataSource

    @Binds
    abstract fun mealsCacheDataSource(
        mealCacheDataSourceImpl: MealsCacheDataSourceImpl
    ): MealCacheDataSource

    @Binds
    abstract fun mealSnapshotCacheDataSource(
        mealSnapShotCacheDataSourceImpl: MealSnapShotCacheDataSourceImpl
    ): MealSnapShotCacheDataSourceImpl

    @Module
    internal object Providers {

        @Singleton
        @JvmStatic
        @Provides
        fun providesDB(application: Application) = Room.databaseBuilder(
            application,
            CookBookDB::class.java,
            "cookBook.db"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }


}