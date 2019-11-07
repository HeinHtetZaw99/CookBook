package com.cache.mapper

import com.cache.entity.MealSnapshotCacheEntity
import com.data.entity.MealSnapshotEntity
import com.domain.mapper.BidirectionalMap
import javax.inject.Inject

class MealSnapShotCacheEntityMapper @Inject constructor() :
    BidirectionalMap<List<MealSnapshotCacheEntity>, List<MealSnapshotEntity>> {
    override fun map(data: List<MealSnapshotCacheEntity>): List<MealSnapshotEntity> {
        val mappedList = ArrayList<MealSnapshotEntity>()

        for (entry in data) {
            val mealSnapshotEntity = MealSnapshotEntity(
                mealID = entry.mealID,
                mealThumbnail = entry.mealThumbnail,
                mealName = entry.mealName,
                mealCategory = entry.mealCategory
            )
            mappedList.add(mealSnapshotEntity)
        }
        return mappedList
    }

    override fun reverseMap(data: List<MealSnapshotEntity>): List<MealSnapshotCacheEntity> {
        val reversedMappedList = ArrayList<MealSnapshotCacheEntity>()

        for (entry in data) {
            val mealSnapshotVO = MealSnapshotCacheEntity(
                mealID = entry.mealID!!,
                mealThumbnail = entry.mealThumbnail,
                mealName = entry.mealName,
                mealCategory = entry.mealCategory
            )
            reversedMappedList.add(mealSnapshotVO)
        }
        return reversedMappedList
    }
}