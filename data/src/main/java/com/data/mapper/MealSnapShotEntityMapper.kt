package com.data.mapper

import com.data.entity.MealSnapshotEntity
import com.domain.mapper.BidirectionalMap
import com.domain.model.MealSnapshotVO
import javax.inject.Inject

@Suppress("LABEL_NAME_CLASH")
class MealSnapShotEntityMapper @Inject constructor() :
    BidirectionalMap<List<MealSnapshotVO>, List<MealSnapshotEntity>> {
    override fun map(data: List<MealSnapshotVO>): List<MealSnapshotEntity> {
        return data.map {
            return@map MealSnapshotEntity(
                mealID = it.mealID,
                mealThumbnail = it.mealThumbnail,
                mealName = it.mealName,
                mealCategory = it.categoryName
            )
        }
    }

    override fun reverseMap(data: List<MealSnapshotEntity>): List<MealSnapshotVO> {
        return data.map {
            return@map MealSnapshotVO(
                mealID = it.mealID,
                mealThumbnail = it.mealThumbnail,
                mealName = it.mealName
            )
        }
    }

}