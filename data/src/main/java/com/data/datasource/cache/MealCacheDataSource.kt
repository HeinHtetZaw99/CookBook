package com.data.datasource.cache

import com.data.entity.MealDetailsEntity

interface MealCacheDataSource {
    fun putMeal(mealDetails: MealDetailsEntity)
    fun getMeal(mealID : String): MealDetailsEntity?
    fun clear()
}