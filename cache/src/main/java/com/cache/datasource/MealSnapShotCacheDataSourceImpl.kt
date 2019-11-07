package com.cache.datasource

import com.cache.mapper.MealSnapShotCacheEntityMapper
import com.cache.room.CookBookDB
import com.data.datasource.cache.MealSnapShotCacheDataSource
import com.data.entity.MealSnapshotEntity
import javax.inject.Inject

class MealSnapShotCacheDataSourceImpl @Inject constructor(
    private val cookBookDB: CookBookDB,
    private val mapper: MealSnapShotCacheEntityMapper
) : MealSnapShotCacheDataSource {
    override fun putMealSnapShotList(mealSnapShotList: List<MealSnapshotEntity>) {
        cookBookDB.mealsSnapshotDAO().bulkInsert(mapper.reverseMap(mealSnapShotList))
    }

    override fun getMealSnapShotList(categoryName: String): List<MealSnapshotEntity>? {
        return mapper.map(cookBookDB.mealsSnapshotDAO().getMealMenu(categoryName))
    }

    override fun clear() {
    }

}