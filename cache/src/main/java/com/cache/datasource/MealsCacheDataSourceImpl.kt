package com.cache.datasource

import com.cache.mapper.MealsDetailsCacheEntityMapper
import com.cache.room.CookBookDB
import com.data.datasource.cache.MealCacheDataSource
import com.data.entity.MealDetailsEntity
import javax.inject.Inject

class MealsCacheDataSourceImpl @Inject constructor(
    private val cookBookDB: CookBookDB,
    private val mapper: MealsDetailsCacheEntityMapper
) : MealCacheDataSource {
    override fun putMeal(mealDetails: MealDetailsEntity) {
        cookBookDB.mealsDetailsDAO().insert(mapper.reverseMap(mealDetails))
    }

    override fun getMeal(mealID: String): MealDetailsEntity? {
        val meal = cookBookDB.mealsDetailsDAO().getMealByID(mealID)

        return if (meal != null) mapper.map(meal) else null
    }

    override fun clear() {

    }

}