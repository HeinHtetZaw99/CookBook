package com.cache.room.daos

import androidx.room.Dao
import androidx.room.Query
import com.cache.entity.MealDetailsCacheEntity

@Dao
interface MealDetailsDAO : BaseDAO<MealDetailsCacheEntity> {
    @Query(value = "SELECT * FROM meals_details where mealID =:mealID")
    fun getMealByID(mealID: String): MealDetailsCacheEntity?
}