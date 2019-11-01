package com.data.datasource.cache

import com.data.entity.MealSnapshotEntity

interface MealSnapShotCacheDataSource {
    fun putMealSnapShotList(mealSnapShotList: List<MealSnapshotEntity>)
    fun getMealSnapShotList(): List<MealSnapshotEntity>?
    fun clear()
}