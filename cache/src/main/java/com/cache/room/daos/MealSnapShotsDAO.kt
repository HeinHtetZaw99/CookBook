package com.cache.room.daos

import androidx.room.Dao
import androidx.room.Query
import com.cache.entity.MealSnapshotCacheEntity

@Dao
interface MealSnapShotsDAO : BaseDAO<MealSnapshotCacheEntity> {
    @Query(value = "SELECT * FROM meals where mealCategory =:category")
    fun getMealMenu(category: String): List<MealSnapshotCacheEntity>

    @Query(value = "SELECT * FROM meals")
    fun getAllMealsFromMenu(): List<MealSnapshotCacheEntity>

}