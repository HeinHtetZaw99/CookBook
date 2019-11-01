package com.appbase.di.module

import com.cache.di.RoomModule
import com.domain.repository.CategoryRepository
import com.domain.repository.MealDetailsRepository
import com.domain.repository.MealSnapShotRepository
import com.network.di.NetworkModule
import com.data.repository.CategoryRepositoryImpl
import com.data.repository.MealDetailsRepositoryImpl
import com.data.repository.MealSnapShotRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [RoomModule::class, NetworkModule::class])
abstract class RepositoryModule {
    @Binds
    abstract fun getCategoryList(categoryRepositoryImpl: CategoryRepositoryImpl): CategoryRepository

    @Binds
    abstract fun getMealDetails(mealDetailsRepositoryImpl: MealDetailsRepositoryImpl): MealDetailsRepository

    @Binds
    abstract fun getMealList(mealSnapShotRepositoryImpl: MealSnapShotRepositoryImpl): MealSnapShotRepository

}