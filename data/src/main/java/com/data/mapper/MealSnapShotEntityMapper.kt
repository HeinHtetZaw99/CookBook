package com.data.mapper

import com.data.entity.MealSnapshotEntity
import com.domain.mapper.BidirectionalMap
import com.domain.model.MealSnapshotVO
import javax.inject.Inject

class MealSnapShotEntityMapper @Inject constructor() :
    BidirectionalMap<List<MealSnapshotVO>, List<MealSnapshotEntity>> {
    override fun map(data: List<MealSnapshotVO>): List<MealSnapshotEntity> {
        val mappedList = ArrayList<MealSnapshotEntity>()

        for (entry in data) {
            val mealSnapshotEntity = MealSnapshotEntity(
                mealID = entry.mealID,
                mealThumbnail = entry.mealThumbnail,
                mealName = entry.mealName,
                mealCategory = entry.categoryName
            )
            mappedList.add(mealSnapshotEntity)
        }
        return mappedList
    }

    override fun reverseMap(data: List<MealSnapshotEntity>): List<MealSnapshotVO> {
        val reversedMappedList = ArrayList<MealSnapshotVO>()

        for (entry in data) {
            val mealSnapshotVO = MealSnapshotVO(
                mealID = entry.mealID,
                mealThumbnail = entry.mealThumbnail,
                mealName = entry.mealName
            )
            reversedMappedList.add(mealSnapshotVO)
        }
        return reversedMappedList
    }

}